package prueba.tecnica.joaquin.indicedeequilibrio.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
@Data
@Entity
public class IndiceEquilibrioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(targetEntity=NumerosEntity.class,cascade=CascadeType.ALL)
    private List<NumerosEntity> enteros;
    private Integer indiceEquilibrio;
    private LocalDate fechaActual;
}
