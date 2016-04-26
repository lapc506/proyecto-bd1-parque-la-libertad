-- Ejecutar desde SYSTEM:
-- GRANT CREATE TRIGGER TO libertadAdmin;
-- Ejecutar desde libertadAdmin:
create or replace
TRIGGER audi_insert_cuenta_usuario
BEFORE INSERT
ON CUENTAUSUARIO
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER auditoria_insert_curso
BEFORE INSERT
ON CURSO
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER audi_ins_imparte
BEFORE INSERT
ON IMPARTE
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER auditoria_insert_cursoXperiodo
BEFORE INSERT
ON cursoXperiodo
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER audi_ins_DESERCIONES
BEFORE INSERT
ON DESERCIONES
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER auditoria_insert_alumno
BEFORE INSERT
ON ALUMNO
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER audi_ins_MATRICULA
BEFORE INSERT
ON MATRICULA
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER auditoria_insert_canton
BEFORE INSERT
ON CANTON
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER auditoria_insert_distrito
BEFORE INSERT
ON distrito
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER audi_insert_DocumentoIdentidad
BEFORE INSERT
ON DocumentoIdentidad
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER auditoria_insert_empleado
BEFORE INSERT
ON EMPLEADO
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER auditoria_insert_Evento
BEFORE INSERT
ON Evento
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER audi_insert_EventoxPersona
BEFORE INSERT
ON EventoxPersona
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;
/*
create or replace
TRIGGER auditoria_insert_FotoPersona
BEFORE INSERT
ON FotoPersona
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;
*/

create or replace
TRIGGER auditoria_insert_Institucion
BEFORE INSERT
ON Institucion
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER auditoria_insert_Nacionalidad
BEFORE INSERT
ON Nacionalidad
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER audi_ins_NacionalidadesXPers
BEFORE INSERT
ON NacionalidadesXPersona
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER auditoia_insert_Pais
BEFORE INSERT
ON Pais
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER auditoia_insert_Periodo
BEFORE INSERT
ON Periodo
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER auditoia_insert_Persona
BEFORE INSERT
ON Persona
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER auditoia_insert_Provincia
BEFORE INSERT
ON Provincia
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER auditoia_insert_RangoEdad
BEFORE INSERT
ON RangoEdad
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER audi_ins_TipoDocumentoIdenti
BEFORE INSERT
ON TipoDocumentoIdentidad
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;

create or replace
TRIGGER auditoria_insert_TipoEvento
BEFORE INSERT
ON TipoEvento
FOR EACH ROW
BEGIN 
:new.FEC_CREACION := sysdate;
:new.USUARIO_CREACION := USER;
END;
