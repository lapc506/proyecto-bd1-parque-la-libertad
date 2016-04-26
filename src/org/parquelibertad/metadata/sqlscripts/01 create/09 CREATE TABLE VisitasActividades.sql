CREATE TABLE VisitasActividades(
  id NUMBER(30),
  idPersona NUMBER(10),
  idActividad NUMBER(20),
  fechaHora DATE
    DEFAULT SYSDATE CONSTRAINT visita_actividad_fecha_nn NOT NULL
);

ALTER TABLE VisitasActividades
  ADD CONSTRAINT pk_VisitasActividades PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;

ALTER TABLE VisitasActividades
  ADD CONSTRAINT fk_persona_VA FOREIGN KEY (idPersona)
    REFERENCES Persona(id);

ALTER TABLE VisitasActividades
  ADD CONSTRAINT fk_actividad_VA FOREIGN KEY (idActividad)
    REFERENCES Actividad(id);
