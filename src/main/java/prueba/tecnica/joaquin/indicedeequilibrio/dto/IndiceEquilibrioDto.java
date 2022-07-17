package prueba.tecnica.joaquin.indicedeequilibrio.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class IndiceEquilibrioDto {
    private Integer indiceEquilibrio;
    
    @JsonAlias("enteros")
    @NonNull
    private List<Integer> enteros;
    
    private LocalDateTime fechaActual;
}
