create or replace
TRIGGER audi_ins_TipoDocumentoIdenti
BEFORE INSERT
ON TipoDocumentoIdentidad
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := 'myAdmin';
END;
