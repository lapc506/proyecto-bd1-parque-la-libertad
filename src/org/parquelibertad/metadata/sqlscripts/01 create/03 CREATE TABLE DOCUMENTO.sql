CREATE TABLE DocumentoIdentidad(
  id NUMBER(10),
  numeroIdentidad NUMBER(10),
  idPersona NUMBER(10),
  idRangoEdad NUMBER(5),
  idTipo NUMBER(5) 
);
CREATE TABLE RangoEdad(
  id NUMBER(5),
  valorMin NUMBER(2)
    CONSTRAINT rangoEdad_minimo_nn NOT NULL,
  valorMax NUMBER(2)
    CONSTRAINT rangoEdad_maximo_nn NOT NULL
);
CREATE TABLE TipoDocumentoIdentidad(
  id NUMBER(5),
  descripcion VARCHAR2(30)
);
--====================================================================
ALTER TABLE DocumentoIdentidad
  ADD CONSTRAINT pk_id_documento_identidad PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;

ALTER TABLE DocumentoIdentidad
  ADD CONSTRAINT fk_documento_persona FOREIGN KEY (idPersona)
    REFERENCES Persona(id);

ALTER TABLE TipoDocumentoIdentidad
  ADD CONSTRAINT pk_id_tipo_documento PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;

ALTER TABLE DocumentoIdentidad
  ADD CONSTRAINT fk_documento_tipo FOREIGN KEY (idTipo)
    REFERENCES TipoDocumentoIdentidad(id);

ALTER TABLE RangoEdad
  ADD CONSTRAINT pk_id_rango_edad PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;

ALTER TABLE DocumentoIdentidad
  ADD CONSTRAINT fk_documento_edad FOREIGN KEY (idRangoEdad)
    REFERENCES RangoEdad(id);
