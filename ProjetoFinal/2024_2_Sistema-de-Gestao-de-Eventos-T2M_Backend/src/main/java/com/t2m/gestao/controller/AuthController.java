package com.t2m.gestao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.t2m.gestao.model.LoginRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String url = "http://t2m-iqs.southcentralus.cloudapp.azure.com:9091/api/login";

        ResponseEntity<String> response = restTemplate.postForEntity(url, loginRequest, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();

            try{
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, String> jsonResponse = objectMapper.readValue(responseBody, Map.class);
                String token = jsonResponse.get("token");

                if (token == null || token.chars().filter(ch -> ch == '.').count() != 2){
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token JWT inválido");
                }

                Claims claims = decodeJWTWithoutSignatureValidation(token);

                String role = claims.get("Role", String.class);
                String corporativeEmail = claims.get("CorporativeEmail", String.class);
                String fullName = claims.get("FullName", String.class);

                if (!corporativeEmail.equals(loginRequest.getEmail())){
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("E-mail inconsistente");
                }

                Map<String, Object> result = new HashMap<>();
                result.put("role", role);
                result.put("email", corporativeEmail);
                result.put("fullName",fullName);
                return ResponseEntity.ok(result);
            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a resposta: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(response.getStatusCode()).body("Erro ao autenticar");
        }
    }

    private Claims decodeJWTWithoutSignatureValidation(String jwt) {
        try {
            String[] parts = jwt.split("\\.");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Token JWT inválido. Deve conter exatamente 2 pontos.");
            }

            String unsignedToken = parts[0] + "." + parts[1] + "."; // Ignora a assinatura
            return Jwts.parserBuilder()
                    .setAllowedClockSkewSeconds(60)
                    .build()
                    .parseClaimsJwt(unsignedToken)
                    .getBody();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao decodificar o token JWT: " + e.getMessage(), e);
        }
    }
}

