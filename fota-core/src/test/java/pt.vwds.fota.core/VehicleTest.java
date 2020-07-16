package pt.vwds.fota.core;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pt.vwds.fota.core.model.HardwareComponent;
import pt.vwds.fota.core.model.SoftwareComponent;
import pt.vwds.fota.core.model.vehicle.Vehicle;

import java.util.Set;

public class VehicleTest extends CommonAbstractTest{

    @Test
    @DisplayName("Create a vehicle and add configuration")
    void createVehicle() {
        Vehicle vehicle = Vehicle.builder()
                .vin("WAUHFBFL1DN549274")
                .configuration(componentsConfiguration)
                .build();

        Assert.assertEquals("WAUHFBFL1DN549274", vehicle.getVin());
        Assert.assertEquals(hardwareComponents, vehicle.getConfiguration().getHardwareComponents());
        Assert.assertEquals(softwareComponents, vehicle.getConfiguration().getSoftwareComponents());
    }

    @Test
    @DisplayName("Add components to a vehicle")
    void addComponentsToAVehicle() {
        Vehicle vehicle = Vehicle.builder()
                .vin("WAUHFBFL1DN549274")
                .configuration(componentsConfiguration)
                .build();

        Assert.assertEquals("WAUHFBFL1DN549274", vehicle.getVin());
        Assert.assertEquals(hardwareComponents, vehicle.getConfiguration().getHardwareComponents());
        Assert.assertEquals(softwareComponents, vehicle.getConfiguration().getSoftwareComponents());

        Set<HardwareComponent> updatedHardwareComponents = Set.of(hardwareComponent1, hardwareComponent2, hardwareComponent3);
        Set<SoftwareComponent> updatedSoftwareComponents = Set.of(softwareComponent1, softwareComponent2, softwareComponent3);

        vehicle.addHardwareComponents(Set.of(hardwareComponent3));
        vehicle.addSoftwareComponents(Set.of(softwareComponent3));

        Assert.assertEquals(updatedHardwareComponents, vehicle.getConfiguration().getHardwareComponents());
        Assert.assertEquals(updatedSoftwareComponents, vehicle.getConfiguration().getSoftwareComponents());
    }
}
