package com.twitchclipapp.Logic;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpHandler {

    public static void makeRequest(String requestUrl, requestType type, Map<String, String> headers, int timeout) throws Exception {

        URL url = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        for(Map.Entry<String, String> entry : headers.entrySet()) {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }



    }

    public static void makeRequest(String requestUrl, requestType type, Map<String, String> headers) throws Exception {
        makeRequest(requestUrl, type, headers, 5000);
    }


    public static Map<String, String> addHeaders(String key, String value) {
        return new HashMap<String, String>() {{put(key, value);}};
    }


    public static Map<String, String> addHeaders(String key, String value, Map<String, String> headers) {
        headers.put(key, value);
        return headers;
    }


    public enum requestType {
        POST,
        GET,
        PUT,
        DELETE
    }
}
