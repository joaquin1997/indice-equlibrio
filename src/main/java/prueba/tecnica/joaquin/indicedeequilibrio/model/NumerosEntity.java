package prueba.tecnica.joaquin.indicedeequilibrio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor	
@Getter
@Setter
@Entity
public class NumerosEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNumeros;
	@NotNull
	private Integer numero;
	@ManyToOne
	@JoinColumn(name="id", insertable=false, updatable=false)
	private IndiceEquilibrioEntity idIndiceEquilibrioEntity;
	
}
