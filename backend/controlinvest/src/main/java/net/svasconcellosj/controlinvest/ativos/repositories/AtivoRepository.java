package net.svasconcellosj.controlinvest.ativos.repositories;

import net.svasconcellosj.controlinvest.ativos.models.AtivoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtivoRepository extends JpaRepository<AtivoModel, Long> {
}
