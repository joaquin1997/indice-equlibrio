package prueba.tecnica.joaquin.indicedeequilibrio.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import prueba.tecnica.joaquin.indicedeequilibrio.GeneradorDatos;
import prueba.tecnica.joaquin.indicedeequilibrio.dto.IndiceEquilibrioDto;
import prueba.tecnica.joaquin.indicedeequilibrio.dto.mapper.IndiceEquilibrioMapper;
import prueba.tecnica.joaquin.indicedeequilibrio.model.IndiceEquilibrioEntity;
import prueba.tecnica.joaquin.indicedeequilibrio.repository.IndiceEquilibrioRepository;
import prueba.tecnica.joaquin.indicedeequilibrio.utils.CalculadoraEquilibrio;

@ExtendWith(SpringExtension.class)
public class IndiceEquilibrioServiceTest {

	@Mock
	private IndiceEquilibrioRepository indiceEquilibrioRepository;
	
	@Mock
	private IndiceEquilibrioMapper indiceEquilibrioMapper;
	
	@Mock
	private CalculadoraEquilibrio calculadoraIndiceEquilibrio;
	
	@InjectMocks
	private IndiceEquilibrioServiceImpl indiceEquilibrioServiceImpl;
	
	@Test
	public void calculadoraIndiceEquilibrioService() {
		
		IndiceEquilibrioDto respuestaIndiceEquilibrioDto = mock(IndiceEquilibrioDto.class);
		IndiceEquilibrioEntity indiceEquilibrioEntity = mock(IndiceEquilibrioEntity.class);
		IndiceEquilibrioDto inicioIndiceEquilibrioDto = GeneradorDatos.getRandomIndiceEquilibrioDto();
		
		
		when(indiceEquilibrioRepository.save(Mockito.any(IndiceEquilibrioEntity.class))).thenReturn(GeneradorDatos.getRandomIndiceEquilibrioEntity());
		when(indiceEquilibrioMapper.toIndiceEquilibrioModel(Mockito.any(IndiceEquilibrioDto.class))).thenReturn(indiceEquilibrioEntity);
		when(indiceEquilibrioMapper.toIndiceEquilibrioDto(Mockito.any(IndiceEquilibrioEntity.class))).thenReturn(respuestaIndiceEquilibrioDto);
		when(calculadoraIndiceEquilibrio.calcularEquilibrio(Mockito.anyList())).thenReturn(3);

		assertEquals(respuestaIndiceEquilibrioDto,indiceEquilibrioServiceImpl.calcularIndiceEquilibrio(inicioIndiceEquilibrioDto));
		
		Mockito.verify(indiceEquilibrioRepository).save(Mockito.any(IndiceEquilibrioEntity.class));
		Mockito.verify(indiceEquilibrioMapper).toIndiceEquilibrioModel(Mockito.any(IndiceEquilibrioDto.class));
		Mockito.verify(indiceEquilibrioMapper).toIndiceEquilibrioDto(Mockito.any(IndiceEquilibrioEntity.class));
		Mockito.verify(calculadoraIndiceEquilibrio).calcularEquilibrio(Mockito.anyList());
		
	}
	
	@Test
	public void getIndicesEquilibrioTest() {
		
		List<IndiceEquilibrioDto> inicioIndiceEquilibrioDto = GeneradorDatos.getRandomIndiceEquilibrioDtos();
		
		when(indiceEquilibrioRepository.findAll()).thenReturn(GeneradorDatos.getRandomIndiceEquilibrioEntities());
		when(indiceEquilibrioMapper.toListIndiceEquilibrioDto(Mockito.anyList())).thenReturn(inicioIndiceEquilibrioDto);
		
		assertEquals(inicioIndiceEquilibrioDto,indiceEquilibrioServiceImpl.getIndicesEquilibrio());
		
		Mockito.verify(indiceEquilibrioRepository).findAll();
		Mockito.verify(indiceEquilibrioMapper).toListIndiceEquilibrioDto(Mockito.anyList());
		
	}

}
