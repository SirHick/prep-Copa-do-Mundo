package copa_do_mundo.atividade.Service;

import copa_do_mundo.atividade.Model.Partida;
import copa_do_mundo.atividade.Model.Selecao;
import copa_do_mundo.atividade.Repository.PartidaRepository;
import copa_do_mundo.atividade.Repository.SelecaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartidaService {
    private final PartidaRepository partidaRepository;
    private final SelecaoRepository selecaoRepository;
    public Partida registrar(Partida partida) {
        Selecao selecao =
                selecaoRepository.findById(partida.getSelecao().getId())
                        .orElseThrow(() -> new RuntimeException("Seleção não encontrada"));

        if (selecao.getJogadoresDisponiveis() < partida.getQuantidade()) {
            throw new RuntimeException("Quantidade indisponível de jogadores");
        }
        selecao.setJogadoresDisponiveis(
                selecao.getJogadoresDisponiveis() - partida.getQuantidade()
        );
        selecaoRepository.save(selecao);
        partida.setSelecao(selecao);
        return partidaRepository.save(partida);
    }
}