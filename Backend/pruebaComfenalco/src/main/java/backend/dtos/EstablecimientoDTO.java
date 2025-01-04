package backend.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EstablecimientoDTO {
    private Long id;
    private Long comercianteId; // ID del comerciante asociado
    private String nombre;
    private Double ingresos;
    private Integer numeroEmpleados;
}

