package prueba.tecnica.joaquin.indicedeequilibrio.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	public static final Logger LOGGER = LoggerFactory.getLogger(IndiceEquilibrioServiceImpl.class);
	
	@Override
	public IndiceEquilibrioDto calcularIndiceEquilibrio(IndiceEquilibrioDto indiceEquilibrioDto) {
		LOGGER.info("Initializing calcularIndiceEquilibrio");
		indiceEquilibrioDto.setIndiceEquilibrio(CalculadoraEquilibrio.calcularEquilibrio(indiceEquilibrioDto.getEnteros()));
		
		indiceEquilibrioDto.setFechaActual(LocalDateTime.now());

		indiceEquilibrioRepository.save(indiceEquilibrioMapper.toIndiceEquilibrioModel(indiceEquilibrioDto));
		
		LOGGER.info("Finalizing calcularIndiceEquilibrio");
		return indiceEquilibrioDto;
	}

	@Override
	public List<IndiceEquilibrioDto> getIndicesEquilibrio() {
		LOGGER.info("Initializing getIndicesEquilibrio");

		List<IndiceEquilibrioEntity> listIndiceEquilibrioEntity = indiceEquilibrioRepository.findAll();
		
		List<IndiceEquilibrioDto> listIndiceEquilibrioDto = indiceEquilibrioMapper.toListIndiceEquilibrioDto(listIndiceEquilibrioEntity);
		
		LOGGER.info("Finalizing getIndicesEquilibrio");
		return listIndiceEquilibrioDto;
	}
	
	
}
