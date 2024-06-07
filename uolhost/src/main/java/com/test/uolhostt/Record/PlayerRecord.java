package com.test.uolhostt.Record;

import com.test.uolhostt.Enum.TipoEnum;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PlayerRecord(
    @NotBlank(message = "Nome não pode estar em branco")
    String nome,
    
    @NotBlank(message = "Email não pode estar em branco")
    @Email(message = "Email deve ser válido")
    String email,
    
    @NotBlank(message = "Telefone não pode estar em branco")
    String telefone,
    
    String codinome,
    
    TipoEnum tipoEnum
) {
}
