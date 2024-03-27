package net.svasconcellosj.controlinvest.movimentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.svasconcellosj.controlinvest.movimentos.models.MovimentoModel;

@Repository
public interface MovimentoRepository extends JpaRepository<MovimentoModel, Long>{

}
