CREATE OR REPLACE PROCEDURE insert_alumno(idPersona NUMBER) AS
BEGIN
INSERT INTO ALUMNO(id, idpersona)
VALUES(S_ALUMNO.NEXTVAL, idpersona);
END;