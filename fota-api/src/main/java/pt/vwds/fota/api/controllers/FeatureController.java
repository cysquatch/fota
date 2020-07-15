package pt.vwds.fota.api.controllers;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pt.vwds.fota.core.model.feature.Feature;
import pt.vwds.fota.core.services.FeatureService;

import java.util.List;

@RestController
@RequestMapping("/fota/features")
public class FeatureController {

    private final FeatureService featureService;

    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @GetMapping("")
    public List<Feature> getAll(@RequestParam(defaultValue = "0") Integer pageNumber,
                                @RequestParam(defaultValue = Integer.MAX_VALUE + "") Integer pageSize,
                                @RequestParam(defaultValue = "ASC") String sortOrder) {
        return featureService.getAllFeature(pageNumber, pageSize, Sort.Direction.fromString(sortOrder));
    }

    @GetMapping("/{feature}")
    public List<String> getAllVin(@PathVariable String feature,
                                  @RequestParam(defaultValue = "0") Integer pageNumber,
                                  @RequestParam(defaultValue = Integer.MAX_VALUE + "") Integer pageSize,
                                  @RequestParam(defaultValue = "ASC") String sortOrder) {
        return null;
    }

    @GetMapping("/{feature}/compatible")
    public List<String> getCompatibleVin(@PathVariable String feature,
                                         @RequestParam(defaultValue = "0") Integer pageNumber,
                                         @RequestParam(defaultValue = Integer.MAX_VALUE + "") Integer pageSize,
                                         @RequestParam(defaultValue = "ASC") String sortOrder) {
        return featureService.getCompatibleVin(feature, pageNumber, pageSize, Sort.Direction.fromString(sortOrder));
    }

    @GetMapping("/{feature}/incompatible")
    public List<String> getIncompatibleVin(@PathVariable String feature,
                                           @RequestParam(defaultValue = "0") Integer pageNumber,
                                           @RequestParam(defaultValue = Integer.MAX_VALUE + "") Integer pageSize,
                                           @RequestParam(defaultValue = "ASC") String sortOrder) {
        return featureService.getIncompatibleVin(feature, pageNumber, pageSize, Sort.Direction.fromString(sortOrder));
    }
}
