package prueba.tecnica.joaquin.indicedeequilibrio.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import prueba.tecnica.joaquin.indicedeequilibrio.GeneradorDatos;
import prueba.tecnica.joaquin.indicedeequilibrio.dto.IndiceEquilibrioDto;
import prueba.tecnica.joaquin.indicedeequilibrio.service.IndiceEquilibrioServiceImpl;

@ExtendWith(SpringExtension.class)
public class IndiceEquilibrioControllerRestTest {
	
	@Mock
	private IndiceEquilibrioServiceImpl indiceEquilibrioServiceImpl;
	
	@InjectMocks
	private RestEquilibrioController restEquilibrioController;
	
	@Test
	public void calcularEqulibrioTest() {
		ResponseEntity<IndiceEquilibrioDto> expected = ResponseEntity.ok(GeneradorDatos.getRandomIndiceEquilibrioDto());
		
		when(indiceEquilibrioServiceImpl.calcularIndiceEquilibrio(Mockito.any(IndiceEquilibrioDto.class))).thenReturn(expected.getBody());
		
		ResponseEntity<IndiceEquilibrioDto> actual = restEquilibrioController.postIndiceEquilibrio(mock(IndiceEquilibrioDto.class));
		
		verify(indiceEquilibrioServiceImpl).calcularIndiceEquilibrio(Mockito.any(IndiceEquilibrioDto.class));
		
		assertEquals(expected,actual);
		
	}
	
	@Test
	public void calcularEqulibrioNullTest() {
		ResponseEntity<IndiceEquilibrioDto> expected = ResponseEntity.ok(GeneradorDatos.getRandomIndiceEquilibrioDto());
		
		when(indiceEquilibrioServiceImpl.calcularIndiceEquilibrio(Mockito.any(IndiceEquilibrioDto.class))).thenReturn(expected.getBody());
		
		ResponseEntity<IndiceEquilibrioDto> actual = restEquilibrioController.postIndiceEquilibrio(mock(IndiceEquilibrioDto.class));
		
		verify(indiceEquilibrioServiceImpl).calcularIndiceEquilibrio(Mockito.any(IndiceEquilibrioDto.class));
		
		assertEquals(expected,actual);
		
	}
	
	@Test
	public void getEqulibrioTest() {
		ResponseEntity<List<IndiceEquilibrioDto>> expected = ResponseEntity.ok(GeneradorDatos.getRandomIndiceEquilibrioDtos());
		
		when(indiceEquilibrioServiceImpl.getIndicesEquilibrio()).thenReturn(expected.getBody());
		
		ResponseEntity<List<IndiceEquilibrioDto>> actual = restEquilibrioController.getIndicesEquilibrio();
		
		verify(indiceEquilibrioServiceImpl).getIndicesEquilibrio();
		
		assertEquals(expected,actual);
		
	}
}
