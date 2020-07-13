package pt.vwds.fota.core.model.vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pt.vwds.fota.core.model.HardwareComponent;
import pt.vwds.fota.core.model.SoftwareComponent;

import java.util.Set;

@Getter
@AllArgsConstructor
public class ComponentsConfiguration {
    Set<HardwareComponent> hardwareComponents;
    Set<SoftwareComponent> softwareComponents;
}
