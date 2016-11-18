package com.alcole;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;


public class UserLookUpService extends ServiceHelper{

    //Bret //Antonette //Samantha
    private static final String USERS_BY_USERNAME_URL = "https://jsonplaceholder.typicode.com/users?username=";


    public Optional<String> getFullName(String aUserName) {
        Optional result = Optional.empty();
        if (Objects.nonNull(aUserName)) {
            HttpGet request = prepareRequest(USERS_BY_USERNAME_URL, aUserName);
            try {
                Optional<String> responseEntity = ServiceHelper.getJSONresponse(request);
                JsonArray ar = getParser().parse(responseEntity.get()).getAsJsonArray();
                if (ar.get(0) != null) {
                    JsonObject obj = ar.get(0).getAsJsonObject();
                    result = Optional.ofNullable(obj.get("name").getAsString());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return result;
    }


    public Optional<String> getPhoneNumberByUsername(String aUserName) {
        Optional result = Optional.empty();
        if (Objects.nonNull(aUserName)) {
            HttpGet request = prepareRequest(USERS_BY_USERNAME_URL, aUserName);

            try {
                Optional<String> responseEntity = ServiceHelper.getJSONresponse(request);
                if (responseEntity.isPresent()) {
                    JsonArray ar =  getParser().parse(responseEntity.get()).getAsJsonArray();
                    if (ar.get(0) != null) {
                        JsonObject obj = ar.get(0).getAsJsonObject();
                        result = Optional.ofNullable(obj.get("phone").getAsString());
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


}
