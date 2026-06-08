package copa_do_mundo.atividade.Controller;

import copa_do_mundo.atividade.Model.Partida;
import copa_do_mundo.atividade.Repository.PartidaRepository;
import copa_do_mundo.atividade.Service.PartidaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.List;

@RestController
@RequestMapping("/partidas")
@RequiredArgsConstructor

public class PartidaController {

    private final PartidaService partidaService;

    private final PartidaRepository partidaRepository;

    @GetMapping
    public List<Partida> listar() {
        return partidaRepository.findAllByOrderByDataPartidaDesc();
    }

    @PostMapping
    public ResponseEntity<Partida> registrar(@Valid @RequestBody Partida
                                                     partida) {
        return
                ResponseEntity.status(201).body(partidaService.registrar(partida));
    }


    @GetMapping("/historico")
    public List<Partida> historico(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate
                    dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate
                    dataFinal) {
        return partidaRepository
                .findByDataPartidaBetweenOrderByDataPartidaAsc(dataInicial, dataFinal);
    }

    @GetMapping("/mais-escaladas")
    public List<Partida> maisEscaladas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate
                    dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate
                    dataFinal) {
        return partidaRepository.findMaisEscaladasNoPeriodo(dataInicial, dataFinal);
    }

}
