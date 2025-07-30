package ltech.app.votacao_big_brother.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ltech.app.votacao_big_brother.dto.CandidatoRecord;

@Service
@AllArgsConstructor
public class VotoService {

    private final RabbitTemplate rabbitTemplate;

    public void processarVoto(CandidatoRecord candidatoRecord) {
        rabbitTemplate.convertAndSend("computar-voto.ex", "", candidatoRecord);
    }

}
