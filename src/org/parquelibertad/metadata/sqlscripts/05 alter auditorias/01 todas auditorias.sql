ALTER TABLE ACTIVIDAD
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE ALUMNO
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE MATRICULA
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE CANTON
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE CUENTAUSUARIO
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE CURSO
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE IMPARTE
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE cursoXperiodo
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE DESERCIONES
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE distrito
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE DocumentoIdentidad
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE EMPLEADO
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE Evento
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE EventoxPersona
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

-- ALTER TABLE FotoPersona ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE Institucion
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE Nacionalidad
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE Nacionalidadesxpersona
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE Pais
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE Periodo
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE Persona
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE Provincia
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE RangoEdad
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE TipoDocumentoIdentidad
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));

ALTER TABLE TipoEvento
ADD (Fec_creacion DATE, Usuario_creacion VARCHAR2(10),Fec_ultima_modificacion DATE,Usuario_ultima_modificacion VARCHAR(10));
