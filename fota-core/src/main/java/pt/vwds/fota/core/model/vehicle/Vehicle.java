package pt.vwds.fota.core.model.vehicle;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "vehicles")
public class Vehicle {
    @Id
    private final String vin;
    private final ComponentsConfiguration configuration;
}
