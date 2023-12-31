package org.example.okhttpTools;

import okhttp3.*;

import java.io.IOException;

public class FormDataUrlEncodedConsumer {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("firstName", "Hosseeeeein")
                .add("lastName", "Jabaaaaani")
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8080/formDataBody/v1")
//                .url("http://localhost:8080/formDataBody/v2")
//                .url("http://localhost:8080/formDataBody/v3")
                .post(body)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();
        try(Response response = client.newCall(request).execute()){
            System.out.println(response.body().string());
        }
    }
}
