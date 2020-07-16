package pt.vwds.fota.core.services;

import org.springframework.data.domain.Sort;
import pt.vwds.fota.core.model.feature.Feature;

import java.util.List;

public interface FeatureService {
    List<Feature> getAllFeature(Integer pageNumber, Integer pageSize, Sort.Direction sortOrder);
    List<String> getVin(Integer pageNumber, Integer pageSize, Sort.Direction sortOrder);
    List<String> getCompatibleVin(String feature, Integer pageNumber, Integer pageSize, Sort.Direction sortOrder);
    List<String> getIncompatibleVin(String feature, Integer pageNumber, Integer pageSize, Sort.Direction sortOrder);
}
