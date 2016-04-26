CREATE TABLE Pais(
  id NUMBER(4),
  descripcion VARCHAR2(30)
    CONSTRAINT pais_descripcion_nn NOT NULL
);
CREATE TABLE Provincia(
  id NUMBER(6),
  idPais NUMBER(5),
  descripcion VARCHAR2(30)
    CONSTRAINT provincia_descripcion_nn NOT NULL
);
CREATE TABLE Canton(
  id NUMBER(8),
  idProvincia NUMBER(5),
  descripcion VARCHAR2(30)
    CONSTRAINT canton_descripcion_nn NOT NULL
);
CREATE TABLE Distrito(
  id NUMBER(10),
  idCanton NUMBER(5),
  descripcion VARCHAR2(30)
    CONSTRAINT distrito_descripcion_nn NOT NULL
);
--====================================================================
ALTER TABLE Pais
  ADD CONSTRAINT pk_id_pais PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;
--====================================================================
ALTER TABLE Provincia
  ADD CONSTRAINT pk_id_provincia PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;

ALTER TABLE Provincia
  ADD CONSTRAINT fk_provincia_pais FOREIGN KEY (idPais)
    REFERENCES Pais(id);
--====================================================================
ALTER TABLE Canton
  ADD CONSTRAINT pk_id_canton PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;

ALTER TABLE Canton
  ADD CONSTRAINT fk_canton_provincia FOREIGN KEY (idProvincia)
    REFERENCES Provincia(id);
--====================================================================
ALTER TABLE Distrito
  ADD CONSTRAINT pk_id_distrito PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;

ALTER TABLE Distrito
  ADD CONSTRAINT fk_distrito_canton FOREIGN KEY (idCanton)
    REFERENCES Canton(id);

ALTER TABLE Persona
  ADD CONSTRAINT fk_persona_vive_distrito FOREIGN KEY (idDistrito)
    REFERENCES Distrito(id);
