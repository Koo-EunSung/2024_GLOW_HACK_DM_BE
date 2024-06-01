package com.glowDM.BP.umbrella.service;

import com.glowDM.BP.umbrella.document.Store;
import com.glowDM.BP.umbrella.dto.StoreDTO;
import com.glowDM.BP.umbrella.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UmbrellaService {
    @Autowired
    private StoreRepository storeRepository;

    public StoreDTO addUmbrellas(String storeId, int count) {
        return storeRepository.findById(storeId).map(store -> {
            store.setUmbrellaCount(store.getUmbrellaCount() + count);
            Store updatedStore = storeRepository.save(store);

            return convertToDTO(updatedStore);
        }).orElse(null);
    }

    public StoreDTO updateUmbrellas(String storeId, int count) {
        return storeRepository.findById(storeId).map(store -> {
            store.setUmbrellaCount(count);
            Store updatedStore = storeRepository.save(store);

            return convertToDTO(updatedStore);
        }).orElse(null);
    }

    private StoreDTO convertToDTO(Store store) {
        return new StoreDTO(store.getId(), store.getName(), store.getAddress(), store.getUmbrellaCount());
    }
}
