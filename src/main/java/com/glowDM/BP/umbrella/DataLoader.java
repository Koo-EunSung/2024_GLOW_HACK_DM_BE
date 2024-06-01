package com.glowDM.BP.umbrella;

import com.glowDM.BP.member.MemberRepository;
import com.glowDM.BP.store.data.Store;
import com.glowDM.BP.store.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void run(String... args) throws Exception {
        // 초기 데이터 삭제 (선택 사항)
        storeRepository.deleteAll();
        memberRepository.deleteAll();

        // 초기 데이터 추가
        storeRepository.save(new Store("1", "Store A", "123 Main St", 100, 35.1, 128.1));
        storeRepository.save(new Store("2", "Store B", "456 Elm St", 500, 35.2, 128.2));
        storeRepository.save(new Store("3", "Store C", "789 Oak St", 200, 35.3, 128.3));
    }
}
