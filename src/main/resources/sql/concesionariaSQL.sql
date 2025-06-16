create database concesionaria;
use concesionaria;

create table sucursal(
id int auto_increment primary key,
direccion varchar(50),
codigo_postal int,
vendedor_id int
);

create table vendedor(
id int auto_increment primary key,
nombre varchar (25),
apellido varchar (25),
usuario varchar (25),
password varchar (25),
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
stockBase int,
FOREIGN KEY (sucursal_id) REFERENCES sucursal(id)
);

INSERT INTO sucursal (direccion, codigo_postal, vendedor_id) VALUES ('Av. Rivadavia 6425', 1406, NULL);

INSERT INTO vendedor (nombre, apellido, usuario, password, id_sucursal, correo) VALUES ('Juan', 'Pérez', 'jnperez', '1234', 1, 'juan@mail.com');

UPDATE sucursal SET vendedor_id = 1 WHERE id = 1;

INSERT INTO sucursal (direccion, codigo_postal, vendedor_id) VALUES ('Güemes 4791 Cdad. Autónoma de Buenos Aires', 1425, NULL);

INSERT INTO vendedor (nombre, apellido, usuario, password, id_sucursal, correo) VALUES ('Marcos', 'Rodriguez', 'MarcosRodriguez', 'ghtd12', 2, 'rodriguezMarc@gmail.com');

UPDATE sucursal SET vendedor_id = 2 WHERE id = 2;


INSERT INTO autos (modelo, marca, descripcion, stock, precio, sucursal_id, disponibilidad, stockBase) VALUES
('Model S', 'Tesla', 'Sedán eléctrico', 1, 80000, 1, 'Disponible', 1),
('Civic', 'Honda', 'Sedán compacto', 1, 25000, 1, 'Disponible', 1),
('Mustang', 'Ford', 'Coupé deportivo', 1, 55000, 2, 'Disponible', 1),
('Corolla', 'Toyota', 'Sedán mediano', 1, 22000, 2, 'Disponible', 1),
('3 Series', 'BMW', 'Sedán de lujo', 1, 45000, 1, 'Disponible', 1);


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

 CREATE TABLE `solicitud_traslado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auto_id` int(11) NOT NULL,
  `sucursalOrigen_id` int(11) NOT NULL,
  `sucursalDestino_id` int(11) NOT NULL,
  `estado` enum('PENDIENTE','APROBADO','RECHAZADO') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `auto_id` (`auto_id`),
  KEY `sucursalOrigen_id` (`sucursalOrigen_id`),
  KEY `sucursalDestino_id` (`sucursalDestino_id`),
  CONSTRAINT `solicitud_traslado_ibfk_1` FOREIGN KEY (`auto_id`) REFERENCES `autos` (`id`),
  CONSTRAINT `solicitud_traslado_ibfk_2` FOREIGN KEY (`sucursalOrigen_id`) REFERENCES `sucursal` (`id`),
  CONSTRAINT `solicitud_traslado_ibfk_3` FOREIGN KEY (`sucursalDestino_id`) REFERENCES `sucursal` (`id`)
)