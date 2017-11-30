
CREATE DATABASE NOMINA

GO

USE [NOMINA]

GO

CREATE TABLE NOMINA(
	Id int identity(1,1) Primary key
	,Cuenta varchar(25) not null
	,Descripcion varchar(25)
)


CREATE TABLE EMPLEADO(
	Id int identity(1,1) primary key
	,Cedula varchar(11) not null
	,Nombre varchar(50) not null
	,Departamento varchar(50) null
	,Puesto varchar(50) null
	,Salario float not null
	,Cuenta varchar(25) not null
	,Id_Nomina int not null
)
ALTER TABLE EMPLEADO ADD CONSTRAINT Nomina_Id_Nomina FOREIGN KEY (Id_Nomina) REFERENCES NOMINA (Id)



/*
CREATE TABLE TIPO_TRANSACCION
(
	Id int IDENTITY(1,1) PRIMARY KEY
	,Nombre varchar(50) not null
)


INSERT INTO TIPO_TRANSACCION (Nombre) VALUES
	('INGRESO'),
	('DEDUCCION')
*/


CREATE TABLE TIPO_INGRESO
(
	Id int identity(1,1)  PRIMARY KEY
	,Nombre varchar(50) not null
	,Depende_Salario varchar(5) not null --SI/NO
	,Estado varchar(15) not null --ACTIVO/INACTIVO
)


CREATE TABLE TIPO_DEDUCCION
(
	Id int identity(1,1) PRIMARY KEY
	,Nombre varchar(50) not null
	,Depende_Salario varchar(5) not null --SI/NO
	,Estado varchar(15) not null --ACTIVO/INACTIVO
)


CREATE TABLE TRANSACCION
(
	Id int IDENTITY(1,1) PRIMARY KEY
	,Tipo_Transaccion varchar(50) NOT NULL
	,Nombre_Tipo_Transaccion varchar(50) NOT NULL
	,Id_Empleado int NOT NULL
	,Fecha date NOT NULL
	,Monto float NOT NULL
	,Estado varchar(15) NOT NULL
)
ALTER TABLE TRANSACCION ADD 
CONSTRAINT Transaccion_Id_Empleado FOREIGN KEY (Id_Empleado) REFERENCES Empleado(Id)

CREATE TABLE ASIENTO_CONTABLE
(
	Id int IDENTITY(1,1) PRIMARY KEY
	,Descripcion varchar(250) NOT NULL
	,Id_Empleado int NOT NULL
	,Cuenta varchar(50)
	,Tipo_Movimiento varchar(15)
	,Fecha date NOT NULL
	,Monto float NOT NULL
	,Estado varchar(15) NOT NULL
)
ALTER TABLE ASIENTO_CONTABLE ADD 
CONSTRAINT Asiento_Contable_Id_Empleado FOREIGN KEY (Id_Empleado) REFERENCES Empleado(Id)


