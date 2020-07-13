package pt.vwds.fota.core.model.feature;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pt.vwds.fota.core.model.vehicle.ComponentsConfiguration;

import java.util.UUID;

@Builder
@Document(collection = "features")
public class Feature {
    @Id
    private final UUID id;

    private final SoftwareSpecification softwareSpecification;
    private final HardwareSpecification hardwareSpecification;


    public boolean isSatisfiedBy(ComponentsConfiguration componentsConfiguration) {
        return softwareSpecification.isSatisfiedBy(componentsConfiguration) &&
                hardwareSpecification.isSatisfiedBy(componentsConfiguration);
    }
}
