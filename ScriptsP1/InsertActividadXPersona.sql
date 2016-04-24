CREATE OR REPLACE PROCEDURE insert_actividadXpersona(idActividad NUMBER,idPersona NUMBER) AS
BEGIN
INSERT INTO ACTIVIDADXPERSONA(id, idactividad, idpersona)
VALUES(S_ACTIVIDADXPERSONA.NEXTVAL, idactividad, idpersona);
END;