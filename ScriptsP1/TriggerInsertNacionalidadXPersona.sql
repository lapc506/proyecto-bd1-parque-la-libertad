create or replace
TRIGGER audi_ins_NacionalidadXPersona
BEFORE INSERT
ON NacionalidadXPersona
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := 'myAdmin';
END;
