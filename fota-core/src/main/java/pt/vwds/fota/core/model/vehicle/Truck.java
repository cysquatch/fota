package pt.vwds.fota.core.model.vehicle;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Truck{
    private final String vin;
    private final ComponentsConfiguration configuration;
}
