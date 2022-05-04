package prueba.tecnica.joaquin.indicedeequilibrio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import prueba.tecnica.joaquin.indicedeequilibrio.dto.IndiceEquilibrioDto;
import prueba.tecnica.joaquin.indicedeequilibrio.model.IndiceEquilibrioEntity;
import prueba.tecnica.joaquin.indicedeequilibrio.model.NumerosEntity;

public class GeneradorDatos {

	public static IndiceEquilibrioDto getRandomIndiceEquilibrioDto() {
		IndiceEquilibrioDto indiceEquilibrioDto = new IndiceEquilibrioDto();
		indiceEquilibrioDto.setEnteros(getRandomList());
		indiceEquilibrioDto.setFechaActual(LocalDate.now());
		indiceEquilibrioDto.setIndiceEquilibrio(getRandom(1, 100));
		
		return indiceEquilibrioDto;
		
	}
	
	public static IndiceEquilibrioEntity getRandomIndiceEquilibrioEntity() {
		IndiceEquilibrioEntity indiceEquilibrioEntity = new IndiceEquilibrioEntity();
		indiceEquilibrioEntity.setEnteros(getNumerosEnteros(indiceEquilibrioEntity));
		indiceEquilibrioEntity.setFechaActual(LocalDate.now());
		indiceEquilibrioEntity.setIndiceEquilibrio(getRandom(-1,100));
		return indiceEquilibrioEntity;
	}
	

	public static List<IndiceEquilibrioEntity> getRandomIndiceEquilibrioEntities(){
		List<IndiceEquilibrioEntity> indiceEquilibrioEntities = new ArrayList<IndiceEquilibrioEntity>();
		
		for(int i=0; i<getRandom(6,20);i++) {
			indiceEquilibrioEntities.add(getRandomIndiceEquilibrioEntity());
		}
		
		return indiceEquilibrioEntities;
	}
	
	public static List<IndiceEquilibrioDto> getRandomIndiceEquilibrioDtos(){
		List<IndiceEquilibrioDto> indiceEquilibrioDtos = new ArrayList<IndiceEquilibrioDto>();
		
		for(int i=0; i<getRandom(6,20);i++) {
			indiceEquilibrioDtos.add(getRandomIndiceEquilibrioDto());
		}
		
		return indiceEquilibrioDtos;
	}
	
	public static List<NumerosEntity> getNumerosEnteros(final IndiceEquilibrioEntity indiceEquilibrioEntity ){
		List<Integer> enteros = getRandomList();
	
		return  enteros.stream().map((entero) -> {
			NumerosEntity numeroEntity = new NumerosEntity();
			numeroEntity.setNumero(entero);
			return numeroEntity;
		}).collect(Collectors.toList());
				
		
	}
	
	
	public static List<Integer> getRandomList() {
		List<Integer> integerList = new ArrayList<Integer>();
		for(int i=0;i<getRandom(6,20);i++) {
			integerList.add(getRandom(1,100));
		}
		return integerList;
	}
		
	public static int getRandom(int min, int max) {
		  return (int) (Math.random() * (max - min) + min);
	}
	
}
