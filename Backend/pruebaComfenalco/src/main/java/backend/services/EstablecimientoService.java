package backend.services;

import java.util.List;

import backend.dtos.EstablecimientoDTO;

public interface EstablecimientoService {
    List<EstablecimientoDTO> findByComercianteId(Long comercianteId);
    EstablecimientoDTO findById(Long id);
    EstablecimientoDTO save(EstablecimientoDTO establecimientoDTO);
    void delete(Long id);
}

