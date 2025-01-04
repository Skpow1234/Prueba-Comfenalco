package backend.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ESTABLECIMIENTOS") // Nombre de tabla en mayúsculas para Oracle
public class Establecimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "establecimiento_seq")
    @SequenceGenerator(name = "establecimiento_seq", sequenceName = "ESTABLECIMIENTO_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "COMERCIANTE_ID", nullable = false) // Nombre en mayúsculas
    private Comerciante comerciante;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "INGRESOS")
    private Double ingresos;

    @Column(name = "NUMERO_EMPLEADOS")
    private Integer numeroEmpleados;

    @Column(name = "FECHA_ACTUALIZACION")
    private Date fechaActualizacion;

    @Column(name = "USUARIO")
    private String usuario;

    // Getters y Setters
}


