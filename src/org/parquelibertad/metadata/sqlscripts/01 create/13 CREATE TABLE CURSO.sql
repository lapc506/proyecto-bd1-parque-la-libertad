CREATE TABLE Curso(id NUMBER(10), nombre VARCHAR2(50), costo NUMBER(6),
  idHorarioSemanal NUMBER(3), idHoraInicio NUMBER(5), idHoraFinal NUMBER(5),
  idMercadoMeta NUMBER(5), isActivo NUMBER(1)
);

ALTER TABLE CURSO ADD
  CONSTRAINT pk_Curso PRIMARY KEY (id)
  USING INDEX TABLESPACE libertad_Indexes;
  
ALTER TABLE CURSO ADD
  CONSTRAINT fk_Curso_Horario FOREIGN KEY (idHorarioSemanal)
  REFERENCES HORARIOSEMANAL(id);
  
ALTER TABLE CURSO ADD
  CONSTRAINT fk_Curso_HoraInicio FOREIGN KEY (idHoraInicio)
  REFERENCES TRANSCURSODIA(id);
  
ALTER TABLE CURSO ADD
  CONSTRAINT fk_Curso_HoraFinal FOREIGN KEY (idHoraFinal)
  REFERENCES TRANSCURSODIA(id);
  
ALTER TABLE CURSO ADD
  CONSTRAINT fk_Curso_MercadoMeta FOREIGN KEY (idMercadoMeta)
  REFERENCES RANGOEDAD(id);

CREATE TABLE ProfesoresXCurso(idProfesor NUMBER(10), idCurso NUMBER(10));

ALTER TABLE ProfesoresXCurso ADD
  CONSTRAINT pk_ProfesoresXCurso PRIMARY KEY (idProfesor, idCurso)
  USING INDEX TABLESPACE libertad_Indexes;
  
ALTER TABLE ProfesoresXCurso ADD
  CONSTRAINT fk_ProfesoresXCurso_prf FOREIGN KEY (idProfesor)
  REFERENCES Empleado(id);
  
ALTER TABLE ProfesoresXCurso ADD
  CONSTRAINT fk_ProfesoresXCurso_cur FOREIGN KEY (idCurso)
  REFERENCES Curso(id);

