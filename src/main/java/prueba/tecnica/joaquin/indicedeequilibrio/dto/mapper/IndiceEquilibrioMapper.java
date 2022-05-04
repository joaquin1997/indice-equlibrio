package prueba.tecnica.joaquin.indicedeequilibrio.dto.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

import prueba.tecnica.joaquin.indicedeequilibrio.dto.IndiceEquilibrioDto;
import prueba.tecnica.joaquin.indicedeequilibrio.model.IndiceEquilibrioEntity;
import prueba.tecnica.joaquin.indicedeequilibrio.model.NumerosEntity;

@Mapper(componentModel = "spring")
public interface IndiceEquilibrioMapper {
	
	//Este mapping no se puede hacer automático así que debemos hacerlo a mano
	default List<Integer> toListEnterosEntity(List<NumerosEntity> numerosEntity) {
		if (numerosEntity == null) {
			return null;
		}
		//Obtenemos todos los enteros de la lista de numeros entity y los introducimos a una lista de enteros
		 final List<Integer> listNumerosEntity = numerosEntity.stream().filter(Objects::nonNull)
				.filter((numeroEntity) -> numeroEntity != null).map((numeroEntity) -> numeroEntity.getNumero())
				.collect(Collectors.toList());
		return listNumerosEntity;

	}

	//Este mapping no se puede hacer automático así que debemos hacerlo a mano
	default List<NumerosEntity> toListNumerosEntity(List<Integer> enteros) {

		if (enteros == null) {
			return null;
		}
		
		//Se obtienen los enteros que no sean nulos, se mapea a un NumerosEntity y lo convertimos a lista de numeros
		final List<NumerosEntity> numerosEntity = enteros.stream().filter(Objects::nonNull).map((entero) -> {
			NumerosEntity numeroEntity = new NumerosEntity();
			numeroEntity.setNumero(entero);
			return numeroEntity;
		}).collect(Collectors.toList());

		return numerosEntity;
	}

	public IndiceEquilibrioDto toIndiceEquilibrioDto(IndiceEquilibrioEntity indiceEquilibrioModel);

	public IndiceEquilibrioEntity toIndiceEquilibrioModel(IndiceEquilibrioDto indiceEquilibrioModel);

	public List<IndiceEquilibrioDto> toListIndiceEquilibrioDto(List<IndiceEquilibrioEntity> indiceEquilibrioModel);

}
