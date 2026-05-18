package fenoyagostina.ludeoteca.mapper;

import fenoyagostina.ludeoteca.dto.request.SocioRequestDto;
import fenoyagostina.ludeoteca.dto.response.SocioResponseDto;
import fenoyagostina.ludeoteca.model.SocioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SocioMapper {

    SocioEntity toEntity(SocioRequestDto request);
    SocioResponseDto toDto(SocioEntity entity);
}
