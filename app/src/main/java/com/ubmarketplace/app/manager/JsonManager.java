package com.ubmarketplace.app.manager;

import com.ubmarketplace.app.model.Item;

import java.util.List;

public class JsonManager {

    public String jsonKeyValPair(String key,String val) {
        return String.format("\"%s\": \"%s\"", key, val);
    }

    public String itemToJsonString(Item item) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(jsonKeyValPair("itemId", item.getItemId())).append(", ");
        sb.append(jsonKeyValPair("description", item.getDescription())).append(", ");
        sb.append(jsonKeyValPair("createdTime", Long.toString(item.getCreatedTime()))).append(", ");
        sb.append(jsonKeyValPair("name", item.getName())).append(", ");
        sb.append(jsonKeyValPair("meetingPlace", item.getMeetingPlace())).append(", ");
        sb.append(jsonKeyValPair("owner", item.getOwner().getUsername())).append(", ");
        sb.append(jsonKeyValPair("imageFilePath", item.getImageFilePath())).append(", ");
        sb.append(jsonKeyValPair("price", Double.toString(item.getPrice())));
        sb.append("}");

        return sb.toString();
    }

    public String itemListToJsonString(List<Item> items) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"items\":[");

        for (Item i : items) {
            sb.append(itemToJsonString(i)).append(", ");
        }

        if (items.size() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("]}");

        return sb.toString();
    }
}
