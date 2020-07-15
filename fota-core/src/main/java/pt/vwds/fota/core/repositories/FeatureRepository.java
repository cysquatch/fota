package pt.vwds.fota.core.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pt.vwds.fota.core.model.feature.Feature;

import java.util.UUID;

@Repository
public interface FeatureRepository extends MongoRepository<Feature, String> {
}
