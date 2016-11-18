package com.alcole;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class AlbumLookUpService extends ServiceHelper{


    private static final String ALBUM_BY_ID_URL = "https://jsonplaceholder.typicode.com/albums?id=";


    public Optional<String> getTitle(String anId) {
        Optional result = Optional.empty();
        if (Objects.nonNull(anId)) {
            HttpGet request = prepareRequest(ALBUM_BY_ID_URL, anId);
            try {
                Optional<String> responseEntity = ServiceHelper.getJSONresponse(request);
                JsonArray ar = getParser().parse(responseEntity.get()).getAsJsonArray();
                if (ar.get(0) != null) {
                    JsonObject obj = ar.get(0).getAsJsonObject();
                    result = Optional.ofNullable(obj.get("title").getAsString());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

}
