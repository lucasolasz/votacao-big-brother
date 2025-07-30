package ltech.app.votacao_big_brother.service;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ltech.app.votacao_big_brother.dto.CandidatoRecord;
import ltech.app.votacao_big_brother.entity.Voto;
import ltech.app.votacao_big_brother.repository.VotoRepository;

@Service
@AllArgsConstructor
public class VotoService {

    private final VotoRepository votoRepository;
    private final RabbitTemplate rabbitTemplate;
    private final CandidatoService candidatoService;

    public void processarVoto(CandidatoRecord candidatoRecord) {
        rabbitTemplate.convertAndSend("computar-voto.ex", "", candidatoRecord);
    }

    public void save(CandidatoRecord candidatoRecord) {
        var voto = new Voto();
        voto.setHoraVoto(LocalDateTime.now());
        voto.setCandidatoVotado(candidatoService.findById(candidatoRecord.id()));
        votoRepository.save(voto);
    }

}
