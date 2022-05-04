package prueba.tecnica.joaquin.indicedeequilibrio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import prueba.tecnica.joaquin.indicedeequilibrio.dto.IndiceEquilibrioDto;
import prueba.tecnica.joaquin.indicedeequilibrio.rest.RestEquilibrioController;

@SpringBootTest
class IndiceDeEquilibrioApplicationTests {

	@Autowired
	RestEquilibrioController restEquilibrioController;
	
	
	@Test
	void testOkResponse() {
		IndiceEquilibrioDto indiceEquilibrioDto = new IndiceEquilibrioDto();
		IndiceEquilibrioDto expectedIndiceEquilibrioDto = new IndiceEquilibrioDto();
		expectedIndiceEquilibrioDto.setEnteros(List.of(-7, 1, 5, 2, -4, 3, 0));
		expectedIndiceEquilibrioDto.setIndiceEquilibrio(3);
		expectedIndiceEquilibrioDto.setFechaActual(LocalDate.now());
		
		indiceEquilibrioDto.setEnteros(List.of(-7, 1, 5, 2, -4, 3, 0));
		
		ResponseEntity<IndiceEquilibrioDto> indiceEquilibrioDtoExpected = ResponseEntity.ok(expectedIndiceEquilibrioDto);
		ResponseEntity<IndiceEquilibrioDto> indiceEquilibrioDtoResponse = restEquilibrioController.postIndiceEquilibrio(indiceEquilibrioDto);
		
		assertEquals(indiceEquilibrioDtoExpected.getStatusCode(),indiceEquilibrioDtoResponse.getStatusCode());
		assertEquals(indiceEquilibrioDtoExpected.getBody(),indiceEquilibrioDtoResponse.getBody());
		
	}
	
	@Test
	void testBadRequestResponse() {
		IndiceEquilibrioDto expectedIndiceEquilibrioDto = new IndiceEquilibrioDto();
		
		ResponseEntity<IndiceEquilibrioDto> indiceEquilibrioDtoExpected = new ResponseEntity<IndiceEquilibrioDto>(expectedIndiceEquilibrioDto,HttpStatus.BAD_REQUEST);
		ResponseEntity<IndiceEquilibrioDto> indiceEquilibrioDtoResponse = restEquilibrioController.postIndiceEquilibrio(null);
		
		assertEquals(indiceEquilibrioDtoExpected.getStatusCode(),indiceEquilibrioDtoResponse.getStatusCode());
		
	}

}
