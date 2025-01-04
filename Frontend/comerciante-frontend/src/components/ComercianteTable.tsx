import React, { useEffect, useState } from "react";
import comercianteService from "../services/comercianteService";

interface Comerciante {
    id: number;
    nombre: string;
    departamento: string;
    municipio: string;
    estado: string;
}

const ComercianteTable: React.FC = () => {
    const [comerciantes, setComerciantes] = useState<Comerciante[]>([]);

    useEffect(() => {
        const fetchData = async () => {
            const data = await comercianteService.getAll();
            setComerciantes(data.content);
        };
        fetchData();
    }, []);

    return (
        <div>
            <h1>Lista de Comerciantes</h1>
            <table>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Departamento</th>
                        <th>Municipio</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody>
                    {comerciantes.map((comerciante) => (
                        <tr key={comerciante.id}>
                            <td>{comerciante.nombre}</td>
                            <td>{comerciante.departamento}</td>
                            <td>{comerciante.municipio}</td>
                            <td>{comerciante.estado}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default ComercianteTable;
