create or replace
TRIGGER auditoria_insert_distrito
BEFORE INSERT
ON distrito
BEGIN 
INSERT INTO distrito(FEC_CREACION,USUARIO_CREACION)
VALUES(SYSDATE, 'myAdmin');
END;
