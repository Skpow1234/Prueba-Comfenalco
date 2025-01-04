-- Insertar datos en Comerciantes
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
        'Comerciante 1',
        'Departamento 1',
        'Municipio 1',
        '123456789',
        'correo1@example.com',
        'Activo'
    );

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
        'Comerciante 2',
        'Departamento 2',
        'Municipio 2',
        '987654321',
        'correo2@example.com',
        'Registrado'
    );

-- (Repetir con otros registros)
-- Insertar datos en Establecimientos
INSERT INTO
    Establecimientos (ComercianteID, Nombre, Ingresos, NumeroEmpleados)
VALUES
    (1, 'Establecimiento 1', 10000.50, 5);

INSERT INTO
    Establecimientos (ComercianteID, Nombre, Ingresos, NumeroEmpleados)
VALUES
    (2, 'Establecimiento 2', 15000.75, 10);

-- (Repetir con otros registros)