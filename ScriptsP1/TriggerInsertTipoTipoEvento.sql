create or replace
TRIGGER auditoria_insert_TipoEvento
BEFORE INSERT
ON TipoEvento
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := 'myAdmin';
END;
