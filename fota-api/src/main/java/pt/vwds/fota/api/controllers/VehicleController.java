package pt.vwds.fota.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fota/vehicles")
public class VehicleController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }
}
