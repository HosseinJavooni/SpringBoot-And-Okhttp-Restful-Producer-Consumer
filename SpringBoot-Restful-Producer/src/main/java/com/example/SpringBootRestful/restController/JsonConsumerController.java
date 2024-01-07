package com.example.SpringBootRestful.restController;

import com.example.SpringBootRestful.model.Person;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jsonBody")
@ResponseBody
public class JsonConsumerController {
    // curl -v -X POST "http://localhost:8080/jsonBody/Hi" -H "Content-Type: application/json" --data '{"firstName":"Hossein", "lastName":"Jabani"}'
    @PostMapping(path = "/{addThis}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person returnPerson(@PathVariable String addThis, @RequestBody Person person){
        person.setFirstName(person.getFirstName()+"-"+addThis);
        person.setLastName(person.getLastName()+"-"+addThis);
        return person;
    }
}
