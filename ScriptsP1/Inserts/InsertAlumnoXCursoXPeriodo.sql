CREATE OR REPLACE PROCEDURE insert_alumnoxcursoxperiodo(idcursoXperiodo NUMBER,idAlumno NUMBER) AS
BEGIN
INSERT INTO ALUMNOXCURSOXPERIODO(id, idcursoxperiodo, idalumno)
VALUES(S_ALUMNOXCURSOXPERIODO.NEXTVAL, idcursoxperiodo, idalumno);
END;