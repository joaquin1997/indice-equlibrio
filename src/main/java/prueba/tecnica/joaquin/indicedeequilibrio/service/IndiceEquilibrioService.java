package prueba.tecnica.joaquin.indicedeequilibrio.service;

import java.util.List;

import prueba.tecnica.joaquin.indicedeequilibrio.dto.IndiceEquilibrioDto;

public interface IndiceEquilibrioService {

	public IndiceEquilibrioDto calcularIndiceEquilibrio(IndiceEquilibrioDto enteros);
	
	public List<IndiceEquilibrioDto> getIndicesEquilibrio();
	
}
