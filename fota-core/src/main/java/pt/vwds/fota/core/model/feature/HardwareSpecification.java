package pt.vwds.fota.core.model.feature;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import pt.vwds.fota.core.model.vehicle.ComponentsConfiguration;
import pt.vwds.fota.core.model.HardwareComponent;

import java.util.Set;

@Getter
@Builder
public class HardwareSpecification {

    private final Set<HardwareComponent> mustHave;
    private final Set<HardwareComponent> cantHave;

    @JsonCreator
    private HardwareSpecification(@JsonProperty("mustHave") Set<HardwareComponent> mustHave,
                                  @JsonProperty("cantHave") Set<HardwareComponent> cantHave) {
        this.mustHave = mustHave;
        this.cantHave = cantHave;
    }

    protected boolean isSatisfiedBy(ComponentsConfiguration componentsConfiguration) {
        return mustHave.containsAll(componentsConfiguration.getHardwareComponents()) &&
                cantHave.stream().noneMatch(hardwareComponent -> componentsConfiguration.getHardwareComponents().contains(hardwareComponent));
    }
}
