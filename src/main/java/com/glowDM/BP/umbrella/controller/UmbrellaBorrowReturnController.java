package com.glowDM.BP.umbrella.controller;

import com.glowDM.BP.store.data.dto.StoreDTO;
import com.glowDM.BP.umbrella.service.UmbrellaBorrowReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/umbrellas")
public class UmbrellaBorrowReturnController {
    @Autowired
    private UmbrellaBorrowReturnService umbrellaBorrowReturnService;

    // 우산 대여
    @PostMapping("/{storeId}/borrow")
    public ResponseEntity<StoreDTO> borrowUmbrella(@PathVariable String storeId) {
        StoreDTO storeDTO = umbrellaBorrowReturnService.borrowUmbrella(storeId);

        if (storeDTO != null) {
            return new ResponseEntity<>(storeDTO, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 우산 반납
    @PostMapping("/{storeId}/return")
    public ResponseEntity<StoreDTO> returnUmbrella(@PathVariable String storeId) {
        StoreDTO storeDTO = umbrellaBorrowReturnService.returnUmbrella(storeId);

        if (storeDTO != null) {
            return new ResponseEntity<>(storeDTO, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}