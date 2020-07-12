package pt.vwds.fota.core.model.vehicle;

import pt.vwds.fota.core.model.feature.Feature;

public interface Vehicle {
    boolean acceptsFeature(Feature newFeature);
}
