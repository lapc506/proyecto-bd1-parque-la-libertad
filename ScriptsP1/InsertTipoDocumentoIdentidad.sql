CREATE OR REPLACE PROCEDURE insert_TipoDocumentoIdentidad(DESCRIPCION VARCHAR2) AS
BEGIN
INSERT INTO TipoDocumentoIdentidad(id,descripcion)
VALUES(s_TipoDocumentoIdentidad.NEXTVAL,DESCRIPCION);
END;