package pt.vwds.fota.core.services.impl;

import org.springframework.stereotype.Service;
import pt.vwds.fota.core.model.HardwareComponent;
import pt.vwds.fota.core.model.SoftwareComponent;
import pt.vwds.fota.core.model.feature.Feature;
import pt.vwds.fota.core.model.vehicle.Vehicle;
import pt.vwds.fota.core.repositories.FeatureRepository;
import pt.vwds.fota.core.repositories.VehicleRepository;
import pt.vwds.fota.core.services.VehicleService;

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
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<String> getCompatibleFeatures(String vin) {
        Vehicle v = vehicleRepository.findById(vin).orElse(null);
        return featureRepository.findAll().stream()
                .filter(feature -> {
                    assert v != null;
                    return feature.isSatisfiedBy(v.getConfiguration());
                })
                .map(Feature::getId)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getIncompatibleFeatures(String vin) {
        Vehicle v = vehicleRepository.findById(vin).orElse(null);
        return featureRepository.findAll().stream()
                .filter(feature -> {
                    assert v != null;
                    return !feature.isSatisfiedBy(v.getConfiguration());
                })
                .map(Feature::getId)
                .collect(Collectors.toList());
    }
}
