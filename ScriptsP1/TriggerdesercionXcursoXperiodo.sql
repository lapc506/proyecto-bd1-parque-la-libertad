create or replace
TRIGGER audi_ins_desercionXcursoXperi
BEFORE INSERT
ON desercionXcursoXperiodo
BEGIN 
INSERT INTO desercionXcursoXperiodo(FEC_CREACION,USUARIO_CREACION)
VALUES(SYSDATE, 'myAdmin');
END;
