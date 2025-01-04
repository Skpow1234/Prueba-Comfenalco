package backend.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComercianteDTO {
    private Long id;
    private String nombre;
    private String departamento;
    private String municipio;
    private String telefono;
    private String correoElectronico;
    private Date fechaRegistro;
    private String estado;
}

