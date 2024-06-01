package com.glowDM.BP.store.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    @Id
    private String id;
    private String name;    // 가게 이름, 나중에 삭제...
    private String address; // 가게 주소
    private int umbrellaCount;  // 우산 개수
    private double latitude; // 위도
    private double longitude; // 경도
}
