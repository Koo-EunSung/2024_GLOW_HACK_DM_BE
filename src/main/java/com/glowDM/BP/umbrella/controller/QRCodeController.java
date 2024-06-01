package com.glowDM.BP.umbrella.controller;

import com.glowDM.BP.umbrella.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping("/generateQRCode")
    public ResponseEntity<byte[]> generateQRCode(@RequestParam String storeId) {
        try {
            byte[] qrCodeImage = qrCodeService.generateQRCode("/umbrella/decrement?storeId=" + storeId, 350, 350);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=qr_code.png");
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(qrCodeImage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/qr_code")
    public String qrCodePage(@RequestParam String storeId, Model model) {
        model.addAttribute("storeId", storeId);
        return "qr_code";
    }
}