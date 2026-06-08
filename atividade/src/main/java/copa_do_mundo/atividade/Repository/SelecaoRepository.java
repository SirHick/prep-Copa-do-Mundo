package copa_do_mundo.atividade.Repository;

import copa_do_mundo.atividade.Model.Selecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SelecaoRepository extends JpaRepository<Selecao, Long> {

    @Query("SELECT s FROM Selecao s ORDER BY s.grupo ASC, s.nome ASC")
    List<Selecao> findAllOrderByGrupo();

    List<Selecao>
    findByJogadoresDisponiveisLessThanEqualOrJogadoresDisponiveisGreaterThanEqual(
            Integer min, Integer max);
}

