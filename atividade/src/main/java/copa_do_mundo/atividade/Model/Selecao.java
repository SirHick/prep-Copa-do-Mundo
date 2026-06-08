package copa_do_mundo.atividade.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
@Entity
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor

public class Selecao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome é obrigatório")

    private String nome;
    @NotBlank(message = "Grupo é obrigatório")

    private String grupo;

    private String fase;
    @Min(value = 0, message = "Gols marcados não pode ser negativo")

    private Integer golsMarcados;
    @Min(value = 0, message = "Gols sofridos não pode ser negativo")

    private Integer golsSofridos;
    @Positive(message = "Valor do plantel deve ser maior que zero")

    private Double valorPlantel;

    private Integer jogadoresDisponiveis = 0;
}