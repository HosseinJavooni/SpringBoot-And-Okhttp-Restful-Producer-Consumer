package org.example.okhttpTools;

import okhttp3.*;

import java.io.IOException;

public class FormDataUrlEncodedConsumer {
    /**
     * For calling from postman:
     *
     * curl --location 'http://localhost:8080/formDataBody/v1' \
     * --header 'Content-Type: application/x-www-form-urlencoded' \
     * --data-urlencode 'firstName=Hossein' \
     * --data-urlencode 'lastName=Jabani'
     *
     * Just for "http://localhost:8080/formDataBody/v3" in postman you can use this curl:
     *
     * curl --location 'http://localhost:8080/formDataBody/v3' \
     * --header 'Content-Type: application/x-www-form-urlencoded' \
     * --form 'firstName="Hossein"' \
     * --form 'lastName="Jabani"'
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("firstName", "Hosseeeeein")
                .add("lastName", "Jabaaaaani")
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8080/formDataBody/v3")
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
