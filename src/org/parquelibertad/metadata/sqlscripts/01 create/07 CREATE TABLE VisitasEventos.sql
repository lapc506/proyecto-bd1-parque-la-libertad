CREATE TABLE VisitasEventos( --EventoXPersona
  id NUMBER(30),
  idPersona NUMBER(10),
  idEvento NUMBER(20)
);

ALTER TABLE VisitasEventos
  ADD CONSTRAINT pk_VisitasEventos PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;

ALTER TABLE VisitasEventos
  ADD CONSTRAINT fk_persona_VE FOREIGN KEY (idPersona)
    REFERENCES Persona(id);

ALTER TABLE VisitasEventos
  ADD CONSTRAINT fk_evento_VE FOREIGN KEY (idEvento)
    REFERENCES Evento(id);
