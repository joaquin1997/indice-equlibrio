package prueba.tecnica.joaquin.indicedeequilibrio.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prueba.tecnica.joaquin.indicedeequilibrio.model.IndiceEquilibrioEntity;

@Repository
public interface IndiceEquilibrioRepository extends JpaRepository<IndiceEquilibrioEntity,Integer>{
    
}
