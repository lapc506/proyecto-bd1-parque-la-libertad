CREATE OR REPLACE PROCEDURE insert_tipo_actividad(descripcion VARCHAR2) AS
BEGIN
INSERT INTO TIPOACTIVIDAD(id,descripcion)
VALUES(S_TIPOACTIVIDAD.NEXTVAL,descripcion);
END;