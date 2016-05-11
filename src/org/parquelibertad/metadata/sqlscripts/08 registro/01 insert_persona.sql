GRANT EXECUTE ON INSERT_PERSONA TO libertadDemoUser;
GRANT EXECUTE ON INSERT_CURSO TO libertadDemoUser;
GRANT EXECUTE ON INSERT_ACTIVIDAD TO libertadDemoUser;
GRANT EXECUTE ON INSERT_MATRICULA TO libertadDemoUser;
GRANT EXECUTE ON get_unq_id_semana TO libertadDemoUser;
GRANT EXECUTE ON get_unq_id_Horario TO libertadDemoUser;

-- Ejecutar como libertadDemoUser:
CREATE SYNONYM INSERT_PERSONA FOR libertadAdmin.INSERT_PERSONA;
CREATE SYNONYM INSERT_CURSO FOR libertadAdmin.INSERT_CURSO;
CREATE SYNONYM INSERT_ACTIVIDAD FOR libertadAdmin.INSERT_ACTIVIDAD;
CREATE SYNONYM INSERT_MATRICULA FOR libertadAdmin.INSERT_MATRICULA;
CREATE SYNONYM get_unq_id_semana FOR libertadAdmin.get_unq_id_semana;
CREATE SYNONYM get_unq_id_Horario FOR libertadAdmin.get_unq_id_Horario;

CREATE OR REPLACE PROCEDURE INSERT_PERSONA(
  pNombre IN VARCHAR2,
  pPrimerApellido IN VARCHAR2,
  pSegundoApellido IN VARCHAR2,
  pNumeroDocumento IN NUMBER,
  pIDTipoDocumento IN NUMBER,
  pRangoEdadID IN NUMBER,
  pIDNacionalidad IN NUMBER,
  pDistritoID IN NUMBER,
  pDireccion IN VARCHAR2) -- Sin cursor de salida
AS BEGIN
   INSERT INTO Persona(id, nombre, primerApellido, segundoApellido, idDistrito, direccionExacta, fechaRegistro) VALUES
   (s_Persona.Nextval, pNombre,pPrimerApellido,pSegundoApellido,pDistritoID,pDireccion,SYSDATE);
   INSERT INTO Nacionalidadesxpersona (Idnacionalidad, Idpersona) VALUES (pIDNacionalidad, s_Persona.Currval);
   INSERT INTO Documentoidentidad (Id,Numeroidentidad,Idpersona,Idrangoedad,Idtipo) VALUES
   (s_documentoidentidad.nextval,pNumeroDocumento,s_Persona.Currval,pRangoEdadID,pIDTipoDocumento);
   COMMIT;
END;

CREATE OR REPLACE PROCEDURE INSERT_CURSO(
  pNombreCURSO IN VARCHAR,
  pCosto IN NUMBER,
  pIDHorario IN NUMBER,
  pIDHoraInicio IN NUMBER,
  pIDHoraFinal IN NUMBER,
  pIDMercadoMeta IN NUMBER,
  pActivoBoolean IN NUMBER) -- Sin cursor de salida
AS BEGIN
   INSERT INTO CURSO (id, nombre, costo, idHorarioSemanal, idHoraInicio, idHoraFinal, idMercadoMeta, isActivo) VALUES
   (s_curso.NEXTVAL, pNombreCURSO, pCosto, pIDHorario, pIDHoraInicio, pIDHoraFinal, pIDMercadoMeta, pActivoBoolean);
   COMMIT;
END;
/*
SELECT ID, NOMBRE, PRIMERAPELLIDO, SEGUNDOAPELLIDO FROM PERSONA;
SELECT id FROM NACIONALIDAD WHERE descripcion = 'Costarricense';
SELECT id FROM RANGOEDAD WHERE VALORMIN = 31;
SELECT id FROM TIPODOCUMENTOIDENTIDAD WHERE DESCRIPCION = 'Cédula';

INSERT_PERSONA(pNombre  => 'Adriana',
               pPrimerApellido  => 'Álvarez',
               pSegundoApellido => 'Figueroa',
               pNumeroDocumento => 109880813,
               pIDTipoDocumento => 1,
               pRangoEdadID     => 5,
               pIDNacionalidad  => 2,  --'Costarricense'
               pDistritoID      => 19, --'Tres Ríos'
               pDireccion       => 'Concepción');
*/

CREATE OR REPLACE PROCEDURE INSERT_ACTIVIDAD(
  pDescripcion IN VARCHAR2,
  pIDTipoActividad IN NUMBER,
  pIsActiva IN NUMBER) -- Sin cursor de salida
AS BEGIN
   INSERT INTO Actividad(id,Descripcion,Isactiva,Idtipo) VALUES
   (s_Actividad.Nextval, pDescripcion, pIsActiva, pIDTipoActividad);
   COMMIT;
END;

CREATE OR REPLACE PROCEDURE INSERT_MATRICULA(
  pCURSOXPERIODO IN NUMBER,
  pID_ALUMNO IN NUMBER) -- Sin cursor de salida
AS BEGIN
   INSERT INTO MATRICULA(ID, ID_CURSOXPERIODO, ID_ALUMNO) VALUES
   (s_Matricula.Nextval, pCURSOXPERIODO, pID_ALUMNO);
   COMMIT;
END;

SELECT * FROM MATRICULA;
-- INSERT INTO MATRICULA (ID, ID_CURSOXPERIODO, ID_ALUMNO) VALUES (s_Matricula.Nextval, pID_CXP, pIDAlumno);
-- INSERT INTO DESERCIONES (ID, ID_CURSOXPERIODO, ID_ALUMNO, MOTIVO) VALUES (s_Deserciones.Nextval, pID_CXP, pIDAlumno, pMotivo);

CREATE OR REPLACE FUNCTION get_unq_id_semana(
  pLunesBoolean IN NUMBER,
  pMartesBoolean IN NUMBER,
  pMiercolesBoolean IN NUMBER,
  pJuevesBoolean IN NUMBER,
  pViernesBoolean IN NUMBER,
  pSabadoBoolean IN NUMBER,
  pDomingoBoolean IN NUMBER)
RETURN NUMBER IS out_SemanaID HorarioSemanal.ID%TYPE;
BEGIN
  SELECT hs.id INTO out_SemanaID FROM HorarioSemanal hs
    WHERE
      hs.lunes = pLunesBoolean AND
      hs.martes = pMartesBoolean AND
      hs.miercoles = pMiercolesBoolean AND
      hs.jueves = pJuevesBoolean AND
      hs.viernes = pViernesBoolean AND
      hs.sabado = pSabadoBoolean AND
      hs.domingo = pDomingoBoolean;
    RETURN out_SemanaID;
END;

CREATE OR REPLACE FUNCTION get_unq_id_Horario(
  pHora IN NUMBER,
  pMinuto IN NUMBER)
RETURN NUMBER IS out_HorarioID TranscursoDia.ID%TYPE;
BEGIN
  SELECT td.id INTO out_HorarioID FROM TranscursoDia td
    WHERE
      td.hora = pHora AND -- Formato de AM/PM convertido desde Java
      td.minuto = pMinuto;
    RETURN out_HorarioID;
END;

