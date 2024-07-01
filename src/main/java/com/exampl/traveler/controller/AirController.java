package com.exampl.traveler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AirController {
    @GetMapping("/air")
    public String air() {
        return "air/airplane_main";
    }
}
