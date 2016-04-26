ALTER TABLE CURSO
    ADD CONSTRAINT pk_Curso PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;

ALTER TABLE Periodo
    ADD CONSTRAINT pk_Periodo PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;
    
ALTER TABLE EventoXPersona
    ADD CONSTRAINT pk_EventoXPersona PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;
    
ALTER TABLE EventoXPersona
  ADD CONSTRAINT fk_EventoXPersona_Evento FOREIGN KEY (idEvento)
    REFERENCES Evento(id);
    
ALTER TABLE EventoXPersona
  ADD CONSTRAINT fk_EventoXPersona_Persona FOREIGN KEY (idPersona)
    REFERENCES Persona(id);
    
ALTER TABLE Empleado
    ADD CONSTRAINT pk_Empleado PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;
ALTER TABLE Alumno
    ADD CONSTRAINT pk_Alumno PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;
    
ALTER TABLE Alumno
  ADD CONSTRAINT fk_alumno_persona FOREIGN KEY (idPersona)
    REFERENCES Persona(id);
    
ALTER TABLE Empleado
  ADD CONSTRAINT fk_empleado_persona FOREIGN KEY (idPersona)
    REFERENCES Persona(id);
