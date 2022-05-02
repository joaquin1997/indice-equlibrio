package prueba.tecnica.joaquin.indicedeequilibrio.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import prueba.tecnica.joaquin.indicedeequilibrio.model.IndiceEquilibrioModel;

public interface IndiceDeEquilibrioRepository extends JpaRepository<IndiceEquilibrioModel,Integer[]>{
    
    Set<IndiceEquilibrioModel> findByArray(Integer[] arrayId);

}
