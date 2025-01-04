package backend.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.entities.Comerciante;
import backend.repositories.ComercianteRepository;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/reporte")
public class ReportCSVController {
    @Autowired
    private ComercianteRepository comercianteRepository;

    @GetMapping("/csv")
    public void generateCSV(HttpServletResponse response) throws IOException {
        // Configurar cabeceras del archivo CSV
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=comerciantes.csv");

        // Obtener datos de comerciantes
        List<Comerciante> comerciantes = comercianteRepository.findAll();

        // Crear archivo CSV
        PrintWriter writer = response.getWriter();
        writer.println("Nombre,Departamento,Municipio,Teléfono,Correo Electrónico,Fecha Registro,Estado");

        for (Comerciante comerciante : comerciantes) {
            writer.printf("%s,%s,%s,%s,%s,%s,%s%n",
                    comerciante.getNombre(),
                    comerciante.getDepartamento(),
                    comerciante.getMunicipio(),
                    comerciante.getTelefono(),
                    comerciante.getCorreoElectronico(),
                    comerciante.getFechaRegistro(),
                    comerciante.getEstado()
            );
        }

        writer.flush();
    }
}

