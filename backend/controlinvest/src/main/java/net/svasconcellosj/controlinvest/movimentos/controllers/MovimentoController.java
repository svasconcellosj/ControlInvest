package net.svasconcellosj.controlinvest.movimentos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.svasconcellosj.controlinvest.movimentos.models.MovimentoModel;
import net.svasconcellosj.controlinvest.movimentos.services.MovimentoService;

@RestController
@RequestMapping("/movimentos")
public class MovimentoController {
	
	@Autowired
	private MovimentoService movimentoService;
	
	@GetMapping
	public ResponseEntity<List<MovimentoModel>> buscaMovimentos() {
		List<MovimentoModel> listaMovimentos = movimentoService.findAll();
		return new ResponseEntity<List<MovimentoModel>>(listaMovimentos, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MovimentoModel> buscaMovimento(@PathVariable Long id) {
		try {
			Optional<MovimentoModel> movimentoModel = movimentoService.findByMovimento(id);
			return movimentoModel.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
					.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
		} catch (Exception e) {
			return new ResponseEntity<MovimentoModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<MovimentoModel> salvaMovimento(@RequestBody MovimentoModel movimentoModel) {
		try {
			MovimentoModel saveMovimento = movimentoService.saveMovimento(movimentoModel);
			return new ResponseEntity<MovimentoModel>(saveMovimento, HttpStatus.CREATED);
		} catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
