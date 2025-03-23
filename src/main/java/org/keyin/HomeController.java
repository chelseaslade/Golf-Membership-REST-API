package org.keyin;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "Welcome! Access points at /api/members and /api/tournaments/.";
    }
}