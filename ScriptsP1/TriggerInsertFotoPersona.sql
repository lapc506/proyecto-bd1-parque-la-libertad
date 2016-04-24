create or replace
TRIGGER auditoria_insert_FotoPersona
BEFORE INSERT
ON FotoPersona
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := 'myAdmin';
END;
