package prueba.tecnica.joaquin.indicedeequilibrio.rest;

import java.util.List;

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
    
	@PostMapping("calcularIndiceEquilibrio")
	public ResponseEntity<IndiceEquilibrioDto> postIndiceEquilibrio(@RequestBody IndiceEquilibrioDto indiceEquilibrioDto) {
		if(indiceEquilibrioDto==null || indiceEquilibrioDto.getEnteros()==null) {
			return  ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(indiceEquilibrioService.calcularIndiceEquilibrio(indiceEquilibrioDto));
	}
	
	@GetMapping("getIndicesEquilibrio")
	public ResponseEntity<List<IndiceEquilibrioDto>> getIndicesEquilibrio() {
		return ResponseEntity.ok(indiceEquilibrioService.getIndicesEquilibrio());
	}
}
