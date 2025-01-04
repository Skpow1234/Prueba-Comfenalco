/* eslint-disable @typescript-eslint/no-explicit-any */
import React, { useEffect, useState } from "react";
import establecimientoService from "../services/establecimientoService";

interface Props {
    comercianteId: number;
}

const EstablecimientoTable: React.FC<Props> = ({ comercianteId }) => {
    const [establecimientos, setEstablecimientos] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const data = await establecimientoService.getByComercianteId(
                comercianteId
            );
            setEstablecimientos(data);
        };
        fetchData();
    }, [comercianteId]);

    return (
        <div>
            <h2>Lista de Establecimientos</h2>
            <table>
                <thead>
                    <tr>                        <th>Nombre</th>
                        <th>Ingresos</th>
                        <th>Número de Empleados</th>
                    </tr>
                </thead>
                <tbody>
                    // eslint-disable-next-line @typescript-eslint/no-explicit-any
                    {establecimientos.map((establecimiento: any) => (
                        <tr key={establecimiento.id}>
                            <td>{establecimiento.nombre}</td>
                            <td>{establecimiento.ingresos}</td>
                            <td>{establecimiento.numeroEmpleados}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default EstablecimientoTable;
