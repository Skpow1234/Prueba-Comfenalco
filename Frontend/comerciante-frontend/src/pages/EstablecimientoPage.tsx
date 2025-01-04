import React, { useState } from "react";
import EstablecimientoTable from "../components/EstablecimientoTable";

const EstablecimientoPage: React.FC = () => {
    const [comercianteId, setComercianteId] = useState<number | null>(null);

    const handleSearch = () => {
        const id = Number(prompt("Ingrese el ID del comerciante:"));
        if (!isNaN(id)) setComercianteId(id);
    };

    return (
        <div>
            <h1>Establecimientos</h1>
            <button onClick={handleSearch}>Buscar Establecimientos</button>
            {comercianteId !== null && (
                <EstablecimientoTable comercianteId={comercianteId} />
            )}
        </div>
    );
};

export default EstablecimientoPage;
