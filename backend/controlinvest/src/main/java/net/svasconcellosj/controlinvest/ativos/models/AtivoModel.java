package net.svasconcellosj.controlinvest.ativos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import net.svasconcellosj.controlinvest.instituicoes.models.InstituicaoModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "ativos")
@Data
public class AtivoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O campo não pode ser nulo.")
    @Size(min = 5, max = 10, message = "O campo deve estar entre 5 e 10 caracteres.")
    private String ticket;

    @OneToOne
    @JoinColumn(name = "id_instituicao", referencedColumnName = "id")
    private InstituicaoModel id_instituicao;

    @DateTimeFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    private LocalDateTime created_at;

    @DateTimeFormat(pattern = "YYYY-MM-DD HH:mm:ss")
    private LocalDateTime updated_at;
}
