package fenoyagostina.ludeoteca.mapper;

import fenoyagostina.ludeoteca.dto.ReservaRequestDto;
import fenoyagostina.ludeoteca.dto.ReservaResponseDto;
import fenoyagostina.ludeoteca.model.ReservaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    ReservaEntity toEntity(ReservaRequestDto request);
    ReservaResponseDto toDto(ReservaEntity entity);
}
