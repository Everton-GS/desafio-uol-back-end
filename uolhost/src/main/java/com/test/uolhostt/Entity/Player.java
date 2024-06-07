package com.test.uolhostt.Entity;

import com.test.uolhostt.Enum.TipoEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Valid
@NoArgsConstructor
@Table(name = "db_player")
public class Player {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "nome em branco")
    private String nome;

    @Email
    @NotBlank(message = "email em branco")
    private String email;

    @NotBlank(message = "telefone em branco")
    private String telefone;

    @NotBlank(message = "codinome em branco")
    private String codinome;

    @NotNull(message = "tipo em branco")
    @Enumerated(EnumType.STRING)
    TipoEnum tipoEnum;

    public Player(@NotBlank(message = "nome em branco") String nome,
            @Email @NotBlank(message = "email em branco") String email,
            @NotBlank(message = "telefone em branco") String telefone,
            @NotBlank(message = "codinome em branco") String codinome,
            @NotBlank(message = "tipo em branco") TipoEnum tipoEnum) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.codinome = codinome;
        this.tipoEnum = tipoEnum;
    }

    

}
