ALTER TABLE CursoXEmpleadoXPeriodo
  ADD CONSTRAINT pk_id_CurXEmpXPeri PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;

ALTER TABLE CursoXEmpleadoXPeriodo
  ADD CONSTRAINT fk_CurXEmpXPeri_CurXEmp FOREIGN KEY (idCursoXEmpleado)
    REFERENCES CursoXEmpleado(id);
    
ALTER TABLE CursoXEmpleadoXPeriodo
  ADD CONSTRAINT fk_CurXEmpXPeri_CurXPeri FOREIGN KEY (idCursoXPeriodo)
    REFERENCES CursoXPeriodo(id);