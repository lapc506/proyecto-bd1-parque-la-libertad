CREATE OR REPLACE PROCEDURE insert_persona(nombre VARCHAR2,apellido1 VARCHAR2,apellido2 VARCHAR2,idDistrito NUMBER,idNacionalidad NUMBER,
direccion VARCHAR2) AS
BEGIN
INSERT INTO PERSONA(id,nombre,primerapellido,segundoapellido,iddistrito,idNacionalidaddireccionexacta)
VALUES(S_PERSONA.NEXTVAL,nombre,apellido1,apellido2,idDistrito,idnacionalidad,direccion);
END;