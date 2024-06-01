package com.glowDM.BP.umbrella.repository;

import com.glowDM.BP.umbrella.document.Store;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreRepository extends MongoRepository<Store, String> {
}
