package org.fleetflow.fleetflow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   // <-- important!
public class ChauffeurController {

    @GetMapping("/chauffeur")   // <-- give it a path
    public String chauffeur() {
        return "Chauffeur";
    }
}

