create or replace
TRIGGER audi_insert_DocumentoIdentidad
BEFORE INSERT
ON DocumentoIdentidad
BEGIN 
INSERT INTO DocumentoIdentidad(FEC_CREACION,USUARIO_CREACION)
VALUES(SYSDATE, 'myAdmin');
END;
