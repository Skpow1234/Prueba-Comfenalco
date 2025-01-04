package backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.services.ReportService;

@RestController
@RequestMapping("/reporte")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/pdf/{comercianteId}")
    public ResponseEntity<byte[]> generatePDF(@PathVariable Long comercianteId) {
        try {
            byte[] pdfContent = reportService.generateComerciantePDF(comercianteId);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=comerciante.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdfContent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

