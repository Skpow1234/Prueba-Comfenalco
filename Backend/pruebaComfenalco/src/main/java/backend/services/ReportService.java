package backend.services;

public interface ReportService {
    byte[] generateComerciantePDF(Long comercianteId) throws Exception;
}

