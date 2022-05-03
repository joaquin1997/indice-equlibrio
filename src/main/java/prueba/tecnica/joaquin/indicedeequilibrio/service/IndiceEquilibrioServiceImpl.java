package prueba.tecnica.joaquin.indicedeequilibrio.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prueba.tecnica.joaquin.indicedeequilibrio.dto.IndiceEquilibrioDto;
import prueba.tecnica.joaquin.indicedeequilibrio.dto.mapper.IndiceEquilibrioMapper;
import prueba.tecnica.joaquin.indicedeequilibrio.model.IndiceEquilibrioEntity;
import prueba.tecnica.joaquin.indicedeequilibrio.repository.IndiceEquilibrioRepository;
import prueba.tecnica.joaquin.indicedeequilibrio.utils.CalculadoraEquilibrio;

@Service
public class IndiceEquilibrioServiceImpl implements IndiceEquilibrioService{
	
	@Autowired
	private IndiceEquilibrioMapper indiceEquilibrioMapper;
	
	@Autowired
	private IndiceEquilibrioRepository indiceEquilibrioRepository;
	
	@Override
	public IndiceEquilibrioDto calcularIndiceEquilibrio(IndiceEquilibrioDto indiceEquilibrioDto) {
		
		indiceEquilibrioDto.setIndiceEquilibrio(CalculadoraEquilibrio.calcularEquilibrio(indiceEquilibrioDto.getEnteros()));
		
		IndiceEquilibrioEntity indiceEquilibrioEntity = indiceEquilibrioMapper.toIndiceEquilibrioModel(indiceEquilibrioDto);
		
		indiceEquilibrioEntity.setFechaActual(LocalDate.now());
		
		indiceEquilibrioDto=indiceEquilibrioMapper.toIndiceEquilibrioDto(indiceEquilibrioRepository.save(indiceEquilibrioEntity));
		
		return indiceEquilibrioDto;
	}

	@Override
	public List<IndiceEquilibrioDto> getIndicesEquilibrio() {

		List<IndiceEquilibrioEntity> listIndiceEquilibrioEntity = indiceEquilibrioRepository.findAll();
		
		List<IndiceEquilibrioDto> listIndiceEquilibrioDto = indiceEquilibrioMapper.toListIndiceEquilibrioDto(listIndiceEquilibrioEntity);
		
		return listIndiceEquilibrioDto;
	}
	
	
}
