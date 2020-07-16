package pt.vwds.fota.core;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pt.vwds.fota.core.model.feature.Feature;
import pt.vwds.fota.core.model.vehicle.Vehicle;

public class FeatureTest extends CommonAbstractTest{

    @Test
    @DisplayName("Create a new Feature and see that it's accepted in a Truck")
    void createFeature() {
        Feature feature = Feature.builder()
                .id("feature_a")
                .softwareSpecification(softwareSpecification)
                .hardwareSpecification(hardwareSpecification)
                .build();

        Vehicle vehicle = Vehicle.builder()
                .vin("WAUHFBFL1DN549274")
                .configuration(componentsConfiguration)
                .build();

        Assert.assertTrue(feature.isSatisfiedBy(vehicle.getConfiguration()));
    }
}
