package backend.services;

import java.util.List;

import backend.dtos.DepartamentoDTO;

public interface ValueListService {
    List<DepartamentoDTO> getDepartamentos();
}
