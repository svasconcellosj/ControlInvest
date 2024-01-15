package net.svasconcellosj.controlinvest.instituicoes.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "instituicoes")
@Data
public class InstituicaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Campo nome não pode ser nulo")
    @Size(min = 5, max = 100, message = "Mínimo de 5 e máximo de 100 caracteres")
    private String nome;

    @NotNull
    @Size(min = 14, max = 14)
    private String cnpj;

    @NotNull
    @Size(min = 1, max = 1, message = "Tipo deve ser um únido caracter.")
    private String tipo;

    @NotNull
    @Size(min = 5, max = 40)
    private String segmento;

    @DateTimeFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    private LocalDateTime created_at;

    @DateTimeFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    private LocalDateTime updated_at;
}
