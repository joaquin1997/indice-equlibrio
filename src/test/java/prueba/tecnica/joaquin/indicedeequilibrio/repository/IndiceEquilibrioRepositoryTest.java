package prueba.tecnica.joaquin.indicedeequilibrio.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import prueba.tecnica.joaquin.indicedeequilibrio.GeneradorDatos;
import prueba.tecnica.joaquin.indicedeequilibrio.model.IndiceEquilibrioEntity;

@DataJpaTest
public class IndiceEquilibrioRepositoryTest {

	@Autowired
	private IndiceEquilibrioRepository indiceEquilibrioRepository;
	
	@Test
	public void testSave() {
		IndiceEquilibrioEntity indiceEquilibrioEntity = GeneradorDatos.getRandomIndiceEquilibrioEntity();
		
		assertEquals(indiceEquilibrioEntity,indiceEquilibrioRepository.save(indiceEquilibrioEntity));
		
	}
	
	@Test 
	void testFind() {
		indiceEquilibrioRepository.save(GeneradorDatos.getRandomIndiceEquilibrioEntity());
		
		List<IndiceEquilibrioEntity> list = indiceEquilibrioRepository.findAll();
		
		assertNotNull(list);
		
		assertTrue(list.size()>0);
		
	}

}
