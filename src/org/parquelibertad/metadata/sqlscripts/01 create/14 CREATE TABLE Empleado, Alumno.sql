CREATE TABLE TipoEmpleado(
	id NUMBER(3),
	descripcion VARCHAR2(30)
);

ALTER TABLE TipoEmpleado ADD
  CONSTRAINT pk_TipoEmpleado PRIMARY KEY (id)
  USING INDEX TABLESPACE libertad_Indexes;
  
ALTER TABLE TipoEmpleado ADD
  CONSTRAINT unq_descripcion UNIQUE (descripcion);

/*
SELECT * FROM Tipoempleado;
INSERT INTO TipoEmpleado VALUES (s_Tipoempleado.Nextval, 'Docente');
INSERT INTO TipoEmpleado VALUES (s_Tipoempleado.Nextval, 'Gerencia');
INSERT INTO TipoEmpleado VALUES (s_Tipoempleado.Nextval, 'Seguridad');
INSERT INTO TipoEmpleado VALUES (s_Tipoempleado.Nextval, 'Alimentos');
*/

CREATE TABLE Empleado(
  id NUMBER(10),
  idPersona NUMBER(10),
  idTipo NUMBER(3) NOT NULL
);

ALTER TABLE Empleado ADD
  CONSTRAINT pk_Empleado PRIMARY KEY (id)
  USING INDEX TABLESPACE libertad_Indexes;
  
ALTER TABLE Empleado ADD
  CONSTRAINT fk_Empleado_tipo
  FOREIGN KEY (idTipo) REFERENCES TipoEmpleado(id);
  
-- ALTER TABLE Empleado MODIFY idTipo NOT NULL;

CREATE TABLE CuentaUsuario(
  id NUMBER(10),
  usuario VARCHAR(20),
  contraseņa VARCHAR(20),
  idEmpleado NUMBER(10)
);

ALTER TABLE CuentaUsuario ADD
  CONSTRAINT pk_CuentaUsuario PRIMARY KEY (id)
  USING INDEX TABLESPACE libertad_Indexes;
  
 ALTER TABLE CuentaUsuario ADD
  CONSTRAINT fk_CuentaUsuario_empleado
  FOREIGN KEY (idEmpleado) REFERENCES Empleado(id);

CREATE TABLE Alumno(
  id NUMBER(10),
  idPersona NUMBER(10),
  anioMatricula NUMBER(4)
);

ALTER TABLE Alumno ADD
  CONSTRAINT pk_Alumno PRIMARY KEY (id)
  USING INDEX TABLESPACE libertad_Indexes;

ALTER TABLE Alumno
  ADD CONSTRAINT fk_alumno_persona FOREIGN KEY (idPersona)
    REFERENCES Persona(id);
    
ALTER TABLE Empleado
  ADD CONSTRAINT fk_empleado_persona FOREIGN KEY (idPersona)
    REFERENCES Persona(id);
