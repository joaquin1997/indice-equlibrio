package prueba.tecnica.joaquin.indicedeequilibrio.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public IndiceEquilibrioDto postIndiceEquilibrio(@RequestBody IndiceEquilibrioDto indiceEquilibrioDto) {
		return indiceEquilibrioService.calcularIndiceEquilibrio(indiceEquilibrioDto);
	}
	@GetMapping("getIndicesEquilibrio")
	public List<IndiceEquilibrioDto> getIndicesEquilibrio() {
		return indiceEquilibrioService.getIndicesEquilibrio();
	}
}
