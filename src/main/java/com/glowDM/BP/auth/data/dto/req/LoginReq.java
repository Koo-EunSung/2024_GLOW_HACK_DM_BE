package com.glowDM.BP.auth.data.dto.req;

import lombok.Data;

@Data
public class LoginReq {
    private String loginId;
    private String password;
}
