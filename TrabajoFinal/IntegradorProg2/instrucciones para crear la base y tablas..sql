CREATE DATABASE IF NOT EXISTS hospital;
use hospital;
-- creacion de tabla de Paciente 
CREATE TABLE paciente (
    id INT NOT NULL AUTO_INCREMENT,
    eliminado BOOLEAN DEFAULT FALSE,
    nombre VARCHAR(80) NOT NULL,
    apellido VARCHAR(80) NOT NULL,
    dni VARCHAR(15) NOT NULL UNIQUE,
    fecha_nacimiento DATE,
    PRIMARY KEY (id)
);
-- creacion de tabla Historia clinica
CREATE TABLE historia_clinica (
    id INT NOT NULL AUTO_INCREMENT,
    eliminado BOOLEAN DEFAULT FALSE,
    nro_historia VARCHAR(20) UNIQUE,
    grupo_sanguineo ENUM('A+', 'A-', 'B+', 'B-', 'AB+', 'AB-', 'O+', 'O-'),
    antecedentes TEXT,
    medicacion_actual TEXT,
    observaciones TEXT,
    paciente_id INT UNIQUE,  
    PRIMARY KEY (id),
    CONSTRAINT fk_historia_paciente
        FOREIGN KEY (paciente_id)
        REFERENCES paciente(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);