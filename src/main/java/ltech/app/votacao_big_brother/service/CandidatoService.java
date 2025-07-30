package ltech.app.votacao_big_brother.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ltech.app.votacao_big_brother.entity.Candidato;
import ltech.app.votacao_big_brother.repository.CandidatoRepository;

@Service
@AllArgsConstructor
public class CandidatoService {

    private final CandidatoRepository candidatoRepository;

    public void save(Candidato candidato) {
        candidatoRepository.save(candidato);
    }

    public Candidato findById(Long id) {
        return candidatoRepository.findById(id).orElse(null);
    }
}
