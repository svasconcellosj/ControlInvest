package net.svasconcellosj.controlinvest.instituicoes.repositories;

import net.svasconcellosj.controlinvest.instituicoes.models.InstituicaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicaoRepository extends JpaRepository<InstituicaoModel, Long> {
}
