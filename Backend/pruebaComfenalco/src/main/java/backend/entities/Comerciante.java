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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "COMERCIANTES") // Nombre en mayúsculas para Oracle
public class Comerciante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comerciante_seq")
    @SequenceGenerator(name = "comerciante_seq", sequenceName = "COMERCIANTE_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "DEPARTAMENTO", nullable = false)
    private String departamento;

    @Column(name = "MUNICIPIO", nullable = false)
    private String municipio;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;

    @Column(name = "FECHA_REGISTRO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "ESTADO", nullable = false)
    private String estado; // Valores: 'Registrado', 'Activo', 'Inactivo', etc.

    // Auditoría
    @Column(name = "FECHA_ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;

    @Column(name = "USUARIO")
    private String usuario; // Usuario que realizó la última actualización

    // Relación con User (opcional)
    @ManyToOne
    @JoinColumn(name = "USUARIO_ID")
    private User usuarioResponsable;

    // Getters y Setters
}


