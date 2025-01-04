CREATE
OR REPLACE FUNCTION fn_Reporte_Comerciantes RETURN SYS_REFCURSOR IS cur SYS_REFCURSOR;

BEGIN OPEN cur FOR
SELECT
    c.Nombre,
    c.Departamento,
    c.Municipio,
    c.Telefono,
    c.CorreoElectronico,
    c.FechaRegistro,
    c.Estado,
    COUNT(e.EstablecimientoID) AS CantidadEstablecimientos,
    SUM(e.Ingresos) AS TotalActivos,
    SUM(e.NumeroEmpleados) AS CantidadEmpleados
FROM
    Comerciantes c
    LEFT JOIN Establecimientos e ON c.ComercianteID = e.ComercianteID
WHERE
    c.Estado = 'Activo'
GROUP BY
    c.Nombre,
    c.Departamento,
    c.Municipio,
    c.Telefono,
    c.CorreoElectronico,
    c.FechaRegistro,
    c.Estado
ORDER BY
    COUNT(e.EstablecimientoID) DESC;

RETURN cur;

END;

/