package com.glowDM.BP.umbrella.controller;

import com.glowDM.BP.store.data.dto.StoreDTO;
import com.glowDM.BP.umbrella.data.dto.req.UpdateUmbrellaCountReq;
import com.glowDM.BP.umbrella.service.UmbrellaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/umbrellas")
public class UmbrellaController {
    @Autowired
    private UmbrellaService umbrellaService;

    // 우산 개수 등록
    @PostMapping("/{storeId}")
    public ResponseEntity<StoreDTO> addUmbrellas(@PathVariable String storeId, @RequestBody UpdateUmbrellaCountReq req) {
        StoreDTO storeDTO = umbrellaService.addUmbrellas(storeId, req.getNewCount());

        if (storeDTO != null) {
            return new ResponseEntity<>(storeDTO, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 우산 개수 수정
    @PutMapping("/{storeId}")
    public ResponseEntity<StoreDTO> updateUmbrellas(@PathVariable String storeId, @RequestBody UpdateUmbrellaCountReq req) {
        StoreDTO storeDTO = umbrellaService.updateUmbrellas(storeId, req.getNewCount());

        if (storeDTO != null) {
            return new ResponseEntity<>(storeDTO, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/decrement")
    @ResponseBody
    public ResponseEntity<StoreDTO> decrementUmbrellaCount(@RequestParam String storeId) {
        StoreDTO updatedStore = umbrellaService.decrementUmbrellaCount(storeId);
        if (updatedStore != null) {
            return ResponseEntity.ok(updatedStore);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
