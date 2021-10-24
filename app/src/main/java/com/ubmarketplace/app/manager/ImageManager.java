package com.ubmarketplace.app.manager;

import com.google.inject.Singleton;
import com.ubmarketplace.app.model.Image;
import com.ubmarketplace.app.repository.ImageRepository;
import com.ubmarketplace.app.repository.ImgBBRepository;
import lombok.NonNull;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.security.InvalidParameterException;

import static com.ubmarketplace.app.Static.IMGBB_API_URL;

@Singleton
@Component
@Log
public class ImageManager {
    @Value("${ImgBBApiKey}")
    private String ImgBBApiKey;

    final ImageRepository imageRepository;

    @Autowired
    public ImageManager(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image getImage(@NonNull String imageId) {
        if(imageId.isEmpty()) {
            log.info("Empty imageId when running getImage()");
            throw new InvalidParameterException("Empty imageId");
        }

        Image image;

        try {
            image = imageRepository.findById(imageId);
        } catch (DuplicateKeyException e) {
            log.warning(String.format("Failed to find imageId %s, no such image exist", imageId));
            throw new InvalidParameterException("Invalid imageId");
        }

        return image;
    }

    public String getThumbUrl(@NonNull String imageId) {
        return getImage(imageId).getThumb();
    }

    public String getMediumUrl(@NonNull String imageId) {
        return getImage(imageId).getMedium();
    }

    public String getLargeUrl(@NonNull String imageId) {
        return getImage(imageId).getLarge();
    }

    public Image uploadAndInsertImage(@NonNull String imageInBase64, @NonNull String userId) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("key", ImgBBApiKey);

        MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
        bodyMap.add("image", imageInBase64);

        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ImgBBRepository> response = restTemplate.exchange(IMGBB_API_URL, HttpMethod.POST, requestEntity,
                ImgBBRepository.class);

        if(response.getBody() == null){
            log.warning("Response body is empty when uploading image");
            throw new NullPointerException("Error while upload image");
        }


        Image image = Image.builder()
                .uploadBy(userId)
                .thumb(response.getBody().getData().getThumb().getUrl())
                .medium(response.getBody().getData().getMedium().getUrl())
                .large(response.getBody().getData().getImage().getUrl())
                .build();
        insertImage(image); // Todo: add retry when failed

        return image;
    }

    public void insertImage(@NonNull Image image) {
        try {
            imageRepository.insert(image);
        } catch (DuplicateKeyException e) {
            log.warning(String.format("Failed to find imageId %s, such image already exist", image));
            throw new InvalidParameterException("Failed to insert imageId");
        }
    }
}
