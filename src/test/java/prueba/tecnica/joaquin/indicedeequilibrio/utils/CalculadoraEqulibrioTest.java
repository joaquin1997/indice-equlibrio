package prueba.tecnica.joaquin.indicedeequilibrio.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class CalculadoraEqulibrioTest {
	
	@InjectMocks
	private CalculadoraEquilibrio calculadora;

	@Test
	public void testCalcularIndiceEquilibrio() {
		Integer indiceEsperado = 3;

		Integer actual = calculadora.calcularEquilibrio(List.of ( -7, 1, 5, 2, -4, 3, 0 ));

		assertEquals(indiceEsperado,actual);
	}
	
	@Test
	public void testNullCalcularIndiceEquilibrio() {
		Integer indiceEsperado = -1;
		
		Integer actual = calculadora.calcularEquilibrio(null);
		
		assertEquals(indiceEsperado,actual);
	}
	
}
