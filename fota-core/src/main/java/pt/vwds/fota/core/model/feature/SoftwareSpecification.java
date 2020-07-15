package pt.vwds.fota.core.model.feature;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import pt.vwds.fota.core.model.vehicle.ComponentsConfiguration;
import pt.vwds.fota.core.model.SoftwareComponent;

import java.util.Set;

@Getter
@Builder
public class SoftwareSpecification {

    private final Set<SoftwareComponent> mustHave;
    private final Set<SoftwareComponent> cantHave;

    @JsonCreator
    private SoftwareSpecification(@JsonProperty("mustHave") Set<SoftwareComponent> mustHave,
                                  @JsonProperty("cantHave") Set<SoftwareComponent> cantHave) {
        this.mustHave = mustHave;
        this.cantHave = cantHave;
    }

    protected boolean isSatisfiedBy(ComponentsConfiguration componentsConfiguration) {
        return mustHave.containsAll(componentsConfiguration.getSoftwareComponents()) &&
                cantHave.stream().noneMatch(softwareComponent -> componentsConfiguration.getSoftwareComponents().contains(softwareComponent));
    }}
