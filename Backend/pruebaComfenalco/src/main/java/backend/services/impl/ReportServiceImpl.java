package backend.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.pdf.codec.Base64.InputStream;

import backend.entities.Comerciante;
import backend.repositories.ComercianteRepository;
import backend.services.ReportService;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ComercianteRepository comercianteRepository;

    @Override
    public byte[] generateComerciantePDF(Long comercianteId) throws Exception {
        // Buscar comerciante por ID
        Comerciante comerciante = comercianteRepository.findById(comercianteId)
                .orElseThrow(() -> new RuntimeException("Comerciante no encontrado"));

        // Datos para el reporte
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nombre", comerciante.getNombre());
        parameters.put("departamento", comerciante.getDepartamento());
        parameters.put("municipio", comerciante.getMunicipio());
        parameters.put("telefono", comerciante.getTelefono());
        parameters.put("correo", comerciante.getCorreoElectronico());
        parameters.put("fechaRegistro", comerciante.getFechaRegistro());
        parameters.put("estado", comerciante.getEstado());

        // Cargar la plantilla Jasper
        InputStream reportStream = (InputStream) getClass().getResourceAsStream("/reports/comerciante_report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        // Llenar el reporte
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

        // Exportar el reporte a PDF
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
