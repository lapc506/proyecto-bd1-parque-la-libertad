create or replace
TRIGGER auditoria_insert_curso
BEFORE INSERT
ON CURSO
BEGIN 
INSERT INTO CURSO(FEC_CREACION,USUARIO_CREACION)
VALUES(SYSDATE, 'myAdmin');
END;
