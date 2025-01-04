CREATE
OR REPLACE PACKAGE pkg_Comerciantes AS FUNCTION ConsultarPorID (ComercianteID IN NUMBER) RETURN SYS_REFCURSOR;

FUNCTION Consultar (Nombre IN VARCHAR2, Estado IN VARCHAR2) RETURN SYS_REFCURSOR;

PROCEDURE CrearComerciante (
    Nombre IN VARCHAR2,
    Departamento IN VARCHAR2,
    Municipio IN VARCHAR2,
    Telefono IN VARCHAR2,
    CorreoElectronico IN VARCHAR2,
    Estado IN VARCHAR2
);

PROCEDURE ActualizarComerciante (
    ComercianteID IN NUMBER,
    Nombre IN VARCHAR2,
    Departamento IN VARCHAR2,
    Municipio IN VARCHAR2,
    Telefono IN VARCHAR2,
    CorreoElectronico IN VARCHAR2,
    Estado IN VARCHAR2
);

PROCEDURE EliminarComerciante (ComercianteID IN NUMBER);

END pkg_Comerciantes;

/ CREATE
OR REPLACE PACKAGE BODY pkg_Comerciantes AS FUNCTION ConsultarPorID (ComercianteID IN NUMBER) RETURN SYS_REFCURSOR IS cur SYS_REFCURSOR;

BEGIN OPEN cur FOR
SELECT
    *
FROM
    Comerciantes
WHERE
    ComercianteID = ComercianteID;

RETURN cur;

END;

FUNCTION Consultar (Nombre IN VARCHAR2, Estado IN VARCHAR2) RETURN SYS_REFCURSOR IS cur SYS_REFCURSOR;

BEGIN OPEN cur FOR
SELECT
    *
FROM
    Comerciantes
WHERE
    Nombre LIKE '%' || Nombre || '%'
    AND Estado = Estado;

RETURN cur;

END;

PROCEDURE CrearComerciante (
    Nombre IN VARCHAR2,
    Departamento IN VARCHAR2,
    Municipio IN VARCHAR2,
    Telefono IN VARCHAR2,
    CorreoElectronico IN VARCHAR2,
    Estado IN VARCHAR2
) IS BEGIN
INSERT INTO
    Comerciantes (
        Nombre,
        Departamento,
        Municipio,
        Telefono,
        CorreoElectronico,
        Estado
    )
VALUES
    (
        Nombre,
        Departamento,
        Municipio,
        Telefono,
        CorreoElectronico,
        Estado
    );

END;

PROCEDURE ActualizarComerciante (
    ComercianteID IN NUMBER,
    Nombre IN VARCHAR2,
    Departamento IN VARCHAR2,
    Municipio IN VARCHAR2,
    Telefono IN VARCHAR2,
    CorreoElectronico IN VARCHAR2,
    Estado IN VARCHAR2
) IS BEGIN
UPDATE
    Comerciantes
SET
    Nombre = Nombre,
    Departamento = Departamento,
    Municipio = Municipio,
    Telefono = Telefono,
    CorreoElectronico = CorreoElectronico,
    Estado = Estado
WHERE
    ComercianteID = ComercianteID;

END;

PROCEDURE EliminarComerciante (ComercianteID IN NUMBER) IS BEGIN
DELETE FROM
    Comerciantes
WHERE
    ComercianteID = ComercianteID;

END;

END pkg_Comerciantes;

/