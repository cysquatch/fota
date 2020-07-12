package pt.vwds.fota.core.model.feature;

import lombok.Builder;
import pt.vwds.fota.core.model.ComponentsConfiguration;

import java.util.UUID;

@Builder
public class Feature {
    private final UUID id;
    private final SoftwareSpecification softwareSpecification;
    private final HardwareSpecification hardwareSpecification;

    public boolean isSatisfiedBy(ComponentsConfiguration componentsConfiguration) {
        return softwareSpecification.isSatisfiedBy(componentsConfiguration) &&
                hardwareSpecification.isSatisfiedBy(componentsConfiguration);
    }
}
