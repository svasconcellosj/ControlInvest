package net.svasconcellosj.controlinvest.movimentos.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import net.svasconcellosj.controlinvest.ativos.models.AtivoModel;
import net.svasconcellosj.controlinvest.instituicoes.models.InstituicaoModel;

@Entity
@Table(name = "movimentos")
@Data
public class MovimentoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O campo não pode ser nulo.")
	private Character tipo_movimento;
	
	@OneToOne
	@JoinColumn(name = "id_instituicao", referencedColumnName = "id")
	private InstituicaoModel id_instituicao;
	
	@OneToOne
	@JoinColumn(name = "id_ativo", referencedColumnName = "id")
	private AtivoModel id_ativo;
	
	@NotNull(message = "O campo não pode ser nulo.")
	private LocalDateTime data_movimento;
	
	@NotNull(message = "O campo não pode ser nulo.")
	private int qtd;
	
	@NotNull(message = "O campo não pode ser nulo.")
	private BigDecimal valor;
	
	@NotNull(message = "O campo não pode ser nulo.")
	private BigDecimal dividend_ueld_movimento;
	
	@NotNull(message = "O campo não pode ser nulo.")
	private BigDecimal p_vp;
	
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

	public Character getTipo_movimento() {
		return tipo_movimento;
	}

	public void setTipo_movimento(Character tipo_movimento) {
		this.tipo_movimento = tipo_movimento;
	}

	public InstituicaoModel getId_instituicao() {
		return id_instituicao;
	}

	public void setId_instituicao(InstituicaoModel id_instituicao) {
		this.id_instituicao = id_instituicao;
	}

	public AtivoModel getId_ativo() {
		return id_ativo;
	}

	public void setId_ativo(AtivoModel id_ativo) {
		this.id_ativo = id_ativo;
	}

	public LocalDateTime getData_movimento() {
		return data_movimento;
	}

	public void setData_movimento(LocalDateTime data_movimento) {
		this.data_movimento = data_movimento;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getDividend_ueld_movimento() {
		return dividend_ueld_movimento;
	}

	public void setDividend_ueld_movimento(BigDecimal dividend_ueld_movimento) {
		this.dividend_ueld_movimento = dividend_ueld_movimento;
	}

	public BigDecimal getP_vp() {
		return p_vp;
	}

	public void setP_vp(BigDecimal p_vp) {
		this.p_vp = p_vp;
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
		MovimentoModel other = (MovimentoModel) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
