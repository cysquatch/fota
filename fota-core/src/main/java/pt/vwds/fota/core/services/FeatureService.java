package pt.vwds.fota.core.services;

import pt.vwds.fota.core.model.feature.Feature;

import java.util.List;

public interface FeatureService {
    List<Feature> getAllFeature();
    List<String> getCompatibleVin(String feature);
    List<String> getIncompatibleVin(String feature);

}
