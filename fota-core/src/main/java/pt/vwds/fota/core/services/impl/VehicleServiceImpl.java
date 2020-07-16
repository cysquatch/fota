package pt.vwds.fota.core.services.impl;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import pt.vwds.fota.core.model.HardwareComponent;
import pt.vwds.fota.core.model.SoftwareComponent;
import pt.vwds.fota.core.model.feature.Feature;
import pt.vwds.fota.core.model.vehicle.Vehicle;
import pt.vwds.fota.core.repositories.FeatureRepository;
import pt.vwds.fota.core.repositories.VehicleRepository;
import pt.vwds.fota.core.services.VehicleService;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final FeatureRepository featureRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository,
                              FeatureRepository featureRepository) {
        this.vehicleRepository = vehicleRepository;
        this.featureRepository = featureRepository;
    }

    @Override
    public void addHardwareConfiguration(String vin, Set<HardwareComponent> hardwareComponents) {
        vehicleRepository.findById(vin)
                .ifPresentOrElse(vehicle -> vehicleRepository.save(vehicle.addHardwareComponents(hardwareComponents)),
                        () -> vehicleRepository.save(Vehicle.createWithHardwareComponents(vin, hardwareComponents)));
    }

    @Override
    public void addSoftwareConfiguration(String vin, Set<SoftwareComponent> softwareComponents) {
        vehicleRepository.findById(vin)
                .ifPresentOrElse(vehicle -> vehicleRepository.save(vehicle.addSoftwareComponents(softwareComponents)),
                        () -> vehicleRepository.save(Vehicle.createWithSoftwareComponents(vin, softwareComponents)));
    }

    @Override
    public List<Vehicle> getAllVehicles(Integer pageNumber, Integer pageSize, Sort.Direction sortOrder) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortOrder, "vin"));
        Page<Vehicle> page =  vehicleRepository.findAll(pageable);
        return page.getContent();
    }

    @Override
    public List<String> getFeatures(Integer pageNumber, Integer pageSize, Sort.Direction sortOrder) {
        List<String> result = featureRepository.findAll().stream()
                .map(Feature::getId)
                .sorted(sortOrder.equals(Sort.Direction.ASC) ? Comparator.naturalOrder() : Comparator.reverseOrder())
                .collect(Collectors.toList());

        return page(pageNumber, pageSize, result);
    }

    @Override
    public List<String> getCompatibleFeatures(String vin, Integer pageNumber, Integer pageSize, Sort.Direction sortOrder) {
        Vehicle v = vehicleRepository.findById(vin).orElse(null);
        List<String> result = featureRepository.findAll().stream()
                .filter(feature -> {
                    assert v != null;
                    return feature.isSatisfiedBy(v.getConfiguration());
                })
                .map(Feature::getId)
                .sorted(sortOrder.equals(Sort.Direction.ASC) ? Comparator.naturalOrder() : Comparator.reverseOrder())
                .collect(Collectors.toList());

        return page(pageNumber, pageSize, result);
    }

    @Override
    public List<String> getIncompatibleFeatures(String vin, Integer pageNumber, Integer pageSize, Sort.Direction sortOrder) {
        Vehicle v = vehicleRepository.findById(vin).orElse(null);
        List<String> result = featureRepository.findAll().stream()
                .filter(feature -> {
                    assert v != null;
                    return !feature.isSatisfiedBy(v.getConfiguration());
                })
                .map(Feature::getId)
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
