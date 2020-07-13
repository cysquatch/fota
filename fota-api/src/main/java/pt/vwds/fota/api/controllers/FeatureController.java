package pt.vwds.fota.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.vwds.fota.core.model.feature.Feature;
import pt.vwds.fota.core.repositories.FeatureRepository;

import java.util.UUID;

@RestController
@RequestMapping("/fota/feature")
public class FeatureController {

    private final FeatureRepository featureRepository;

    public FeatureController(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @PostMapping("/create")
    public void create() {
        Feature f1 = Feature.builder().id(UUID.randomUUID()).build();
        featureRepository.save(f1);
    }
}
