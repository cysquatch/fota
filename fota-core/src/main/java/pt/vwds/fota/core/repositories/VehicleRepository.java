package pt.vwds.fota.core.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pt.vwds.fota.core.model.vehicle.Vehicle;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {
}
