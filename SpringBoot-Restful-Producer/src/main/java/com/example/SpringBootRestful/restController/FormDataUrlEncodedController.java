package com.example.SpringBootRestful.restController;

import com.example.SpringBootRestful.model.Person;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/formDataBody")
public class FormDataUrlEncodedController {
    /**
     * For calling from postman:
     *
     * curl --location 'http://localhost:8080/formDataBody/v1' \
     * --header 'Content-Type: application/x-www-form-urlencoded' \
     * --data-urlencode 'firstName=Hossein' \
     * --data-urlencode 'lastName=Jabani'
     */

    // curl -v -X POST "http://localhost:8080/formDataBody/v1" --data-urlencode 'firstName=Hossein' --data-urlencode 'lastName=Jabani' | json_pp
    @PostMapping(path = "/v1", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Person returnPersonFromFormDataV1(Person person){
        return new Person(person.getFirstName()+"-v1", person.getLastName()+"-v1");
    }

    /**
     * For calling from postman:
     *
     * curl --location 'http://localhost:8080/formDataBody/v2' \
     * --header 'Content-Type: application/x-www-form-urlencoded' \
     * --data-urlencode 'firstName=Hossein' \
     * --data-urlencode 'lastName=Jabani'
     *
     * @param body
     * @return
     */

    // curl -v -X POST "http://localhost:8080/formDataBody/v2" --data-urlencode 'firstName=Hossein' --data-urlencode 'lastName=Jabani' | json_pp
    @PostMapping("/v2")
    public Person returnPersonFromFormDataV2(@RequestBody MultiValueMap<String, String> body){
        return new Person(body.get("firstName").get(0)+"-v2", body.get("lastName").get(0)+"-v2");
    }

    /**
     * For "http://localhost:8080/formDataBody/v3" in postman you can use this curl:
     *
     * curl --location 'http://localhost:8080/formDataBody/v3' \
     * --header 'Content-Type: application/x-www-form-urlencoded' \
     * --form 'firstName="Hossein"' \
     * --form 'lastName="Jabani"'
     *
     * and this:
     *
     * curl --location 'http://localhost:8080/formDataBody/v3' \
     * --header 'Content-Type: application/x-www-form-urlencoded' \
     * --data-urlencode 'firstName=Hossein' \
     * --data-urlencode 'lastName=Jabani'
     *
     * @param body
     * @return
     */

    // curl -v -X POST "http://localhost:8080/formDataBody/v3" --data-urlencode 'firstName=Hossein' --data-urlencode 'lastName=Jabani' | json_pp
    @PostMapping("/v3")
    public Person returnPersonFromFormDataV2(@RequestParam Map<String, String> body){
        return new Person(body.get("firstName")+"-v3", body.get("lastName")+"-v3");
    }
}
