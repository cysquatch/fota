package pt.vwds.fota.core.services;

import pt.vwds.fota.core.model.HardwareComponent;
import pt.vwds.fota.core.model.SoftwareComponent;
import pt.vwds.fota.core.model.vehicle.Vehicle;

import java.util.List;
import java.util.Set;

public interface VehicleService {
    void addHardwareConfiguration(String vin, Set<HardwareComponent> hardwareComponents);
    void addSoftwareConfiguration(String vin, Set<SoftwareComponent> softwareComponents);
    List<Vehicle> getAllVehicles(Integer pageNumber, Integer pageSize, String sortBy);
    List<String> getCompatibleFeatures(String vin, Integer pageNumber, Integer pageSize, String sortBy);
    List<String> getIncompatibleFeatures(String vin, Integer pageNumber, Integer pageSize, String sortBy);
}
