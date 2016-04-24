create or replace
TRIGGER auditoria_insert_cursoXperiodo
BEFORE INSERT
ON cursoXperiodo
BEGIN 
INSERT INTO cursoXperiodo(FEC_CREACION,USUARIO_CREACION)
VALUES(SYSDATE, 'myAdmin');
END;
