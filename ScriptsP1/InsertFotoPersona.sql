CREATE OR REPLACE PROCEDURE insert_FotoPersona(IDPERSONA NUMBER,CONTENIDO VARCHAR2) AS
BEGIN
INSERT INTO FotoPersona(id, idpersona, contenido)
VALUES(s_FotoPersona.NEXTVAL, IDPERSONA,CONTENIDO);
END;
