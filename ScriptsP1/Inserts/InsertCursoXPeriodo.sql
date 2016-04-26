CREATE OR REPLACE PROCEDURE insert_cursoXperiodo(idCurso NUMBER,idPeriodo NUMBER) AS
BEGIN
INSERT INTO cursoXperiodo(id, idcurso, idperiodo)
VALUES(S_cursoXperiodo.NEXTVAL, idCurso, idPeriodo);
END;