
package com.naha.crimereportingsystem.people;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PeopleController {

    @GetMapping("/")
    public String indexRoute() {
        return "people";
    }
}