package prueba.tecnica.joaquin.indicedeequilibrio.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class IndiceEquilibrioDto {
    private Integer indiceEquilibrio;
    
    @JsonAlias("enteros")
    @NonNull
    private List<Integer> enteros;
    
    private LocalDate fechaActual;
}
