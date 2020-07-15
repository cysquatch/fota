package pt.vwds.fota.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.vwds.fota.core.model.HardwareComponent;
import pt.vwds.fota.core.model.SoftwareComponent;
import pt.vwds.fota.core.model.feature.Feature;
import pt.vwds.fota.core.model.feature.HardwareSpecification;
import pt.vwds.fota.core.model.feature.SoftwareSpecification;
import pt.vwds.fota.core.repositories.FeatureRepository;

import java.util.Set;

@RestController
@RequestMapping("/fota/feature")
public class FeatureController {

    private final FeatureRepository featureRepository;

    public FeatureController(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

}
