package com.glowDM.BP.auth;

import com.glowDM.BP.auth.data.dto.req.LoginReq;
import com.glowDM.BP.auth.data.dto.req.SignUpReq;
import com.glowDM.BP.member.MemberRepository;
import com.glowDM.BP.member.data.Member;
import com.glowDM.BP.member.data.dto.res.MemberGetRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder pwEncoder;

    public ResponseEntity<MemberGetRes> signUp(SignUpReq req) {
        if(req == null) {
            throw new IllegalArgumentException("잘못된 요청입니다.");
        }
        if(memberRepository.existsByLoginId(req.getLoginId())) {
            throw new IllegalArgumentException("이미 존재하는 사용자입니다.");
        }
        // 추후 예외처리할 것
        String bcryptPw = pwEncoder.encode(req.getPassword());
        Member newMember = Member.builder()
                .name(req.getName())
                .number(req.getNumber())
                .loginId(req.getLoginId())
                .password(bcryptPw)
                .businessNum(req.getBusinessNum())
                .build();

        memberRepository.save(newMember);

        return new ResponseEntity<>(new MemberGetRes(newMember), HttpStatus.CREATED);
    }
}