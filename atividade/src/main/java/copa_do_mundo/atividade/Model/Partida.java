package copa_do_mundo.atividade.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor

public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private LocalDate dataPartida;
    @Positive(message = "Quantidade deve ser maior que zero")

    private Integer quantidade;
    @ManyToOne

    private Selecao selecao;
}
