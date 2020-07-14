package pt.vwds.fota.core.services.impl;

import org.springframework.stereotype.Service;
import pt.vwds.fota.core.model.HardwareComponent;
import pt.vwds.fota.core.model.SoftwareComponent;
import pt.vwds.fota.core.model.vehicle.Vehicle;
import pt.vwds.fota.core.repositories.VehicleRepository;
import pt.vwds.fota.core.services.VehicleService;

import java.util.Set;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
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
}
