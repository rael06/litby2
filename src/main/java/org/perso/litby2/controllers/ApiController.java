package org.perso.litby2.controllers;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "api is running";
    }
}
