package net.svasconcellosj.controlinvest.movimentos.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.svasconcellosj.controlinvest.movimentos.models.MovimentoModel;
import net.svasconcellosj.controlinvest.movimentos.repositories.MovimentoRepository;

@Service
public class MovimentoService {
	
	@Autowired
	private MovimentoRepository movimentoRepository;
	
	public List<MovimentoModel> findAll() {
		return movimentoRepository.findAll();
	}
	
	public Optional<MovimentoModel> findByMovimento(Long id) {
		return movimentoRepository.findById(id);
	}
	
	public MovimentoModel saveMovimento(MovimentoModel movimentoModel) {
		try {
			movimentoModel.setCreated_at(LocalDateTime.now());
			movimentoModel.setUpdated_at(LocalDateTime.now());
			return movimentoRepository.save(movimentoModel);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao salvar o ativo.", e);
		}
		
	}

}
