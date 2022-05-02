package prueba.tecnica.joaquin.indicedeequilibrio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class IndiceEquilibrioModel {
    @Id
    @NotNull(message = "Se requiere una lista de enteros")
    private Integer[] enteros;
    private Integer indiceEquilibrio;
}
