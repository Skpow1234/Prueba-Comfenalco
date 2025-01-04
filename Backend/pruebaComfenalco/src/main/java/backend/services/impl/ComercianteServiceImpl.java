package backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import backend.dtos.ComercianteDTO;
import backend.entities.Comerciante;
import backend.mappers.EntityMapper;
import backend.repositories.ComercianteRepository;
import backend.services.ComercianteService;

@Service
public class ComercianteServiceImpl implements ComercianteService {
    @Autowired
    private ComercianteRepository comercianteRepository;
    @Autowired
    private EntityMapper mapper;

    @Override
    public Page<ComercianteDTO> findAll(String nombre, String estado, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return comercianteRepository.findByNombreContainingAndEstadoContaining(nombre, estado, pageable)
                                    .map(mapper::toDTO);
    }

    @Override
    public ComercianteDTO findById(Long id) {
        Comerciante comerciante = comercianteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Comerciante no encontrado"));
        return mapper.toDTO(comerciante);
    }

    @Override
    public ComercianteDTO save(ComercianteDTO comercianteDTO) {
        Comerciante comerciante = mapper.toEntity(comercianteDTO);
        return mapper.toDTO(comercianteRepository.save(comerciante));
    }

    @Override
    public void delete(Long id) {
        comercianteRepository.deleteById(id);
    }
}

