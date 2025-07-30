package ltech.app.votacao_big_brother.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ltech.app.votacao_big_brother.entity.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

}