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
    id_principal NUMERIC(2) PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    precio NUMERIC(4,2)    
);

CREATE TABLE entrante(
    id_entrante NUMERIC(2) PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    precio NUMERIC(4,2)    
);

CREATE TABLE postre(
    id_postre NUMERIC(2) PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    precio NUMERIC(4,2)    
);

CREATE TABLE bebida(
    id_bebida NUMERIC(2) PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    precio NUMERIC(4,2),
    alcoholica BOOLEAN NOT NULL
);

CREATE TABLE principal_alergeno(
    id_principal NUMERIC(2),
    nombre_alergeno VARCHAR(20)
);

CREATE TABLE entrante_alergeno(
    id_entrante NUMERIC(2),
    nombre_alergeno VARCHAR(20)
);

CREATE TABLE postre_alergeno(
    id_postre NUMERIC(2),
    nombre_alergeno VARCHAR(20)
);

CREATE TABLE bebida_alergeno(
    id_bebida NUMERIC(2),
    nombre_alergeno VARCHAR(20)
);

CREATE TABLE linea_de_pedido(
    id_linea_de_pedido NUMERIC(2) PRIMARY KEY,
    cantidad NUMERIC(2)
);

ALTER TABLE linea_de_pedido
	ADD CONSTRAINT fk_linea_de_pedido_principal
	FOREIGN KEY (id_linea_de_pedido)
	REFERENCES principal(id_principal);
    
ALTER TABLE linea_de_pedido
	ADD CONSTRAINT fk_linea_de_pedido_entrante
	FOREIGN KEY (id_linea_de_pedido)
	REFERENCES entrante(id_entrante);

ALTER TABLE linea_de_pedido
	ADD CONSTRAINT fk_linea_de_pedido_postre
	FOREIGN KEY (id_linea_de_pedido)
	REFERENCES postre(id_postre);

ALTER TABLE linea_de_pedido
	ADD CONSTRAINT fk_linea_de_pedido_bebida
	FOREIGN KEY (id_linea_de_pedido)
	REFERENCES bebida(id_bebida);

CREATE TABLE mesa(
    id_mesa NUMERIC(2) PRIMARY KEY,
    numero_mesa NUMERIC(2)
);

CREATE TABLE mesa_linea_de_pedido(
    id_mesa NUMERIC(2),
    id_linea_de_pedido NUMERIC(2)
);

CREATE TABLE zona(
    nombre_zona VARCHAR(20) PRIMARY KEY
);

CREATE TABLE mesa_zona(
    id_mesa NUMERIC(2),
    nombre_zona VARCHAR(20)
);

