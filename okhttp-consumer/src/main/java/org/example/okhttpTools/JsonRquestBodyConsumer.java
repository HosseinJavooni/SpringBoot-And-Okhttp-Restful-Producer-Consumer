package org.example.okhttpTools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.example.model.Person;

import java.io.IOException;

public class JsonRquestBodyConsumer {
    public static void main(String[] args) throws JsonProcessingException, IOException {
        var person = new Person("Hossein", "Jabani");
        var objectMapper = new ObjectMapper();
        String personAsString = objectMapper.writeValueAsString(person);
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), personAsString);
        Request request = new Request.Builder()
                .url(String.format("http://localhost:8080/jsonBody/%s","Hi"))
                .post(requestBody)
                .build();
        try(Response response = client.newCall(request).execute()){
            var responsePerson = objectMapper.readValue(response.body().string(), Person.class);
            String responsJsonBeautifiedString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(responsePerson);
            System.out.println(responsJsonBeautifiedString);
        }
    }
}
