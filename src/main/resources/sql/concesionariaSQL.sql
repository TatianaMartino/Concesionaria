create database concesionaria;
use concesionaria;

create table sucursal(
id int auto_increment primary key,
direccion varchar(50),
codigo_postal int,
encargado_id int
);

create table encargado(
id int auto_increment primary key,
nombre varchar (25),
apellido varchar (25),
usuario varchar (25),
contrasena varchar (25),
id_sucursal int,
correo varchar(25),
FOREIGN KEY (id_sucursal) REFERENCES sucursal(id)
);

create table autos(
id int auto_increment primary key,
modelo varchar(25),
marca varchar(25),
descripcion varchar(25),
stock int,
precio int,
sucursal_id int ,
disponibilidad varchar(25),
FOREIGN KEY (sucursal_id) REFERENCES sucursal(id)
);

INSERT INTO sucursal (direccion, codigo_postal, encargado_id) VALUES ('Av. Rivadavia 6425', 1406, NULL);

INSERT INTO encargado (nombre, apellido, usuario, contrasena, id_sucursal, correo) VALUES ('Juan', 'Pérez', 'jnperez', '1234', 1, 'juan@mail.com');

UPDATE sucursal SET encargado_id = 1 WHERE id = 1;

INSERT INTO sucursal (direccion, codigo_postal, encargado_id) VALUES ('Güemes 4791 Cdad. Autónoma de Buenos Aires', 1425, NULL);

INSERT INTO encargado (nombre, apellido, usuario, contrasena, id_sucursal, correo) VALUES ('Marcos', 'Rodriguez', 'MarcosRodriguez', 'ghtd12', 2, 'rodriguezMarc@gmail.com');

UPDATE sucursal SET encargado_id = 2 WHERE id = 2;

CREATE TABLE cliente (
  id int(11) NOT NULL,
  nombre varchar(50) DEFAULT NULL,
  apellido varchar(50) DEFAULT NULL,
  correo varchar(100) DEFAULT NULL,
  dni varchar(20) DEFAULT NULL,
  codigo_postal varchar(20) DEFAULT NULL,
  dato_tarjeta varchar(20) DEFAULT NULL,
  telefono varchar(20) DEFAULT NULL
);

CREATE TABLE `reserva` (
  `id` int(11) NOT NULL,
  `idAuto` int(11) NOT NULL,
  `cliente` int(11) NOT NULL,
  `monto` int(100) NOT NULL,
  `situacion` varchar(500) NOT NULL
);
--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
