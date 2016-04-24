create or replace
TRIGGER auditoria_insert_Evento
BEFORE INSERT
ON Evento
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := 'myAdmin';
END;
