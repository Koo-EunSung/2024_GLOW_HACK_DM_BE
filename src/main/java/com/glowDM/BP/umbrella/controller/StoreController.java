package com.glowDM.BP.umbrella.controller;

import com.glowDM.BP.umbrella.dto.StoreDTO;
import com.glowDM.BP.umbrella.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {
    @Autowired
    private StoreService storeService;

    // 모든 가게 정보 조회
    @GetMapping
    public ResponseEntity<List<StoreDTO>> getAllStores() {
        List<StoreDTO> stores = storeService.getAllStores();

        return new ResponseEntity<>(stores, HttpStatus.OK);
    }

    // id로 특정 가게 정보 조회
    @GetMapping("/{id}")
    public ResponseEntity<StoreDTO> getStoreById(@PathVariable String id) {
        StoreDTO storeDTO = storeService.getStoreById(id);

        if (storeDTO != null) {
            return new ResponseEntity<>(storeDTO, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 새로운 가게 정보 생성
    @PostMapping
    public ResponseEntity<StoreDTO> createStore(@RequestBody StoreDTO storeDTO) {
        StoreDTO createdStore = storeService.createStore(storeDTO);

        return new ResponseEntity<>(createdStore, HttpStatus.CREATED);
    }

    // 가게 정보 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable String id) {
        storeService.deleteStore(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
