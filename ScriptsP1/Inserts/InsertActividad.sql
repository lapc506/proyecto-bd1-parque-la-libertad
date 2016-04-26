CREATE OR REPLACE PROCEDURE insert_actividad(descripcion VARCHAR2,idTipo NUMBER) AS
BEGIN
INSERT INTO ACTIVIDAD(id,descripcion,isActiva,idTipo)
VALUES(S_Actividad.NEXTVAL,descripcion,1,idTipo);
END;