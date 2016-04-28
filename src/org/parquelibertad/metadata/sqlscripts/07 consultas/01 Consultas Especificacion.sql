--1.Personas por rango de fecha
CREATE OR REPLACE PROCEDURE personas_RANGO_FECHA_REG(fechaInicio IN Date, fechaFin IN Date, p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
  SELECT ID, NOMBRE, PRIMERAPELLIDO, SEGUNDOAPELLIDO FROM PERSONA 
  WHERE FECHAREGISTRO BETWEEN FECHAINICIO AND FECHAFIN;
END
;
--2.Personas por pa�s
CREATE OR REPLACE PROCEDURE personas_PAIS(PAIS_origen_ID IN NUMBER, p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
    SELECT p.ID, p.NOMBRE, p.PRIMERAPELLIDO, p.SEGUNDOAPELLIDO
      FROM PERSONA p
        INNER JOIN DISTRITO
          ON p.IDDISTRITO = DISTRITO.ID
        INNER JOIN CANTON
          ON CANTON.ID = DISTRITO.IDCANTON -- Proyecci�n
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
          ON CANTON.ID = DISTRITO.IDCANTON -- Proyecci�n
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
          ON CANTON.ID = DISTRITO.IDCANTON -- Proyecci�n
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

CREATE SYNONYM personas_PAIS FOR libertadAdmin.personas_PAIS;
CREATE SYNONYM personas_PROVINCIA FOR libertadAdmin.personas_PROVINCIA;
CREATE SYNONYM personas_CANTON FOR libertadAdmin.personas_CANTON;
CREATE SYNONYM personas_DISTRITO FOR libertadAdmin.personas_DISTRITO;
CREATE SYNONYM personas_RANGO_FECHA_REG FOR libertadAdmin.personas_RANGO_FECHA_REG;


--6.Personas que desertan un curso
CREATE OR REPLACE PROCEDURE personas_DESERTORES(CURSO_DESERTADO IN VarChar2, p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
  SELECT ID, NOMBRE, PRIMERAPELLIDO, SEGUNDOAPELLIDO FROM PERSONA 
  WHERE ID=
  (SELECT IDPERSONA FROM ALUMNO, DESERCIONES, CURSOXPERIODO, CURSO
  WHERE CURSO.ID = CURSOXPERIODO.ID_CURSO AND 
  DESERCIONES.ID_CURSOXPERIODO = CURSOXPERIODO.ID AND
  DESERCIONES.ID_ALUMNO = ALUMNO.ID AND PERSONA.ID = ALUMNO.IDPERSONA AND
  CURSO.NOMBRE=CURSO_DESERTADO
  );
END;
--7.Busqueda de personas por nombre, apellido, cedula
--Por Nombre:
CREATE OR REPLACE PROCEDURE personas_nombre(nombre_buscar IN VarChar2, p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
  SELECT ID, NOMBRE, PRIMERAPELLIDO, SEGUNDOAPELLIDO FROM PERSONA 
  WHERE NOMBRE=nombre_buscar;
END;
--Por apellido:
CREATE OR REPLACE PROCEDURE personas_apellido(apellido_buscar IN VarChar2, p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
  SELECT ID, NOMBRE, PRIMERAPELLIDO, SEGUNDOAPELLIDO FROM PERSONA
  WHERE PRIMERAPELLIDO=apellido_buscar;
END;
--Por Cedula
CREATE OR REPLACE PROCEDURE personas_cedula(numero_cedula IN NUMBER, p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
  SELECT p.ID, p.NOMBRE, p.PRIMERAPELLIDO, p.SEGUNDOAPELLIDO
  FROM PERSONA p, DOCUMENTOIDENTIDAD
  WHERE DOCUMENTOIDENTIDAD.IDPERSONA = p.ID AND
  DOCUMENTOIDENTIDAD.NUMEROIDENTIDAD = numero_cedula;
END;
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
CREATE OR REPLACE PROCEDURE empleados_NOMBRE (p_recordset OUT SYS_REFCURSOR) AS
BEGIN
  OPEN p_recordset FOR
  SELECT p.ID, p.NOMBRE, p.PRIMERAPELLIDO, p.SEGUNDOAPELLIDO
  FROM PERSONA p, EMPLEADO
  WHERE EMPLEADO.IDPERSONA = p.ID 
  ORDER BY p.PRIMERAPELLIDO;
END;
