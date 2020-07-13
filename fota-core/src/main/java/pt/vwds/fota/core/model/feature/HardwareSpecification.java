package pt.vwds.fota.core.model.feature;

import lombok.Builder;
import pt.vwds.fota.core.model.vehicle.ComponentsConfiguration;
import pt.vwds.fota.core.model.HardwareComponent;

import java.util.Set;

@Builder
public class HardwareSpecification {
    private final Set<HardwareComponent> mustHave;
    private final Set<HardwareComponent> cantHave;

    protected boolean isSatisfiedBy(ComponentsConfiguration componentsConfiguration) {
        return mustHave.containsAll(componentsConfiguration.getHardwareComponents()) &&
                cantHave.stream().noneMatch(hardwareComponent -> componentsConfiguration.getHardwareComponents().contains(hardwareComponent));
    }
}
