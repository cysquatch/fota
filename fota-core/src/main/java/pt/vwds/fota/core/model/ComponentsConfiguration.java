package pt.vwds.fota.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class ComponentsConfiguration {
    Set<HardwareCode> hardwareComponents;
    Set<SoftwareCode> softwareComponents;
}
