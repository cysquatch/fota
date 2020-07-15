package pt.vwds.fota.core.services;

import pt.vwds.fota.core.model.feature.Feature;

import java.util.List;

public interface FeatureService {
    List<Feature> getAllFeature(Integer pageNumber, Integer pageSize, String sortBy);
    List<String> getCompatibleVin(String feature, Integer pageNumber, Integer pageSize, String sortBy);
    List<String> getIncompatibleVin(String feature, Integer pageNumber, Integer pageSize, String sortBy);
}
