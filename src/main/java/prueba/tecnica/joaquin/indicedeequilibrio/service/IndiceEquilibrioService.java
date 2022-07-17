package prueba.tecnica.joaquin.indicedeequilibrio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import prueba.tecnica.joaquin.indicedeequilibrio.dto.IndiceEquilibrioDto;
@Service
interface IndiceEquilibrioService {

	public IndiceEquilibrioDto calcularIndiceEquilibrio(IndiceEquilibrioDto enteros);
	
	public List<IndiceEquilibrioDto> getIndicesEquilibrio();
	
}
