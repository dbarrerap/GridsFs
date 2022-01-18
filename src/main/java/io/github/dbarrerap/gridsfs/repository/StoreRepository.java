package io.github.dbarrerap.gridsfs.repository;

import io.github.dbarrerap.gridsfs.entities.Store;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends MongoRepository<Store, String> {
}
