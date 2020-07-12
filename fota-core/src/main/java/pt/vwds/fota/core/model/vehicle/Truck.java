package pt.vwds.fota.core.model.vehicle;

import lombok.AllArgsConstructor;
import pt.vwds.fota.core.model.ComponentsConfiguration;

@AllArgsConstructor
public class Truck{
    private String vin;
    private ComponentsConfiguration configuration;
}
