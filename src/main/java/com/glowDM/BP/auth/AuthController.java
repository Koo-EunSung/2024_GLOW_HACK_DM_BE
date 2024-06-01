package com.glowDM.BP.auth;

import com.glowDM.BP.auth.data.dto.req.SignUpReq;
import com.glowDM.BP.member.data.dto.res.MemberGetRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MemberGetRes> signUp(@RequestBody SignUpReq req) {
        return authService.signUp(req);
    }

}
