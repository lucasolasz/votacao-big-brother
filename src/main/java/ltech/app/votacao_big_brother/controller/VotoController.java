package ltech.app.votacao_big_brother.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ltech.app.votacao_big_brother.dto.CandidatoRecord;
import ltech.app.votacao_big_brother.service.VotoService;

@RestController
@RequestMapping("/votos")
@AllArgsConstructor
public class VotoController {

    private final VotoService votoService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public void processarVoto(@RequestBody CandidatoRecord candidatoRecord) {
        votoService.processarVoto(candidatoRecord);
    }

}
