CREATE TABLE Persona(
  id NUMBER(10),
  nombre VARCHAR2(30) CONSTRAINT persona_nombre_nn NOT NULL,
  primerApellido VARCHAR2(30) CONSTRAINT persona_primerApellido_nn NOT NULL,
  segundoApellido VARCHAR2(30) CONSTRAINT persona_segundoApellido_nn NOT NULL,
  --idNacionalidad NUMBER(6) CONSTRAINT persona_nacionalidad_nn NOT NULL,
  idDistrito NUMBER(10) CONSTRAINT persona_distrito_id_nn NOT NULL,
  direccionExacta VARCHAR2(250),
  fechaRegistro DATE
    DEFAULT SYSDATE CONSTRAINT persona_fechaRegistro_nn NOT NULL
);
--====================================================================
ALTER TABLE Persona
    ADD CONSTRAINT pk_Persona PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;
