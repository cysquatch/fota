package pt.vwds.fota.api.controllers;

import org.springframework.web.bind.annotation.*;
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
    public List<Vehicle> getAll(@RequestParam(defaultValue = "0") Integer pageNumber,
                                @RequestParam(defaultValue = Integer.MAX_VALUE + "") Integer pageSize,
                                @RequestParam(defaultValue = "vin") String sortBy) {
        return vehicleService.getAllVehicles(pageNumber, pageSize, sortBy);
    }

    @GetMapping("/{vin}")
    public List<String> getAllFeature(@PathVariable String vin,
                                      @RequestParam(defaultValue = "0") Integer pageNumber,
                                      @RequestParam(defaultValue = Integer.MAX_VALUE + "") Integer pageSize,
                                      @RequestParam(defaultValue = "") String sortBy) {
        return null;
    }

    @GetMapping("/{vin}/compatible")
    public List<String> getCompatibleFeatures(@PathVariable String vin,
                                              @RequestParam(defaultValue = "0") Integer pageNumber,
                                              @RequestParam(defaultValue = Integer.MAX_VALUE + "") Integer pageSize,
                                              @RequestParam(defaultValue = "") String sortBy) {
        return vehicleService.getCompatibleFeatures(vin, pageNumber, pageSize, sortBy);
    }

    @GetMapping("/{vin}/incompatible")
    public List<String> getIncompatibleFeatures(@PathVariable String vin,
                                                @RequestParam(defaultValue = "0") Integer pageNumber,
                                                @RequestParam(defaultValue = Integer.MAX_VALUE + "") Integer pageSize,
                                                @RequestParam(defaultValue = "") String sortBy) {
        return vehicleService.getIncompatibleFeatures(vin, pageNumber, pageSize, sortBy);
    }
}
