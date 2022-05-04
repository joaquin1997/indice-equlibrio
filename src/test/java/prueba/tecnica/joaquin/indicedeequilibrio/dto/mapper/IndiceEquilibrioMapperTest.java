package prueba.tecnica.joaquin.indicedeequilibrio.dto.mapper;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import prueba.tecnica.joaquin.indicedeequilibrio.GeneradorDatos;
import prueba.tecnica.joaquin.indicedeequilibrio.dto.IndiceEquilibrioDto;
import prueba.tecnica.joaquin.indicedeequilibrio.model.IndiceEquilibrioEntity;
@ExtendWith(SpringExtension.class)
public class IndiceEquilibrioMapperTest {

	@InjectMocks
	private IndiceEquilibrioMapperImpl indiceEquilibrioMapper;
	
	@Test
	public void testToDto() {
		IndiceEquilibrioEntity indiceEquilibrioEntity = GeneradorDatos.getRandomIndiceEquilibrioEntity();
		IndiceEquilibrioDto indiceEquilibrioDto = indiceEquilibrioMapper.toIndiceEquilibrioDto(indiceEquilibrioEntity);
		assertTrue(comparadorIndiceEquilibrioIndiceEquilibrioDto(indiceEquilibrioEntity,indiceEquilibrioDto));
	}
	@Test
	public void testToDtoNull() {
		IndiceEquilibrioEntity indiceEquilibrioEntity = null;
		IndiceEquilibrioDto indiceEquilibrioDto = indiceEquilibrioMapper.toIndiceEquilibrioDto(indiceEquilibrioEntity);
		assertNull(indiceEquilibrioDto);
	}
	
	@Test 
	public void testToListNullDto() {
		List<IndiceEquilibrioEntity> indiceEquilibrioEntities = null;
		List<IndiceEquilibrioDto> indiceEquilibrioDtos = indiceEquilibrioMapper.toListIndiceEquilibrioDto(indiceEquilibrioEntities);
		
		assertNull(indiceEquilibrioDtos);
		
	}
	
	@Test 
	public void testToListDto() {
		List<IndiceEquilibrioEntity> indiceEquilibrioEntities = GeneradorDatos.getRandomIndiceEquilibrioEntities();
		List<IndiceEquilibrioDto> indiceEquilibrioDtos = indiceEquilibrioMapper.toListIndiceEquilibrioDto(indiceEquilibrioEntities);
		
		for(int i = 0; i<indiceEquilibrioEntities.size();i++) {
			assertTrue(comparadorIndiceEquilibrioIndiceEquilibrioDto(indiceEquilibrioEntities.get(i), indiceEquilibrioDtos.get(i)));
		}
		
	}
	
	@Test
	public void testToEntity() {
		IndiceEquilibrioDto indiceEquilibrioDto = GeneradorDatos.getRandomIndiceEquilibrioDto();
		IndiceEquilibrioEntity indiceEquilibrioEntity = indiceEquilibrioMapper.toIndiceEquilibrioModel(indiceEquilibrioDto);
		assertTrue(comparadorIndiceEquilibrioIndiceEquilibrioDto(indiceEquilibrioEntity,indiceEquilibrioDto));
	}
	
	@Test
	public void testToEntityNull() {
		IndiceEquilibrioDto indiceEquilibrioDto = null;
		IndiceEquilibrioEntity indiceEquilibrioEntity = indiceEquilibrioMapper.toIndiceEquilibrioModel(indiceEquilibrioDto);
		assertNull(indiceEquilibrioEntity);
	}
	
	private boolean comparadorIndiceEquilibrioIndiceEquilibrioDto(IndiceEquilibrioEntity indiceEquilibrioEntity,IndiceEquilibrioDto indiceEquilibrioDto ) {
		List<Integer> enteros = indiceEquilibrioEntity.getEnteros().stream().map((e)->e.getNumero()).collect(Collectors.toList());
		
		
		return indiceEquilibrioEntity.getIndiceEquilibrio().equals(indiceEquilibrioDto.getIndiceEquilibrio()) 
				&& indiceEquilibrioEntity.getFechaActual().equals(indiceEquilibrioDto.getFechaActual()) 
				&& enteros.equals( indiceEquilibrioDto.getEnteros());
		
	}
	
}
