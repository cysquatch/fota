package pt.vwds.fota.core.model.vehicle;

import lombok.Builder;
import lombok.Getter;
import pt.vwds.fota.core.model.HardwareComponent;
import pt.vwds.fota.core.model.SoftwareComponent;

import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
public class ComponentsConfiguration {
    private final Set<HardwareComponent> hardwareComponents;
    private final Set<SoftwareComponent> softwareComponents;

    protected void addHardwareComponents(Set<HardwareComponent> hardwareComponents) {
        this.hardwareComponents.addAll(hardwareComponents);
    }

    protected void addSoftwareComponents(Set<SoftwareComponent> softwareComponents) {
        this.softwareComponents.addAll(softwareComponents);
    }

    protected static ComponentsConfiguration createWithHardwareComponents(Set<HardwareComponent> hardwareComponents) {
        return ComponentsConfiguration.builder()
                .hardwareComponents(hardwareComponents)
                .softwareComponents(new HashSet<>())
                .build();
    }

    protected static ComponentsConfiguration createWithSoftwareComponents(Set<SoftwareComponent> softwareComponents) {
        return ComponentsConfiguration.builder()
                .hardwareComponents(new HashSet<>())
                .softwareComponents(softwareComponents)
                .build();
    }
}
