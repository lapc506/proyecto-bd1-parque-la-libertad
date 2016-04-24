CREATE TABLE VISITACURSO
(ID NUMBER,IDCURSO NUMBER,IDPERSONA NUMBER,FECHA DATE);

ALTER TABLE VISITACURSO
    ADD CONSTRAINT pk_VisitaCurso PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;
    
ALTER TABLE VISITACURSO
  ADD CONSTRAINT fk_VisitaCurso_Curso FOREIGN KEY (idCurso)
    REFERENCES Curso(id);
    
ALTER TABLE VISITACURSO
  ADD CONSTRAINT fk_VisitaCurso_Persona FOREIGN KEY (idPersona)
    REFERENCES Persona(id);