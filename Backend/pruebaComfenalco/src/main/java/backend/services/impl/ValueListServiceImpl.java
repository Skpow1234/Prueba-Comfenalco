package backend.services.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import backend.dtos.DepartamentoDTO;
import backend.services.ValueListService;

@Service
public class ValueListServiceImpl implements ValueListService {
    private static final Map<String, List<String>> DEPARTAMENTOS = Map.of(
        "Departamento 1", List.of("Municipio 1-1", "Municipio 1-2"),
        "Departamento 2", List.of("Municipio 2-1", "Municipio 2-2")
    );

    @Override
    public List<DepartamentoDTO> getDepartamentos() {
        return DEPARTAMENTOS.entrySet().stream()
                .map(entry -> new DepartamentoDTO())
                .collect(Collectors.toList());
    }
}

