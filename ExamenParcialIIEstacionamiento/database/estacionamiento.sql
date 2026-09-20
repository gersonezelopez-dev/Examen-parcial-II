-- EXAMEN PARCIAL II
-- BASE DE DATOS: parcial2_estacionamiento
-- TABLA: vehiculo


-- 1. CREACIÓN DE LA TABLA

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


-- 2. REGISTRO DE VEHÍCULOS

INSERT INTO vehiculo
(placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo)
VALUES
    ('P123ABC', 'Carlos Lopez', 'Automovil', '08:00', 4, 40.00),
    ('M456DEF', 'Ana Perez', 'Motocicleta', '09:00', 6, 32.40),
    ('P789GHI', 'Luis Ramirez', 'Automovil', '10:30', 7, 63.00),
    ('M321JKL', 'Maria Garcia', 'Motocicleta', '11:00', 3, 18.00),
    ('P654MNO', 'Pedro Morales', 'Automovil', '12:15', 2, 20.00),
    ('M987PQR', 'Sofia Hernandez', 'Motocicleta', '13:30', 8, 43.20);


-- 3. CONSULTA GENERAL

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


-- 4. CONSULTA POR TIPO DE VEHÍCULO

SELECT
    id,
    placa,
    propietario,
    tipo,
    horas_utilizadas,
    costo
FROM vehiculo
WHERE tipo = 'Automovil';


-- 5. VEHÍCULOS CON COSTO MAYOR A Q30

SELECT
    placa,
    propietario,
    tipo,
    costo
FROM vehiculo
WHERE costo > 30;


-- 6. ORDENAR POR COSTO DE MAYOR A MENOR

SELECT
    placa,
    propietario,
    tipo,
    horas_utilizadas,
    costo
FROM vehiculo
ORDER BY costo DESC;


-- 7. ACTUALIZACIÓN DE UN REGISTRO

UPDATE vehiculo
SET propietario = 'Pedro Morales Garcia'
WHERE placa = 'P654MNO';


-- Comprobar actualización

SELECT
    placa,
    propietario
FROM vehiculo
WHERE placa = 'P654MNO';


-- 8. CAMBIO DE ESTADO

UPDATE vehiculo
SET activo = FALSE
WHERE placa = 'M321JKL';


-- Comprobar cambio de estado

SELECT
    placa,
    propietario,
    activo
FROM vehiculo
WHERE placa = 'M321JKL';


-- 9. ELIMINACIÓN DE UN REGISTRO

DELETE FROM vehiculo
WHERE placa = 'M987PQR';


-- 10. PRUEBA DE PLACA DUPLICADA
-- Esta consulta debe producir un error intencional.

INSERT INTO vehiculo
(placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo)
VALUES
    ('P123ABC', 'Juan Martinez', 'Automovil', '15:00', 2, 20.00);


-- 11. PRUEBA DE HORAS INVÁLIDAS
-- Esta consulta debe producir un error intencional.

INSERT INTO vehiculo
(placa, propietario, tipo, hora_ingreso, horas_utilizadas, costo)
VALUES
    ('P111XYZ', 'Roberto Diaz', 'Automovil', '16:00', 0, 20.00);