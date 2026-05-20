package fenoyagostina.ludeoteca.service;

import fenoyagostina.ludeoteca.dto.request.JuegoRequestDto;
import fenoyagostina.ludeoteca.dto.response.JuegoResponseDto;
import fenoyagostina.ludeoteca.mapper.JuegoMapper;
import fenoyagostina.ludeoteca.model.JuegoEntity;
import fenoyagostina.ludeoteca.repository.JuegoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class JuegoService {

    private final JuegoRepository repository;
    private final JuegoMapper mapper;

    public JuegoService(JuegoRepository repository, JuegoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<JuegoResponseDto> findAll(Boolean activo){
        if(activo!=null){
            return repository.findByActivo(activo).stream()
                    .map(mapper::toDto)
                    .collect(Collectors.toList());
        }
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public JuegoResponseDto findByIdPublico(UUID idPublico){
        return repository.findByIdPublico(idPublico)
                .map(mapper::toDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public JuegoResponseDto save(JuegoRequestDto request){
        JuegoEntity entity = mapper.toEntity(request);
        repository.save(entity);
        return mapper.toDto(entity);
    }
}
