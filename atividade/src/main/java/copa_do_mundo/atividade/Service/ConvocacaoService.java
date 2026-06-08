package copa_do_mundo.atividade.Service;

import copa_do_mundo.atividade.Model.Convocacao;
import copa_do_mundo.atividade.Model.Selecao;
import copa_do_mundo.atividade.Repository.ConvocacaoRepository;
import copa_do_mundo.atividade.Repository.SelecaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConvocacaoService {
    private final ConvocacaoRepository convocacaoRepository;
    private final SelecaoRepository selecaoRepository;

    public Convocacao registrar(Convocacao convocacao) {
        Selecao selecao = selecaoRepository.findById(convocacao.getSelecao().getId())
                .orElseThrow(() -> new RuntimeException("Seleção não encontrada"));

        selecao.setJogadoresDisponiveis(selecao.getJogadoresDisponiveis() + convocacao.getQuantidade());
        selecaoRepository.save(selecao);

        convocacao.setSelecao(selecao);
        return convocacaoRepository.save(convocacao);
    }
}