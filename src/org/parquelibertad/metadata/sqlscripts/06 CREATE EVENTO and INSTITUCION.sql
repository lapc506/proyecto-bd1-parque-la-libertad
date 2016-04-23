CREATE TABLE Evento(
  id NUMBER(20),
  descripcion VARCHAR2(30) CONSTRAINT evento_descripcion_nn NOT NULL,
  fechaHoraInicio DATE
    DEFAULT SYSDATE CONSTRAINT evento_fechaHoraInicio_nn NOT NULL,
  duracionHoras NUMBER(2),
    CONSTRAINT check_duracionHoras CHECK (duracionHoras >= 0),
  duracionMinutos NUMBER(2)
    CONSTRAINT check_duracionMinutos CHECK (duracionMinutos BETWEEN 0 and 59),
  cupoMaximo NUMBER(4),
  idTipoEvento NUMBER(3),
  idInstitucion NUMBER(3)
);

CREATE TABLE TipoEvento(
  id NUMBER(3),
  descripcion VARCHAR2(30)
);

CREATE TABLE Institucion(
  id NUMBER(3),
  nombre VARCHAR2(30),
  idDistrito NUMBER(5)
);

ALTER TABLE Institucion
  ADD CONSTRAINT pk_Institucion PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;

ALTER TABLE Institucion
  ADD CONSTRAINT fk_institucion_distrito FOREIGN KEY (idDistrito)
    REFERENCES Distrito(id);

ALTER TABLE Evento
  ADD CONSTRAINT pk_Evento PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;

ALTER TABLE TipoEvento
  ADD CONSTRAINT pk_TipoEvento PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;

ALTER TABLE Evento
  ADD CONSTRAINT fk_evento_tipos FOREIGN KEY (idTipoEvento)
    REFERENCES TipoEvento(id);

ALTER TABLE Evento
  ADD CONSTRAINT fk_evento_institucion FOREIGN KEY (idInstitucion)
    REFERENCES Institucion(id);
