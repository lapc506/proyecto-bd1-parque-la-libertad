CREATE TABLE Actividad(
  id NUMBER(20),
  descripcion VARCHAR2(30) CONSTRAINT actividad_descripcion_nn NOT NULL,
  isActiva NUMBER(1)
    CONSTRAINT check_isActiva CHECK (isActiva BETWEEN 0 and 1),
  idTipo NUMBER(3)
);

CREATE TABLE TipoActividad(
  id NUMBER(3),
  descripcion VARCHAR2(30)
);

ALTER TABLE Actividad
  ADD CONSTRAINT pk_Actividad PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;

ALTER TABLE TipoActividad
  ADD CONSTRAINT pk_TipoActividad PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;

ALTER TABLE Actividad
  ADD CONSTRAINT fk_actividad_tipo FOREIGN KEY (idTipo)
    REFERENCES TipoActividad(id);
