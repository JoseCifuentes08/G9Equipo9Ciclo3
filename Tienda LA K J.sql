CREATE DATABASE tienda_LA_KJ;

USE tienda_LA_KJ;

#modulo de login y usuario#
CREATE TABLE usuarios (
cedula_usuario BIGINT PRIMARY KEY,
email_usuario VARCHAR(255) NOT NULL,
nombre_usuario VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
usuario VARCHAR(255) NOT NULL
);

CREATE TABLE clientes (
cedula_cliente BIGINT PRIMARY KEY,
email_cliente VARCHAR(255) NOT NULL,
nombre_cliente VARCHAR(255) NOT NULL,
telefono_cliente VARCHAR(255) NOT NULL,
direccion_cliente VARCHAR(255) NOT NULL
);

CREATE TABLE proveedores (
nit_proveedor BIGINT PRIMARY KEY,
nombre_proveedor VARCHAR(255) NOT NULL,
direccion_proveedor VARCHAR(255) NOT NULL,
telefono_proveedor VARCHAR(255) NOT NULL,
ciudad_proveedor VARCHAR(255) NOT NULL
);

INSERT INTO usuarios VALUES(001,'kevinmanosalva@hotmail.es','Kevin Manosalva','admin123456','admininicial');
INSERT INTO usuarios VALUES(002,'kevindominaperras@gmail.com','Kevin Benitez','pass','user');
INSERT INTO usuarios VALUES(003,'kevindavid970325@gmail.com','David Manosalva','pass','user1');
INSERT INTO clientes VALUES(001,'hambuerguesas@gmail.com','luis plazas','3126544553','vaenida siempre viva');
INSERT INTO proveedores VALUES(001,'claro','bosa','312654455','bogota');


create unique index usuario_unico
on usuarios(usuario);
create unique index cliente_unico
on clientes(cedula_cliente);
create unique index proveedor_unico
on proveedores(nit_proveedor);