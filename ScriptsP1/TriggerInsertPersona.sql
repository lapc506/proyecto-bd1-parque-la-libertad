create or replace
TRIGGER auditoia_insert_Persona
BEFORE INSERT
ON Persona
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := 'myAdmin';
END;
