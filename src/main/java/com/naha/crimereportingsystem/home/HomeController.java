package com.naha.crimereportingsystem.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String HomeRoute() {
        return "home";
    }

    @GetMapping("/user")
    public String UserRoute() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/police")
    public String PoliceRoute() {
        return ("<h1>Welcome Police</h1>");
    }

    @GetMapping("/admin")
    public String AdminROutes() {
        return ("<h1>Welcome Admin</h1>");
    }
}