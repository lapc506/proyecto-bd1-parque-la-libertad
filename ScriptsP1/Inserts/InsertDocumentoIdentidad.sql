CREATE OR REPLACE PROCEDURE insert_DocumentoIdentidad(numeroIdentidad NUMBER, idPersona NUMBER, idTipo NUMBER) AS
BEGIN
INSERT INTO DocumentoIdentidad(id, numeroidentidad, idpersona,idtipo)
VALUES(s_DocumentoIdentidad.NEXTVAL, numeroIdentidad, idpersona,idTipo);
END;