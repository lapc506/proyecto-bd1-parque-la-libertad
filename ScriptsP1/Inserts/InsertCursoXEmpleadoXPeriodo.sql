CREATE OR REPLACE PROCEDURE insert_cursoXEmpleadoXPeriodo(idCursoXEmpleado NUMBER,idCursoXPeriodo NUMBER) AS
BEGIN
INSERT INTO cursoXEmpleadoXPeriodo(id, idcursoxempleado, idcursoxperiodo)
VALUES(S_cursoXEmpleadoXPeriodo.NEXTVAL, idCursoxEmpleado, idCursoXPeriodo);
END;