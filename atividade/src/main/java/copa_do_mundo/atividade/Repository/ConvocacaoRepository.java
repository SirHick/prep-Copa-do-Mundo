package copa_do_mundo.atividade.Repository;

import copa_do_mundo.atividade.Model.Convocacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvocacaoRepository extends JpaRepository<Convocacao, Long> {
}