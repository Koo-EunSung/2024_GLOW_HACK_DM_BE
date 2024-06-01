package com.glowDM.BP.member.data.dto.res;

import com.glowDM.BP.member.data.Member;
import lombok.Data;

@Data
public class MemberGetRes {
    private String name;
    private String loginId;

    public MemberGetRes(Member member) {
        this.name = member.getName();
        this.loginId = member.getLoginId();
    }
}
