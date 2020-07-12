package pt.vwds.fota.core.model.feature;

import lombok.Builder;
import pt.vwds.fota.core.model.ComponentsConfiguration;
import pt.vwds.fota.core.model.HardwareCode;

import java.util.Set;

@Builder
public class HardwareSpecification {
    private final Set<HardwareCode> mustHave;
    private final Set<HardwareCode> cantHave;

    protected boolean isSatisfiedBy(ComponentsConfiguration componentsConfiguration) {
        return mustHave.containsAll(componentsConfiguration.getHardwareComponents()) &&
                cantHave.stream().noneMatch(hardwareCode -> componentsConfiguration.getHardwareComponents().contains(hardwareCode));
    }
}
