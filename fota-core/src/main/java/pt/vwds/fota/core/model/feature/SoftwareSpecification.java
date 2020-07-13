package pt.vwds.fota.core.model.feature;

import lombok.Builder;
import pt.vwds.fota.core.model.vehicle.ComponentsConfiguration;
import pt.vwds.fota.core.model.SoftwareComponent;

import java.util.Set;

@Builder
public class SoftwareSpecification {
    private final Set<SoftwareComponent> mustHave;
    private final Set<SoftwareComponent> cantHave;

    protected boolean isSatisfiedBy(ComponentsConfiguration componentsConfiguration) {
        return mustHave.containsAll(componentsConfiguration.getSoftwareComponents()) &&
                cantHave.stream().noneMatch(softwareComponent -> componentsConfiguration.getSoftwareComponents().contains(softwareComponent));
    }}
