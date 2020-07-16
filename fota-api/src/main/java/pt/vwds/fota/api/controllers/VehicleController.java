package pt.vwds.fota.api.controllers;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pt.vwds.fota.core.model.vehicle.Vehicle;
import pt.vwds.fota.core.services.VehicleService;

import java.util.List;

@RestController
@RequestMapping(value = "/fota/vehicles", produces="application/json")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("")
    public List<Vehicle> getAll(@RequestParam(defaultValue = "0") Integer pageNumber,
                                @RequestParam(defaultValue = Integer.MAX_VALUE + "") Integer pageSize,
                                @RequestParam(defaultValue = "ASC") String sortOrder) {
        return vehicleService.getAllVehicles(pageNumber, pageSize, Sort.Direction.fromString(sortOrder));
    }

    @GetMapping("/{vin}")
    public List<String> getAllFeature(@PathVariable String vin,
                                      @RequestParam(defaultValue = "0") Integer pageNumber,
                                      @RequestParam(defaultValue = Integer.MAX_VALUE + "") Integer pageSize,
                                      @RequestParam(defaultValue = "ASC") String sortOrder) {
        return null;
    }

    @GetMapping("/{vin}/compatible")
    public List<String> getCompatibleFeatures(@PathVariable String vin,
                                              @RequestParam(defaultValue = "0") Integer pageNumber,
                                              @RequestParam(defaultValue = Integer.MAX_VALUE + "") Integer pageSize,
                                              @RequestParam(defaultValue = "ASC") String sortOrder) {
        return vehicleService.getCompatibleFeatures(vin, pageNumber, pageSize, Sort.Direction.fromString(sortOrder));
    }

    @GetMapping("/{vin}/incompatible")
    public List<String> getIncompatibleFeatures(@PathVariable String vin,
                                                @RequestParam(defaultValue = "0") Integer pageNumber,
                                                @RequestParam(defaultValue = Integer.MAX_VALUE + "") Integer pageSize,
                                                @RequestParam(defaultValue = "ASC") String sortOrder) {
        return vehicleService.getIncompatibleFeatures(vin, pageNumber, pageSize, Sort.Direction.fromString(sortOrder));
    }
}
