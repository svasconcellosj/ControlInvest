package net.svasconcellosj.controlinvest.ativos.controllers;

import net.svasconcellosj.controlinvest.ativos.models.AtivoModel;
import net.svasconcellosj.controlinvest.ativos.services.AtivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ativos")
public class AtivoController {

    @Autowired
    private AtivoService ativoService;

    @GetMapping
    public ResponseEntity<List<AtivoModel>> buscaAtivos() {
        List<AtivoModel> listaAtivos = ativoService.findAllAtivos();
        return new ResponseEntity<>(listaAtivos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AtivoModel> salvaAtivo(@RequestBody AtivoModel ativoModel) {
        try {
            AtivoModel saveAtivo = ativoService.saveAtivo(ativoModel);
            return new ResponseEntity<>(saveAtivo,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtivoModel> buscaAtivo(@PathVariable Long id) {
        try {
            Optional<AtivoModel> ativoModel = ativoService.findByAtivo(id);
            return ativoModel.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtivoModel> atualizaAtivo(@PathVariable Long id, @RequestBody AtivoModel ativoModel) {
        try {
            AtivoModel updateAtivo = ativoService.updateAtivo(id, ativoModel);
            return updateAtivo != null ?
                    new ResponseEntity<>(updateAtivo, HttpStatus.OK) :
                    new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AtivoModel> excluiAtivo(@PathVariable Long id) {
        try {
            ativoService.deleteAtivo(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
