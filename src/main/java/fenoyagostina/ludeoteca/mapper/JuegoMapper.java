package fenoyagostina.ludeoteca.mapper;

import fenoyagostina.ludeoteca.dto.JuegoRequestDto;
import fenoyagostina.ludeoteca.dto.JuegoResponseDto;
import fenoyagostina.ludeoteca.model.JuegoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JuegoMapper {

    JuegoEntity toEntity(JuegoRequestDto request);
    JuegoResponseDto toDto(JuegoEntity entity);
}
