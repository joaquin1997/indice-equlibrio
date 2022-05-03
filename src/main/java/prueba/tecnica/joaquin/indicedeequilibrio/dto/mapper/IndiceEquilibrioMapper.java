package prueba.tecnica.joaquin.indicedeequilibrio.dto.mapper;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

import prueba.tecnica.joaquin.indicedeequilibrio.dto.IndiceEquilibrioDto;
import prueba.tecnica.joaquin.indicedeequilibrio.model.IndiceEquilibrioEntity;
import prueba.tecnica.joaquin.indicedeequilibrio.model.NumerosEntity;

@Mapper(componentModel = "spring")
public interface IndiceEquilibrioMapper {

	default Integer[] toListEnterosEntity(List<NumerosEntity> numerosEntity) {
		if (numerosEntity == null) {
			return null;
		}
		final List<Integer> listNumerosEntity = numerosEntity.stream().filter(Objects::nonNull)
				.filter((numeroEntity) -> numeroEntity != null).map((numeroEntity) -> numeroEntity.getNumero())
				.collect(Collectors.toList());
		return listNumerosEntity.toArray(Integer[]::new);

	}

	default List<NumerosEntity> toListNumerosEntity(Integer[] enteros) {

		if (enteros == null) {
			return null;
		}
		final List<NumerosEntity> numerosEntity = Arrays.stream(enteros).filter(Objects::nonNull).map((integer) -> {
			NumerosEntity numeroEntity = new NumerosEntity();
			numeroEntity.setNumero(integer);
			return numeroEntity;
		}).collect(Collectors.toList());

		return numerosEntity;
	}

	public IndiceEquilibrioDto toIndiceEquilibrioDto(IndiceEquilibrioEntity indiceEquilibrioModel);

	public IndiceEquilibrioEntity toIndiceEquilibrioModel(IndiceEquilibrioDto indiceEquilibrioModel);

	public List<IndiceEquilibrioDto> toListIndiceEquilibrioDto(List<IndiceEquilibrioEntity> indiceEquilibrioModel);

}
