CREATE OR REPLACE PROCEDURE insert_persona
(p_nombre VARCHAR2, p_apellido1 VARCHAR2, p_apellido2 VARCHAR2, p_idDistrito NUMBER, direccion VARCHAR2)
AS
BEGIN
INSERT INTO PERSONA(id,nombre,primerapellido,segundoapellido,iddistrito,direccionexacta)
VALUES(S_PERSONA.NEXTVAL,nombre,apellido1,apellido2,idDistrito,direccion);
END;