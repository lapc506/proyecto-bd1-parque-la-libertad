create or replace
TRIGGER audi_ins_cursoXEmpleadoXPeri
BEFORE INSERT
ON cursoXEmpleadoXPeriodo
BEGIN 
INSERT INTO cursoXEmpleadoXPeriodo(FEC_CREACION,USUARIO_CREACION)
VALUES(SYSDATE, 'myAdmin');
END;
