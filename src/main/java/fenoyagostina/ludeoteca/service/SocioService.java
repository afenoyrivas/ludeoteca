package fenoyagostina.ludeoteca.service;

import fenoyagostina.ludeoteca.dto.request.SocioRequestDto;
import fenoyagostina.ludeoteca.dto.response.SocioResponseDto;
import fenoyagostina.ludeoteca.exception.DniYaExisteException;
import fenoyagostina.ludeoteca.exception.EmailYaExisteException;
import fenoyagostina.ludeoteca.mapper.SocioMapper;
import fenoyagostina.ludeoteca.model.SocioEntity;
import fenoyagostina.ludeoteca.repository.SocioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocioService {

    private SocioRepository socioRepository;
    private SocioMapper socioMapper;

    List<SocioResponseDto> findAll(){
        return socioRepository.findAll().stream()
                .map(socioMapper::toDto)
                .collect(Collectors.toList());
    }

    SocioResponseDto findById(Integer socioId ){
        return socioRepository.findById(socioId)
                .map(socioMapper::toDto)
                .orElseThrow(EntityNotFoundException::new);

    }

    SocioResponseDto findByDni(String dni){
        return socioRepository.findByDni(dni)
                .map(socioMapper::toDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    SocioResponseDto save(SocioRequestDto request){
        if(socioRepository.existsByDni(request.getDni())){
            throw new DniYaExisteException(request.getDni());
        }
        if(socioRepository.existsByEmail(request.getEmail())){
            throw new EmailYaExisteException(request.getEmail());
        }
        SocioEntity entity = socioMapper.toEntity(request);
        socioRepository.save(entity);
        return socioMapper.toDto(entity);
    }
}
