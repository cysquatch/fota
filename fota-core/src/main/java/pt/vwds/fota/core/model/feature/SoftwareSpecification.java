package pt.vwds.fota.core.model.feature;

import lombok.Builder;
import pt.vwds.fota.core.model.ComponentsConfiguration;
import pt.vwds.fota.core.model.SoftwareCode;

import java.util.Set;

@Builder
public class SoftwareSpecification {
    private final Set<SoftwareCode> mustHave;
    private final Set<SoftwareCode> cantHave;

    protected boolean isSatisfiedBy(ComponentsConfiguration componentsConfiguration) {
        return mustHave.containsAll(componentsConfiguration.getSoftwareComponents()) &&
                cantHave.stream().noneMatch(softwareCode -> componentsConfiguration.getSoftwareComponents().contains(softwareCode));
    }}
