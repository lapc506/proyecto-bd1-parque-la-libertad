create or replace
TRIGGER audi_insert_EventoxPersona
BEFORE INSERT
ON EventoxPersona
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := 'myAdmin';
END;
