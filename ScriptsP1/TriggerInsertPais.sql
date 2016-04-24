create or replace
TRIGGER auditoia_insert_Pais
BEFORE INSERT
ON Pais
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := 'myAdmin';
END;
