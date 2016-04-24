create or replace
TRIGGER auditoria_insert_Nacionalidad
BEFORE INSERT
ON Nacionalidad
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := 'myAdmin';
END;
