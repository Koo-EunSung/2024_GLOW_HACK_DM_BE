package com.glowDM.BP.auth.data.dto.req;

import lombok.Data;

@Data
public class SignUpReq {
    private String name;
    private String loginId;
    private String password;
    private String businessNum;
}
