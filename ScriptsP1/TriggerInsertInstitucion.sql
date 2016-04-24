create or replace
TRIGGER auditoria_insert_Institucion
BEFORE INSERT
ON Institucion
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := 'myAdmin';
END;
