ALTER TABLE ACTIVIDAD
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE ALUMNO
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE MATRICULA
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE CANTON
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE CUENTAUSUARIO
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE CURSO
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE IMPARTE
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE cursoXperiodo
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE DESERCIONES
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE distrito
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE DocumentoIdentidad
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE EMPLEADO
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE Evento
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE EventoxPersona
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

-- ALTER TABLE FotoPersona ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE Institucion
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE Nacionalidad
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE Nacionalidadesxpersona
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE Pais
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE Periodo
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE Persona
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE Provincia
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE RangoEdad
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE TipoDocumentoIdentidad
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE TipoEvento
-- DROP (Fec_creacion, Usuario_creacion, Fec_ultima_modificacion, Usuario_ultima_modificacion);
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(30),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));
