package com.alibakir.financialHouse.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor
public class TestController {

    @Operation(summary = "Test için oluşturulmuştur. Herhangi bir özel işlem yapmaz ve yalnızca 'Okey' yanıtını döner.")
    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Okey");
    }
}
