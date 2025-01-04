package backend.mappers;

import org.springframework.stereotype.Component;

import backend.dtos.EstablecimientoDTO;
import backend.entities.Comerciante;
import backend.entities.Establecimiento;

@Component
public class EstablecimientoMapper {
    public EstablecimientoDTO toDTO(Establecimiento establecimiento) {
        return new EstablecimientoDTO(
            establecimiento.getId(),
            establecimiento.getComerciante().getId(),
            establecimiento.getNombre(),
            establecimiento.getIngresos(),
            establecimiento.getNumeroEmpleados()
        );
    }

    public Establecimiento toEntity(EstablecimientoDTO dto, Comerciante comerciante) {
        Establecimiento establecimiento = new Establecimiento();
        establecimiento.setId(dto.getId());
        establecimiento.setComerciante(comerciante);
        establecimiento.setNombre(dto.getNombre());
        establecimiento.setIngresos(dto.getIngresos());
        establecimiento.setNumeroEmpleados(dto.getNumeroEmpleados());
        return establecimiento;
    }
}

