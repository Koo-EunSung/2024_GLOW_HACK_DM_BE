package com.glowDM.BP.umbrella.service;

import com.glowDM.BP.store.data.Store;
import com.glowDM.BP.store.data.dto.StoreDTO;
import com.glowDM.BP.store.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UmbrellaBorrowReturnService {
    @Autowired
    private StoreRepository storeRepository;

    public StoreDTO borrowUmbrella(String storeId) {    // 우산을 대여 (우산 개수 -1)
        return storeRepository.findById(storeId).map(store -> {
            if (store.getUmbrellaCount() > 0) {
                store.setUmbrellaCount(store.getUmbrellaCount() - 1);
                Store updatedStore = storeRepository.save(store);

                return convertToDTO(updatedStore);
            }
            else {
                return null;    // 우산이 없는 경우 null 반환
            }
        }).orElse(null);
    }

    public StoreDTO returnUmbrella(String storeId) {    // 우산을 반납 (우산 개수 +1)
        return storeRepository.findById(storeId).map(store -> {
            store.setUmbrellaCount(store.getUmbrellaCount() + 1);
            Store updatedStore = storeRepository.save(store);

            return convertToDTO(updatedStore);
        }).orElse(null);
    }

    private StoreDTO convertToDTO(Store store) {
        return new StoreDTO(store.getId(), store.getName(), store.getAddress(), store.getUmbrellaCount(), store.getLatitude(), store.getLongitude());
    }
}