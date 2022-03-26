--Crear DB
create database apidb;

--Usar DB
use apidb;

--La tabla se crea una vez iniciado el servidor

--Datos de prueba
INSERT INTO apidb.user (id, apellido, email, nombre, sn_han) values
(1, "Perez", "frailejon@gmail.com", "Ernesto", 1),
(2, "Laguna", "claguna@gmail.com", "Cristian", 1),
(3, "Ariza", "hariza@gmail.com", "Haroll", 1),
(4, "Escobar", "jescobar@gmail.com", "Jonatha", 1),
(5, "Hernandez", "jhernandez@gmail.com", "Jensy", 1),
(6, "Gomez", "dgomez@gmail.com", "Daniela", 1);

--Validar datos
select * from user;