package backend.mappers;

import org.springframework.stereotype.Component;

import backend.dtos.ComercianteDTO;
import backend.entities.Comerciante;

@Component
public class EntityMapper {
    public ComercianteDTO toDTO(Comerciante comerciante) {
        return new ComercianteDTO(
            comerciante.getId(),
            comerciante.getNombre(),
            comerciante.getDepartamento(),
            comerciante.getMunicipio(),
            comerciante.getTelefono(),
            comerciante.getCorreoElectronico(),
            comerciante.getFechaRegistro(),
            comerciante.getEstado()
        );
    }

    public Comerciante toEntity(ComercianteDTO dto) {
        Comerciante comerciante = new Comerciante();
        comerciante.setId(dto.getId());
        comerciante.setNombre(dto.getNombre());
        comerciante.setDepartamento(dto.getDepartamento());
        comerciante.setMunicipio(dto.getMunicipio());
        comerciante.setTelefono(dto.getTelefono());
        comerciante.setCorreoElectronico(dto.getCorreoElectronico());
        comerciante.setFechaRegistro(dto.getFechaRegistro());
        comerciante.setEstado(dto.getEstado());
        return comerciante;
    }
}

