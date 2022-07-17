package prueba.tecnica.joaquin.indicedeequilibrio.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prueba.tecnica.joaquin.indicedeequilibrio.dto.IndiceEquilibrioDto;
import prueba.tecnica.joaquin.indicedeequilibrio.service.IndiceEquilibrioServiceImpl;

@RestController
@RequestMapping("/indiceEquilibrio")
public class RestEquilibrioController {
	
    @Autowired
    private IndiceEquilibrioServiceImpl indiceEquilibrioService;
    
    public static Logger LOGGER = LoggerFactory.getLogger(IndiceEquilibrioServiceImpl.class);
    
	@PostMapping("calcularIndiceEquilibrio")
	public ResponseEntity<IndiceEquilibrioDto> postIndiceEquilibrio(@RequestBody IndiceEquilibrioDto indiceEquilibrioDto) {
		LOGGER.info("Initializing postIndiceEquilibrio");
		
		IndiceEquilibrioDto indiceEquilibrio;
		if(indiceEquilibrioDto==null || indiceEquilibrioDto.getEnteros()==null) {
			return  ResponseEntity.badRequest().build();
		}
		
		indiceEquilibrio = indiceEquilibrioService.calcularIndiceEquilibrio(indiceEquilibrioDto);
		
		LOGGER.info("Finalizing postIndiceEquilibrio");

		return ResponseEntity.ok(indiceEquilibrio);
	}
	
	@GetMapping("getIndicesEquilibrio")
	public ResponseEntity<List<IndiceEquilibrioDto>> getIndicesEquilibrio() {
		LOGGER.info("Initializing getIndicesEquilibrio");
		
		List<IndiceEquilibrioDto> indiceEquilibrio = indiceEquilibrioService.getIndicesEquilibrio();
		
		LOGGER.info("Finalizing getIndicesEquilibrio");
		
		return ResponseEntity.ok(indiceEquilibrio);
	}
}
