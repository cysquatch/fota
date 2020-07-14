package pt.vwds.fota.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.vwds.fota.core.model.vehicle.Vehicle;
import pt.vwds.fota.core.services.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/fota/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("")
    public List<Vehicle> getAll() {
        return vehicleService.getAllVehicles();
    }
}
