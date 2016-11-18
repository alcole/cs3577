package com.alcole;

import com.google.gson.JsonParser;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Optional;


/**
 * Created by alex on 16/11/16.
 */
abstract class ServiceHelper {

    private static HttpClient client;
    private JsonParser parser;

    public ServiceHelper() {
        client = HttpClientBuilder.create().build();
        parser = new JsonParser();
    }

    protected JsonParser getParser() {
        return parser;
    }

    protected static HttpGet prepareRequest(String url, String parameter) {
        String finalUrl = url + parameter;
        return new HttpGet(finalUrl);
    }

    protected static Optional<String> getJSONresponse(HttpGet request) throws IOException {
        Optional<String> result = Optional.empty();
        HttpResponse response = client.execute(request);
        HttpEntity responseEntity = response.getEntity();
        if (responseEntity != null) {
            result = Optional.ofNullable(EntityUtils.toString(responseEntity));
        }
        return result;
    }
}
