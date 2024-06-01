package com.glowDM.BP.umbrella.service;

import com.glowDM.BP.umbrella.document.Store;
import com.glowDM.BP.umbrella.dto.StoreDTO;
import com.glowDM.BP.umbrella.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public List<StoreDTO> getAllStores() {
        return storeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public StoreDTO getStoreById(String id) {
        return storeRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public StoreDTO createStore(StoreDTO storeDTO) {
        Store store = convertToEntity(storeDTO);
        Store savedStore = storeRepository.save(store);
        return convertToDTO(savedStore);
    }

    public void deleteStore(String id) {
        storeRepository.deleteById(id);
    }

    private StoreDTO convertToDTO(Store store) {
        return new StoreDTO(store.getId(), store.getName(), store.getAddress(), store.getUmbrellaCount());
    }

    private Store convertToEntity(StoreDTO storeDTO) {
        return new Store(storeDTO.getId(), storeDTO.getName(), storeDTO.getAddress(), storeDTO.getUmbrellaCount());
    }
}
