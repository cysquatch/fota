package pt.vwds.fota.core;

import pt.vwds.fota.core.model.HardwareComponent;
import pt.vwds.fota.core.model.SoftwareComponent;
import pt.vwds.fota.core.model.feature.HardwareSpecification;
import pt.vwds.fota.core.model.feature.SoftwareSpecification;
import pt.vwds.fota.core.model.vehicle.ComponentsConfiguration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class CommonAbstractTest {

    HardwareComponent hardwareComponent1 = HardwareComponent.fromString("6VO6Uq");
    HardwareComponent hardwareComponent2 = HardwareComponent.fromString("ZCLFOe");
    HardwareComponent hardwareComponent3 = HardwareComponent.fromString("jyP5PK");

    SoftwareComponent softwareComponent1 = SoftwareComponent.fromString("ObZw28");
    SoftwareComponent softwareComponent2 = SoftwareComponent.fromString("YxKjcX");
    SoftwareComponent softwareComponent3 = SoftwareComponent.fromString("PWO7oa");

    Set<HardwareComponent> hardwareComponents = new HashSet<>(Arrays.asList(hardwareComponent1, hardwareComponent2));
    Set<SoftwareComponent> softwareComponents = new HashSet<>(Arrays.asList(softwareComponent1, softwareComponent2));

    ComponentsConfiguration componentsConfiguration = ComponentsConfiguration.builder()
            .hardwareComponents(hardwareComponents)
            .softwareComponents(softwareComponents)
            .build();

    SoftwareSpecification softwareSpecification = SoftwareSpecification.builder()
            .mustHave(Set.of(softwareComponent1, softwareComponent2))
            .cantHave(Set.of(softwareComponent3))
            .build();
    HardwareSpecification hardwareSpecification = HardwareSpecification.builder()
            .mustHave(Set.of(hardwareComponent1, hardwareComponent2))
            .cantHave(Set.of(hardwareComponent3))
            .build();
}
