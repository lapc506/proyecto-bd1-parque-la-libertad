CREATE OR REPLACE PROCEDURE get_Paises
    (p_recordset OUT SYS_REFCURSOR)
   AS
  BEGIN
    OPEN p_recordset FOR
      SELECT p.id, p.descripcion
        FROM PAIS p;
  END;

CREATE OR REPLACE PROCEDURE get_Tipos_Documento
    (p_recordset OUT SYS_REFCURSOR)
   AS
  BEGIN
    OPEN p_recordset FOR
      SELECT id, descripcion FROM Tipodocumentoidentidad;
  END;

CREATE OR REPLACE PROCEDURE get_Nacionalidades
    (p_recordset OUT SYS_REFCURSOR)
   AS
  BEGIN
    OPEN p_recordset FOR
      SELECT id, descripcion FROM Nacionalidad;
  END;
  
CREATE OR REPLACE PROCEDURE get_Rangos_Edad
    (p_recordset OUT SYS_REFCURSOR)
   AS
  BEGIN
    OPEN p_recordset FOR
      SELECT id, valormin, valormax FROM RANGOEDAD;
  END;

CREATE OR REPLACE FUNCTION get_Distrito_Nombre (pDistritoID IN NUMBER)
    RETURN VARCHAR2 IS out_DistritoNombre DISTRITO.DESCRIPCION%TYPE;
  BEGIN
    SELECT DESCRIPCION INTO out_DistritoNombre FROM DISTRITO
    WHERE id = pDistritoID;
    RETURN out_DistritoNombre;
  END;

CREATE OR REPLACE PROCEDURE get_Provincias_por_Pais
    (pIDPais IN NUMBER, p_recordset OUT SYS_REFCURSOR)
   AS
  BEGIN
    OPEN p_recordset FOR
      SELECT p.id, p.descripcion
        FROM PROVINCIA p WHERE p.idPais = pIDPais;
  END;

CREATE OR REPLACE PROCEDURE get_Cantones_por_Provincia
    (pIDProvincia IN NUMBER, p_recordset OUT SYS_REFCURSOR)
   AS
  BEGIN
    OPEN p_recordset FOR
      SELECT c.id, c.descripcion
        FROM CANTON c WHERE c.idProvincia = pIDProvincia;
  END;
  
CREATE OR REPLACE PROCEDURE get_Distritos_por_Canton
    (pIDCanton IN NUMBER, p_recordset OUT SYS_REFCURSOR)
   AS
  BEGIN
    OPEN p_recordset FOR
      SELECT d.id, d.descripcion FROM DISTRITO d WHERE d.idCanton = pIDCanton;
  END;

SELECT id from CANTON where descripcion = 'Desamparados';
SELECT id, descripcion FROM DISTRITO WHERE idCanton IN (SELECT id from CANTON where descripcion = 'Desamparados');

GRANT EXECUTE ON get_Paises TO libertadDemoUser;
-- GRANT EXECUTE ON get_Pais_ID TO libertadDemoUser;
GRANT EXECUTE ON get_Provincias_por_Pais TO libertadDemoUser;
GRANT EXECUTE ON get_Cantones_por_Provincia TO libertadDemoUser;
GRANT EXECUTE ON get_Distritos_por_Canton TO libertadDemoUser;
GRANT EXECUTE ON get_Tipos_Documento TO libertadDemoUser;
GRANT EXECUTE ON get_Nacionalidades TO libertadDemoUser;
GRANT EXECUTE ON get_Rangos_Edad TO libertadDemoUser;
GRANT EXECUTE ON get_Distrito_Nombre TO libertadDemoUser;


-- Ejecutar como SYSTEM:
GRANT CREATE SYNONYM TO libertadDemoUser;
-- Ejecutar como libertadDemoUser:
CREATE SYNONYM get_Paises FOR libertadAdmin.get_Paises;
-- CREATE SYNONYM get_Pais_ID FOR libertadAdmin.get_Pais_ID;
CREATE SYNONYM get_Provincias_por_Pais FOR libertadAdmin.get_Provincias_por_Pais;
CREATE SYNONYM get_Cantones_por_Provincia FOR libertadAdmin.get_Cantones_por_Provincia;
CREATE SYNONYM get_Distritos_por_Canton FOR libertadAdmin.get_Distritos_por_Canton;
CREATE SYNONYM get_Tipos_Documento FOR libertadAdmin.get_Tipos_Documento;
CREATE SYNONYM get_Nacionalidades FOR libertadAdmin.get_Nacionalidades;
CREATE SYNONYM get_Rangos_Edad FOR libertadAdmin.get_Rangos_Edad;
CREATE SYNONYM get_Distrito_Nombre FOR libertadAdmin.get_Distrito_Nombre;
