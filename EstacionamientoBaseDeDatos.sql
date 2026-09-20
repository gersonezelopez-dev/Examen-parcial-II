CREATE TABLE vehiculo (
    id SERIAL PRIMARY KEY,
    placa VARCHAR(15) NOT NULL UNIQUE,
    propietario VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    hora_ingreso TIME NOT NULL,
    horas_utilizadas NUMERIC(5,2) NOT NULL,
    costo NUMERIC(10,2) NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,

    CONSTRAINT ck_vehiculo_horas
        CHECK (horas_utilizadas > 0),

    CONSTRAINT ck_vehiculo_costo
        CHECK (costo >= 0),

    CONSTRAINT ck_vehiculo_tipo
        CHECK (tipo IN ('Automovil', 'Motocicleta'))
);

//registros 

INSERT INTO vehiculo
(placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo)
VALUES
('P123ABC', 'Carlos Lopez', 'Automovil', '08:00', 4, 40.00),

('M456DEF', 'Ana Perez', 'Motocicleta', '09:00', 6, 32.40),

('P789GHI', 'Luis Ramirez', 'Automovil', '10:30', 7, 63.00),

('M321JKL', 'Maria Garcia', 'Motocicleta', '11:00', 3, 18.00),

('P654MNO', 'Pedro Morales', 'Automovil', '12:15', 2, 20.00),

('M987PQR', 'Sofia Hernandez', 'Motocicleta', '13:30', 8, 43.20);

SELECT
    id,
    placa,
    propietario,
    tipo,
    hora_ingreso,
    horas_utilizadas,
    costo,
    activo
FROM vehiculo;

//Consulta de vehiculos registrados automovil y motocicleta

SELECT
    id,
    placa,
    propietario,
    tipo,
    horas_utilizadas,
    costo
FROM vehiculo
WHERE tipo = 'Automovil';

SELECT
    id,
    placa,
    propietario,
    tipo,
    horas_utilizadas,
    costo
FROM vehiculo
WHERE tipo = 'Motocicleta';

//vehiculos costo superior.

SELECT
    placa,
    propietario,
    tipo,
    costo
FROM vehiculo
WHERE costo > 30;

//Costo mayor a menor

SELECT
    placa,
    propietario,
    tipo,
    horas_utilizadas,
    costo
FROM vehiculo
ORDER BY costo DESC;

//Modificar registros 

UPDATE vehiculo
SET propietario = 'Pedro Morales Garcia'
WHERE placa = 'P654MNO';

SELECT
    placa,
    propietario
FROM vehiculo
WHERE placa = 'P654MNO';

//Cambio de un estado de vehiculo

UPDATE vehiculo
SET activo = FALSE
WHERE placa = 'M321JKL';

SELECT
    placa,
    propietario,
    activo
FROM vehiculo
WHERE placa = 'M321JKL';

//Se hace registro de un delete para prueba // recordatorio usar where si no borro todos los registros

DELETE FROM vehiculo
WHERE placa = 'M987PQR';

SELECT
    id,
    placa,
    propietario,
    tipo
FROM vehiculo;

//Provocar error placa duplicada

INSERT INTO vehiculo
(placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo)
VALUES
('P123ABC', 'Juan Martinez', 'Automovil', '15:00', 2, 20.00);

//Provocar error de registro de horas invalidas

INSERT INTO vehiculo
(placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo)
VALUES
('P111XYZ', 'Roberto Diaz', 'Automovil', '16:00', 0, 20.00);