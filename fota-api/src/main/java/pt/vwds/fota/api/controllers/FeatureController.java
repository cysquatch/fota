package pt.vwds.fota.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.vwds.fota.core.model.feature.Feature;
import pt.vwds.fota.core.services.FeatureService;

import java.util.List;

@RestController
@RequestMapping("/fota/feature")
public class FeatureController {

    private final FeatureService featureService;

    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @GetMapping("")
    public List<Feature> getAll() {
        return featureService.getAllFeature();
    }

    @GetMapping("/{feature}")
    public List<String> getAllVin(@PathVariable String feature) {
        return null;
    }

    @GetMapping("/{feature}/compatible")
    public List<String> getCompatibleVin(@PathVariable String feature) {
        return featureService.getCompatibleVin(feature);
    }

    @GetMapping("/{feature}/incompatible")
    public List<String> getIncompatibleVin(@PathVariable String feature) {
        return featureService.getIncompatibleVin(feature);
    }

}
