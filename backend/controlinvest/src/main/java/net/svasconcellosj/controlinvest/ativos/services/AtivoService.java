package net.svasconcellosj.controlinvest.ativos.services;

import net.svasconcellosj.controlinvest.ativos.models.AtivoModel;
import net.svasconcellosj.controlinvest.ativos.repositories.AtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AtivoService {

    @Autowired
    private AtivoRepository ativoRepository;

    public List<AtivoModel> findAllAtivos() {
        return ativoRepository.findAll();
    }

   public AtivoModel saveAtivo(AtivoModel ativoModel) {
        try {
            ativoModel.setCreated_at(LocalDateTime.now());
            ativoModel.setUpdated_at(LocalDateTime.now());
            return ativoRepository.save(ativoModel);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o ativo.", e);
        }
   }

   public Optional<AtivoModel> findByAtivo(Long id) {
        return ativoRepository.findById(id);
   }

   public AtivoModel updateAtivo(Long id, AtivoModel ativoModel) {
        Optional<AtivoModel> ativoExistente = findByAtivo(id);
        try {
            if (ativoRepository.existsById(id)) {
                ativoModel.setId(id);
                ativoModel.setCreated_at(ativoExistente.get().getUpdated_at());
                ativoModel.setUpdated_at(LocalDateTime.now());
                return ativoRepository.save(ativoModel);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar o ativo", e);
        }
   }

   public void deleteAtivo(Long id) {
        try {
            ativoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir o ativo.", e);
        }
   }
}
