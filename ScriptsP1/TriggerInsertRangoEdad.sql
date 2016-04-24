create or replace
TRIGGER auditoia_insert_RangoEdad
BEFORE INSERT
ON RangoEdad
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := 'myAdmin';
END;
