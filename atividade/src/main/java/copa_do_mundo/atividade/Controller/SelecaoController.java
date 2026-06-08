package copa_do_mundo.atividade.Controller;

import copa_do_mundo.atividade.Model.Selecao;
import copa_do_mundo.atividade.Repository.SelecaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/selecoes")
@RequiredArgsConstructor

public class SelecaoController {
    private final SelecaoRepository selecaoRepository;

    @GetMapping
    public List<Selecao> listar() {
        return selecaoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Selecao> cadastrar(@Valid @RequestBody Selecao
                                                     selecao) {
        return ResponseEntity.status(201).body(selecaoRepository.save(selecao));
    }

    @GetMapping("/grupo")
    public List<Selecao> listarPorGrupo() {
        return selecaoRepository.findAllOrderByGrupo();
    }
    @GetMapping("/limites")
    public List<Selecao> listarNosLimites() {
        return selecaoRepository

                .findByJogadoresDisponiveisLessThanEqualOrJogadoresDisponiveisGreaterThanEqual(0
                        , 100);
    }
}