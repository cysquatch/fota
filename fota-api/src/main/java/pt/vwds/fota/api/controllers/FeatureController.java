package pt.vwds.fota.api.controllers;

import org.springframework.web.bind.annotation.*;
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
    public List<Feature> getAll(@RequestParam(defaultValue = "0") Integer pageNumber,
                                @RequestParam(defaultValue = Integer.MAX_VALUE + "") Integer pageSize,
                                @RequestParam(defaultValue = "id") String sortBy) {
        return featureService.getAllFeature(pageNumber, pageSize, sortBy);
    }

    @GetMapping("/{feature}")
    public List<String> getAllVin(@PathVariable String feature,
                                  @RequestParam(defaultValue = "0") Integer pageNumber,
                                  @RequestParam(defaultValue = Integer.MAX_VALUE + "") Integer pageSize,
                                  @RequestParam(defaultValue = "") String sortBy) {
        return null;
    }

    @GetMapping("/{feature}/compatible")
    public List<String> getCompatibleVin(@PathVariable String feature,
                                         @RequestParam(defaultValue = "0") Integer pageNumber,
                                         @RequestParam(defaultValue = Integer.MAX_VALUE + "") Integer pageSize,
                                         @RequestParam(defaultValue = "") String sortBy) {
        return featureService.getCompatibleVin(feature, pageNumber, pageSize, sortBy);
    }

    @GetMapping("/{feature}/incompatible")
    public List<String> getIncompatibleVin(@PathVariable String feature,
                                           @RequestParam(defaultValue = "0") Integer pageNumber,
                                           @RequestParam(defaultValue = Integer.MAX_VALUE + "") Integer pageSize,
                                           @RequestParam(defaultValue = "") String sortBy) {
        return featureService.getIncompatibleVin(feature, pageNumber, pageSize, sortBy);
    }
}
