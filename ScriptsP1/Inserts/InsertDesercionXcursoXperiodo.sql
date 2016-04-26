CREATE OR REPLACE PROCEDURE insert_desercionXcursoXperiodo(idCursoXPeriodo NUMBER,idAlumno NUMBER,Motivo VARCHAR2) AS
BEGIN
INSERT INTO desercionXcursoXperiodo(id, idcursoxperiodo, idalumno,motivo)
VALUES(s_desercionXcursoXperiodo.NEXTVAL, idCursoXPeriodo, idAlumno,Motivo);
END;