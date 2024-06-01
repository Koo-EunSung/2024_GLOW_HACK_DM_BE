package com.glowDM.BP.umbrella;

import com.glowDM.BP.umbrella.document.Store;
import com.glowDM.BP.umbrella.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public void run(String... args) throws Exception {
        // 초기 데이터 삭제 (선택 사항)
        storeRepository.deleteAll();

        // 초기 데이터 추가
        storeRepository.save(new Store("1", "Store A", "123 Main St", 100));
        storeRepository.save(new Store("2", "Store B", "456 Elm St", 500));
        storeRepository.save(new Store("3", "Store C", "789 Oak St", 200));
    }
}
