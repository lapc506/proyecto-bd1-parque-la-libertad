CREATE TABLE Nacionalidad(
  id NUMBER(4),
  idPais NUMBER(6),
  descripcion VARCHAR2(30)
    CONSTRAINT nacionalidad_descripcion_nn NOT NULL
);

ALTER TABLE Nacionalidad
  ADD CONSTRAINT pk_nacionalidad PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;

ALTER TABLE Nacionalidad
  ADD CONSTRAINT fk_nacionalidad_pais FOREIGN KEY (idPais)
    REFERENCES Pais(id);
--====================================================================
CREATE TABLE NacionalidadesXPersona(
  idNacionalidad NUMBER(4),
  idPersona NUMBER(10)
);

ALTER TABLE NacionalidadesXPersona
  ADD CONSTRAINT pk_NacionalidadesXPersona PRIMARY KEY (idNacionalidad, idPersona)
    USING INDEX TABLESPACE libertad_Indexes;

ALTER TABLE NacionalidadesXPersona
  ADD CONSTRAINT fk_nacionalidades_NXP FOREIGN KEY (idNacionalidad)
    REFERENCES Nacionalidad(id);

ALTER TABLE NacionalidadesXPersona
  ADD CONSTRAINT fk_personas_NXP FOREIGN KEY (idPersona)
    REFERENCES Persona(id);
