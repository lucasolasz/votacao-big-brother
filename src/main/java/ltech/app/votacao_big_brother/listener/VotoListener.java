package ltech.app.votacao_big_brother.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import ltech.app.votacao_big_brother.dto.CandidatoRecord;
import ltech.app.votacao_big_brother.service.VotoService;

@Component
@AllArgsConstructor
public class VotoListener {

    private final VotoService votoService;

    @RabbitListener(queues = "computar-voto.queue")
    public void processMessage(CandidatoRecord candidatoRecord) {
        votoService.save(candidatoRecord);
    }

}
