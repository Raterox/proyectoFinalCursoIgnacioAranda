DROP DATABASE trabajofinalprogramacion;
CREATE DATABASE trabajofinalprogramacion;
USE trabajofinalprogramacion;

CREATE TABLE empleado(
    nombre VARCHAR(30),
    apellido VARCHAR(30),
    sueldo NUMERIC(6,2),
    contrasena VARCHAR(20) NOT NULL
);
ALTER TABLE empleado ADD CONSTRAINT pk_empleado PRIMARY KEY (nombre,apellido);

CREATE TABLE alergeno(
	nombre VARCHAR(20) PRIMARY KEY,
    simbolo VARCHAR(1)
);

CREATE TABLE principal(
    id NUMERIC(2) PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    precio NUMERIC(4,2)    
);

CREATE TABLE entrante(
    id NUMERIC(2) PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    precio NUMERIC(4,2)    
);

CREATE TABLE postre(
    id NUMERIC(2) PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    precio NUMERIC(4,2)    
);

CREATE TABLE bebida(
    id NUMERIC(2) PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    precio NUMERIC(4,2),
    alcoholica BOOLEAN NOT NULL
);

CREATE TABLE principal_alergeno(
    nombre_principal VARCHAR(20),
    nombre_alergeno VARCHAR(20)
);

CREATE TABLE entrante_alergeno(
    nombre_entrante VARCHAR(20),
    nombre_alergeno VARCHAR(20)
);

CREATE TABLE postre_alergeno(
    nombre_postre VARCHAR(20),
    nombre_alergeno VARCHAR(20)
);

CREATE TABLE bebida_alergeno(
    nombre_bebida VARCHAR(20),
    nombre_alergeno VARCHAR(20)
);

CREATE TABLE linea_de_pedido(
    id NUMERIC(2) PRIMARY KEY AUTO_INCREMENT,
    cantidad NUMERIC(2)
);

ALTER TABLE linea_de_pedido
	ADD CONSTRAINT fk_linea_de_pedido_principal
	FOREIGN KEY (id)
	REFERENCES principal(id);
    
ALTER TABLE linea_de_pedido
	ADD CONSTRAINT fk_linea_de_pedido_entrante
	FOREIGN KEY (id)
	REFERENCES entrante(id);

ALTER TABLE linea_de_pedido
	ADD CONSTRAINT fk_linea_de_pedido_postre
	FOREIGN KEY (id)
	REFERENCES postre(id);

ALTER TABLE linea_de_pedido
	ADD CONSTRAINT fk_linea_de_pedido_bebida
	FOREIGN KEY (id)
	REFERENCES bebida(id);

CREATE TABLE mesa(
    numero NUMERIC(2)
);

CREATE TABLE mesa_linea_de_pedido(
    numero NUMERIC(2),
    id NUMERIC(2)
);
