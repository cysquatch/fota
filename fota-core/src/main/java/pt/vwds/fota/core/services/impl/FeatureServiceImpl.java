package pt.vwds.fota.core.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pt.vwds.fota.core.model.feature.Feature;
import pt.vwds.fota.core.model.vehicle.Vehicle;
import pt.vwds.fota.core.repositories.FeatureRepository;
import pt.vwds.fota.core.repositories.VehicleRepository;
import pt.vwds.fota.core.services.FeatureService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepository featureRepository;
    private final VehicleRepository vehicleRepository;

    public FeatureServiceImpl(FeatureRepository featureRepository,
                              VehicleRepository vehicleRepository) {
        this.featureRepository = featureRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Feature> getAllFeature(Integer pageNumber, Integer pageSize, Sort.Direction sortOrder) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortOrder, "id"));
        Page<Feature> page =  featureRepository.findAll(pageable);
        return page.getContent();
    }

    @Override
    public List<String> getVin(Integer pageNumber, Integer pageSize, Sort.Direction sortOrder) {
        List<String> result = vehicleRepository.findAll().stream()
                .map(Vehicle::getVin)
                .sorted(sortOrder.equals(Sort.Direction.ASC) ? Comparator.naturalOrder() : Comparator.reverseOrder())
                .collect(Collectors.toList());

        return page(pageNumber, pageSize, result);
    }

    @Override
    public List<String> getCompatibleVin(String feature, Integer pageNumber, Integer pageSize, Sort.Direction sortOrder) {
        Feature f = featureRepository.findById(feature).orElse(null);
        List<String> result = vehicleRepository.findAll().stream()
                .filter(vehicle -> {
                    assert f != null;
                    return f.isSatisfiedBy(vehicle.getConfiguration());
                })
                .map(Vehicle::getVin)
                .sorted(sortOrder.equals(Sort.Direction.ASC) ? Comparator.naturalOrder() : Comparator.reverseOrder())
                .collect(Collectors.toList());

        return page(pageNumber, pageSize, result);
    }

    @Override
    public List<String> getIncompatibleVin(String feature, Integer pageNumber, Integer pageSize, Sort.Direction sortOrder) {
        Feature f = featureRepository.findById(feature).orElse(null);
        List<String> result = vehicleRepository.findAll().stream()
                .filter(vehicle -> {
                    assert f != null;
                    return !f.isSatisfiedBy(vehicle.getConfiguration());
                })
                .map(Vehicle::getVin)
                .sorted(sortOrder.equals(Sort.Direction.ASC) ? Comparator.naturalOrder() : Comparator.reverseOrder())
                .collect(Collectors.toList());

        return page(pageNumber, pageSize, result);
    }

    private <E> List<E> page(Integer pageNumber, Integer pageSize, List<E> content) {
        int start = pageNumber * pageSize;
        int end = Math.min((start + pageSize), content.size());
        return content.subList(start, end);
    }
}
