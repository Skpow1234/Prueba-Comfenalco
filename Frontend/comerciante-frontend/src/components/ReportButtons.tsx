import React from "react";

const ReportButtons: React.FC = () => {
    const downloadCSV = () => {
        window.open("http://localhost:8080/reporte/csv", "_blank");
    };

    const downloadPDF = (comercianteId: number) => {
        window.open(`http://localhost:8080/reporte/pdf/${comercianteId}`, "_blank");
    };

    return (
        <div>
            <button onClick={downloadCSV}>Descargar CSV</button>
            <button onClick={() => downloadPDF(1)}>Descargar PDF (Comerciante 1)</button>
        </div>
    );
};

export default ReportButtons;
