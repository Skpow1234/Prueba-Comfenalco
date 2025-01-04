package backend.services;

import org.springframework.data.domain.Page;

import backend.dtos.ComercianteDTO;

public interface ComercianteService {
    Page<ComercianteDTO> findAll(String nombre, String estado, int page, int size);
    ComercianteDTO findById(Long id);
    ComercianteDTO save(ComercianteDTO comercianteDTO);
    void delete(Long id);
}

