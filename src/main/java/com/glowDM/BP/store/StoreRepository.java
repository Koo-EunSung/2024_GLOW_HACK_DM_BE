package com.glowDM.BP.store;

import com.glowDM.BP.store.data.Store;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreRepository extends MongoRepository<Store, String> {
}
