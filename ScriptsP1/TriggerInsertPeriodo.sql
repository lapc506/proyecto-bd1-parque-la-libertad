create or replace
TRIGGER auditoia_insert_Periodo
BEFORE INSERT
ON Periodo
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := 'myAdmin';
END;
