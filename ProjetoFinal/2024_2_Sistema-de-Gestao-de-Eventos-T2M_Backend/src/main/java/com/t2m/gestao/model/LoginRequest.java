package com.t2m.gestao.model;

import com.t2m.gestao.util.TratamentoDeErro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LoginRequest {
	@NotNull
	@NotBlank(message = TratamentoDeErro.NotBlankMessage12)
    private String email;
    @NotNull
    @NotBlank(message = TratamentoDeErro.NotBlankMessage11)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
