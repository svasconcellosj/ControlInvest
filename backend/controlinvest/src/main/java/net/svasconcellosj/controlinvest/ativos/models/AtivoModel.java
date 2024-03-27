package net.svasconcellosj.controlinvest.ativos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import net.svasconcellosj.controlinvest.instituicoes.models.InstituicaoModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public InstituicaoModel getId_instituicao() {
		return id_instituicao;
	}

	public void setId_instituicao(InstituicaoModel id_instituicao) {
		this.id_instituicao = id_instituicao;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AtivoModel other = (AtivoModel) obj;
		return Objects.equals(id, other.id);
	}
    
    
}
