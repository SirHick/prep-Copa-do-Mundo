package copa_do_mundo.atividade.Controller;

import copa_do_mundo.atividade.Model.Convocacao;
import copa_do_mundo.atividade.Service.ConvocacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convocacoes")
@RequiredArgsConstructor

public class ConvocacaoController {

    private final ConvocacaoService convocacaoService;

    @PostMapping
    public ResponseEntity<Convocacao> registrar(@Valid @RequestBody Convocacao
                                                        convocacao) {
        return
                ResponseEntity.status(201).body(convocacaoService.registrar(convocacao));
    }
}
