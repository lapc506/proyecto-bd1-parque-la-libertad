CREATE OR REPLACE PROCEDURE insert_curso(nombre VARCHAR2,costo NUMBER,idRangoEdad NUMBER) AS
BEGIN
INSERT INTO CURSO(id,nombre,costo,estaActivo, id_mercado_meta)
VALUES(S_CURSO.NEXTVAL,nombre,costo,1,idRangoEdad);
END;