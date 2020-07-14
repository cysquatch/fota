package pt.vwds.fota.core.services;

import pt.vwds.fota.core.model.HardwareComponent;
import pt.vwds.fota.core.model.SoftwareComponent;

import java.util.Set;

public interface VehicleService {
    void addHardwareConfiguration(String vin, Set<HardwareComponent> hardwareComponents);
    void addSoftwareConfiguration(String vin, Set<SoftwareComponent> softwareComponents);
}
