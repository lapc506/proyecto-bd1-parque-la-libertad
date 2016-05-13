-- Ejecutar desde SYSTEM:
-- GRANT CREATE PROCEDURE TO LibertadAdmin;
-- GRANT CREATE SYNONYM TO LibertadDemoUser;

--1.Personas por rango de fecha
CREATE OR REPLACE PROCEDURE personas_RANGO_FECHA_REG(fechaInicio IN Date, fechaFin IN Date, p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
  SELECT ID, NOMBRE, PRIMERAPELLIDO, SEGUNDOAPELLIDO FROM PERSONA 
  WHERE FECHAREGISTRO BETWEEN FECHAINICIO AND FECHAFIN;
END;
--2.Personas por país
CREATE OR REPLACE PROCEDURE personas_PAIS(PAIS_origen_ID IN NUMBER, p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
    SELECT p.ID, p.NOMBRE, p.PRIMERAPELLIDO, p.SEGUNDOAPELLIDO
      FROM PERSONA p
        INNER JOIN DISTRITO
          ON p.IDDISTRITO = DISTRITO.ID
        INNER JOIN CANTON
          ON CANTON.ID = DISTRITO.IDCANTON -- Proyección
        INNER JOIN PROVINCIA
          ON PROVINCIA.ID = CANTON.IDPROVINCIA
        INNER JOIN PAIS
          ON PAIS.ID = PROVINCIA.IDPAIS
        WHERE
          PAIS.ID = PAIS_origen_ID;
END;

--3.Personas por provincia
CREATE OR REPLACE PROCEDURE personas_PROVINCIA(PROVINCIA_origen_ID IN NUMBER, p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
    SELECT p.ID, p.NOMBRE, p.PRIMERAPELLIDO, p.SEGUNDOAPELLIDO
      FROM PERSONA p
        INNER JOIN DISTRITO
          ON p.IDDISTRITO = DISTRITO.ID
        INNER JOIN CANTON
          ON CANTON.ID = DISTRITO.IDCANTON -- Proyección
        INNER JOIN PROVINCIA
          ON PROVINCIA.ID = CANTON.IDPROVINCIA
        WHERE
          PROVINCIA.ID = PROVINCIA_origen_ID;
END;
--4.Personas por canton
CREATE OR REPLACE PROCEDURE personas_CANTON(CANTON_origen_ID IN NUMBER, p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
    SELECT p.ID, p.NOMBRE, p.PRIMERAPELLIDO, p.SEGUNDOAPELLIDO
      FROM PERSONA p
        INNER JOIN DISTRITO
          ON p.IDDISTRITO = DISTRITO.ID
        INNER JOIN CANTON
          ON CANTON.ID = DISTRITO.IDCANTON -- Proyección
        WHERE
          CANTON.ID = CANTON_origen_ID;
END;
--5.Personas por distrito
CREATE OR REPLACE PROCEDURE personas_DISTRITO(DISTRITO_origen_ID IN NUMBER, p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
  SELECT ID, NOMBRE, PRIMERAPELLIDO, SEGUNDOAPELLIDO
  FROM PERSONA 
  WHERE IDDISTRITO = DISTRITO_origen_ID;
END;

GRANT EXECUTE ON personas_PAIS TO libertadDemoUser;
GRANT EXECUTE ON personas_PROVINCIA TO libertadDemoUser;
GRANT EXECUTE ON personas_CANTON TO libertadDemoUser;
GRANT EXECUTE ON personas_DISTRITO TO libertadDemoUser;
GRANT EXECUTE ON personas_RANGO_FECHA_REG TO libertadDemoUser;
GRANT EXECUTE ON personas_NOMBRE TO libertadDemoUser;
GRANT EXECUTE ON personas_PRIMER_APELLIDO TO libertadDemoUser;
GRANT EXECUTE ON personas_SEGUNDO_APELLIDO TO libertadDemoUser;
GRANT EXECUTE ON personas_IDENTIFICACION TO libertadDemoUser;
GRANT EXECUTE ON topN_visitas_ACTIVIDADES TO libertadDemoUser;
GRANT EXECUTE ON topN_visitas_EVENTOS TO libertadDemoUser;

CREATE SYNONYM personas_PAIS FOR libertadAdmin.personas_PAIS;
CREATE SYNONYM personas_PROVINCIA FOR libertadAdmin.personas_PROVINCIA;
CREATE SYNONYM personas_CANTON FOR libertadAdmin.personas_CANTON;
CREATE SYNONYM personas_DISTRITO FOR libertadAdmin.personas_DISTRITO;
CREATE SYNONYM personas_RANGO_FECHA_REG FOR libertadAdmin.personas_RANGO_FECHA_REG;
CREATE SYNONYM personas_NOMBRE FOR libertadAdmin.personas_NOMBRE;
CREATE SYNONYM personas_PRIMER_APELLIDO FOR libertadAdmin.personas_PRIMER_APELLIDO;
CREATE SYNONYM personas_SEGUNDO_APELLIDO FOR libertadAdmin.personas_SEGUNDO_APELLIDO;
CREATE SYNONYM personas_IDENTIFICACION FOR libertadAdmin.personas_IDENTIFICACION;
CREATE SYNONYM topN_visitas_ACTIVIDADES FOR libertadAdmin.topN_visitas_ACTIVIDADES;
CREATE SYNONYM topN_visitas_EVENTOS FOR libertadAdmin.topN_visitas_EVENTOS;


--6.Personas que desertan un curso
CREATE OR REPLACE PROCEDURE personas_DESERTORES(CURSO_DESERTADO_ID IN NUMBER, p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
    SELECT p.ID, p.NOMBRE, p.PRIMERAPELLIDO, p.SEGUNDOAPELLIDO
      FROM PERSONA p
        INNER JOIN ALUMNO
          ON p.ID = alumno.idPersona
        INNER JOIN DESERCIONES
          on deserciones.id_alumno = alumno.id
        INNER JOIN CURSOXPERIODO
          on cursoxperiodo.id = deserciones.id_cursoxperiodo
--        INNER JOIN CURSO
--          on curso.id = cursoxperiodo.id_curso
      WHERE CURSOXPERIODO.ID_CURSO = CURSO_DESERTADO_ID;
END;
--7.Busqueda de personas por nombre, apellido, cedula
--Por Nombre:
CREATE OR REPLACE PROCEDURE personas_NOMBRE
(nombre_buscar IN VARCHAR2, tipo_documento IN NUMBER, p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
    SELECT p.ID, p.NOMBRE, p.PRIMERAPELLIDO, p.SEGUNDOAPELLIDO, di.numeroidentidad
      FROM PERSONA p INNER JOIN
      DOCUMENTOIDENTIDAD di ON p.ID = di.IDPERSONA
      WHERE p.NOMBRE LIKE 'Carlos'
        AND di.idtipo = '1';
END;
--Por apellido:
CREATE OR REPLACE PROCEDURE personas_PRIMER_APELLIDO
(apellido_buscar IN VARCHAR2, tipo_documento IN NUMBER, p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
    SELECT p.ID, p.NOMBRE, p.PRIMERAPELLIDO, p.SEGUNDOAPELLIDO, di.numeroidentidad
      FROM PERSONA p INNER JOIN
      DOCUMENTOIDENTIDAD di ON p.ID = di.IDPERSONA
      WHERE p.PRIMERAPELLIDO LIKE apellido_buscar
        AND di.idtipo = tipo_documento;
END;
CREATE OR REPLACE PROCEDURE personas_SEGUNDO_APELLIDO
(apellido_buscar IN VARCHAR2, tipo_documento IN NUMBER, p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
  SELECT p.ID, p.NOMBRE, p.PRIMERAPELLIDO, p.SEGUNDOAPELLIDO, di.numeroidentidad
      FROM PERSONA p INNER JOIN
      DOCUMENTOIDENTIDAD di ON p.ID = di.IDPERSONA
      WHERE p.SEGUNDOAPELLIDO LIKE apellido_buscar
        AND di.idtipo = tipo_documento;
END;
--Por Cédula
CREATE OR REPLACE PROCEDURE personas_IDENTIFICACION
(numero_documento IN NUMBER, tipo_documento IN NUMBER,
p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
    SELECT p.ID, p.NOMBRE, p.PRIMERAPELLIDO, p.SEGUNDOAPELLIDO, di.numeroidentidad
      FROM PERSONA p INNER JOIN
      DOCUMENTOIDENTIDAD di ON di.IDPERSONA = p.ID
        WHERE di.NUMEROIDENTIDAD = numero_documento
        AND di.IDTIPO = tipo_documento;
END;
SELECT * FROM PERSONA;
--8.Listado de cursos, eventos, actividades que se pueda filtrar por fecha
--Cursos
CREATE OR REPLACE PROCEDURE lista_cursos (p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
  SELECT * FROM CURSO
  ORDER BY IDHORARIOSEMANAL;
END;
--Eventos
CREATE OR REPLACE PROCEDURE lista_eventos (p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
  SELECT ID, DESCRIPCION, FECHAHORAINICIO, DURACIONHORAS, DURACIONMINUTOS, CUPOMAXIMO FROM EVENTO
  ORDER BY FECHAHORAINICIO;
END;
--Actividades
CREATE OR REPLACE PROCEDURE lista_actividades (p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
  SELECT ACTIVIDAD.DESCRIPCION, ISACTIVA, IDTIPO, VISITASACTIVIDADES.FECHAHORA 
  FROM ACTIVIDAD, VISITASACTIVIDADES
  WHERE VISITASACTIVIDADES.IDACTIVIDAD=ACTIVIDAD.ID
  ORDER BY VISITASACTIVIDADES.FECHAHORA;
END;
--9.lista de empleados
--Cedula:
CREATE OR REPLACE PROCEDURE empleados_cedula (p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
  SELECT p.ID, p.NOMBRE, p.PRIMERAPELLIDO, p.SEGUNDOAPELLIDO
  FROM PERSONA p, EMPLEADO, DOCUMENTOIDENTIDAD
  WHERE EMPLEADO.IDPERSONA = p.ID AND 
  DOCUMENTOIDENTIDAD.IDPERSONA = p.ID
  ORDER BY DOCUMENTOIDENTIDAD.IDTIPO;
END;
--NOMBRE
CREATE OR REPLACE PROCEDURE empleados_NOMBRE (p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
  SELECT p.ID, p.NOMBRE, p.PRIMERAPELLIDO, p.SEGUNDOAPELLIDO
  FROM PERSONA p, EMPLEADO
  WHERE EMPLEADO.IDPERSONA = p.ID 
  ORDER BY p.NOMBRE;
END;
--apellidos
CREATE OR REPLACE PROCEDURE empleados_1APELLIDO (p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
  SELECT p.ID, p.NOMBRE, p.PRIMERAPELLIDO, p.SEGUNDOAPELLIDO
  FROM PERSONA p, EMPLEADO
  WHERE EMPLEADO.IDPERSONA = p.ID 
  ORDER BY p.PRIMERAPELLIDO;
END;

CREATE OR REPLACE PROCEDURE topN_visitas_ACTIVIDADES
(pTop IN NUMBER, p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
    SELECT p.id, RANK() OVER (PARTITION BY vst.idpersona ORDER BY vst.fechahora),
      p.nombre, p.primerapellido, p.segundoapellido, a.descripcion
    FROM VISITASACTIVIDADES vst INNER JOIN PERSONA p ON vst.idPersona = p.id
      INNER JOIN ACTIVIDAD a ON vst.idactividad = a.id
    WHERE ROWNUM <= pTop;
END;

CREATE OR REPLACE PROCEDURE topN_visitas_EVENTOS
(pTop IN NUMBER, p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
    SELECT p.id, RANK() OVER (PARTITION BY vst.idpersona ORDER BY e.fechahorainicio),
      p.nombre, p.primerapellido, p.segundoapellido, e.descripcion
    FROM VISITASEVENTOS vst INNER JOIN PERSONA p ON vst.idPersona = p.id
      INNER JOIN EVENTO e ON vst.idevento = e.id
    WHERE ROWNUM <= pTop;
END;
