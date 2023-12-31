package com.example.SpringBootRestful.restController;

import com.example.SpringBootRestful.model.Person;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/formDataBody")
public class FormDataUrlEncodedController {
    @PostMapping(path = "/v1", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Person returnPersonFromFormDataV1(Person person){
        return new Person(person.getFirstName()+"-v1", person.getLastName()+"-v1");
    }
    @PostMapping("/v2")
    public Person returnPersonFromFormDataV2(@RequestBody MultiValueMap<String, String> body){
        return new Person(body.get("firstName").get(0)+"-v2", body.get("lastName").get(0)+"-v2");
    }
    @PostMapping("/v3")
    public Person returnPersonFromFormDataV2(@RequestParam Map<String, String> body){
        return new Person(body.get("firstName")+"-v3", body.get("lastName")+"-v3");
    }
}
