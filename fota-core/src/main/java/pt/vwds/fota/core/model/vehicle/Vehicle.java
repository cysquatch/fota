package pt.vwds.fota.core.model.vehicle;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pt.vwds.fota.core.model.HardwareComponent;
import pt.vwds.fota.core.model.SoftwareComponent;

import java.util.Set;

@Builder
@Getter
@Document(collection = "vehicles")
public class Vehicle {
    @Id
    private final String vin;
    private final ComponentsConfiguration configuration;


    public Vehicle addHardwareComponents(Set<HardwareComponent> hardwareComponents) {
        this.configuration.addHardwareComponents(hardwareComponents);
        return this;
    }

    public Vehicle addSoftwareComponents(Set<SoftwareComponent> softwareComponents) {
        this.configuration.addSoftwareComponents(softwareComponents);
        return this;
    }

    public static Vehicle createWithHardwareComponents(String vin, Set<HardwareComponent> hardwareComponents) {
        return Vehicle.builder()
                .vin(vin)
                .configuration(ComponentsConfiguration.createWithHardwareComponents(hardwareComponents))
                .build();
    }

    public static Vehicle createWithSoftwareComponents(String vin, Set<SoftwareComponent> softwareComponents) {
        return Vehicle.builder()
                .vin(vin)
                .configuration(ComponentsConfiguration.createWithSoftwareComponents(softwareComponents))
                .build();
    }
}
