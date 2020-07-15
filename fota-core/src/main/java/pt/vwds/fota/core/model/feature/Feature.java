package pt.vwds.fota.core.model.feature;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pt.vwds.fota.core.model.vehicle.ComponentsConfiguration;

@Getter
@Builder
@Document(collection = "features")
public class Feature {
    @Id
    private final String id;

    private final SoftwareSpecification softwareSpecification;
    private final HardwareSpecification hardwareSpecification;

    @JsonCreator
    private Feature(@JsonProperty("id") String id,
                    @JsonProperty("softwareSpecification") SoftwareSpecification softwareSpecification,
                    @JsonProperty("hardwareSpecification") HardwareSpecification hardwareSpecification) {
        this.id = id;
        this.softwareSpecification = softwareSpecification;
        this.hardwareSpecification = hardwareSpecification;
    }


    public boolean isSatisfiedBy(ComponentsConfiguration componentsConfiguration) {
        return softwareSpecification.isSatisfiedBy(componentsConfiguration) &&
                hardwareSpecification.isSatisfiedBy(componentsConfiguration);
    }
}
