package com.ubmarketplace.app.controller;

import com.ubmarketplace.app.dto.GetItemDetailResponse;
import com.ubmarketplace.app.dto.image.UploadRequest;
import com.ubmarketplace.app.dto.image.UploadResponse;
import com.ubmarketplace.app.manager.ImageManager;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@Log
@Validated
public class GetItemDetailController {
    final ImageManager imageManager;

    @Autowired
    public GetItemDetailController(ImageManager imageManager) {
        this.imageManager = imageManager;
    }
    
    @RequestMapping(value = "/api/getItemDetail/{itemId}", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public GetItemDetailResponse getItemDetail(
            @PathVariable
            @Pattern(regexp="^[a-zA-Z0-9]{8}$", message = "ImageId format incorrect") String itemId){
        return new GetItemDetailResponse();
    }
}
