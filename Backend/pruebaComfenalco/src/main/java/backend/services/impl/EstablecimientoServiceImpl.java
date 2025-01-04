package backend.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.dtos.EstablecimientoDTO;
import backend.entities.Comerciante;
import backend.entities.Establecimiento;
import backend.mappers.EstablecimientoMapper;
import backend.repositories.ComercianteRepository;
import backend.repositories.EstablecimientoRepository;
import backend.services.EstablecimientoService;

@Service
public class EstablecimientoServiceImpl implements EstablecimientoService {
    @Autowired
    private EstablecimientoRepository establecimientoRepository;
    @Autowired
    private ComercianteRepository comercianteRepository;
    @Autowired
    private EstablecimientoMapper mapper;

    @Override
    public List<EstablecimientoDTO> findByComercianteId(Long comercianteId) {
        List<Establecimiento> establecimientos = establecimientoRepository.findByComercianteId(comercianteId);
        return establecimientos.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public EstablecimientoDTO findById(Long id) {
        Establecimiento establecimiento = establecimientoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Establecimiento no encontrado"));
        return mapper.toDTO(establecimiento);
    }

    @Override
    public EstablecimientoDTO save(EstablecimientoDTO establecimientoDTO) {
        Comerciante comerciante = comercianteRepository.findById(establecimientoDTO.getComercianteId())
            .orElseThrow(() -> new RuntimeException("Comerciante no encontrado"));
        Establecimiento establecimiento = mapper.toEntity(establecimientoDTO, comerciante);
        return mapper.toDTO(establecimientoRepository.save(establecimiento));
    }

    @Override
    public void delete(Long id) {
        establecimientoRepository.deleteById(id);
    }
}
