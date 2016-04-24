create or replace
TRIGGER auditoia_insert_Provincia
BEFORE INSERT
ON Provincia
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := 'myAdmin';
END;
