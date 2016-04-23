-- Ejecutar como SYSTEM:
GRANT DEBUG CONNECT SESSION TO libertadAdmin;
GRANT CREATE PROCEDURE TO libertadAdmin;

-- Ejecutar como libertadAdmin:
CREATE OR REPLACE 
  FUNCTION get_Pais_ID
    (pNombrePais IN VARCHAR2)
    RETURN NUMBER IS
    out_PaisID PAIS.ID%TYPE;
  BEGIN
    SELECT ps.id INTO out_PaisID FROM PAIS ps
    WHERE ps.descripcion = pNombrePais;
    RETURN out_PaisID;
  END;

CREATE OR REPLACE 
  PROCEDURE get_Provincias_por_Pais
    (pIDPais IN NUMBER, p_recordset OUT SYS_REFCURSOR)
   AS
  BEGIN
    OPEN p_recordset FOR
      SELECT p.id, p.descripcion
        FROM PROVINCIA p WHERE p.idPais = pIDPais;
  END;

GRANT EXECUTE ON get_Pais_ID TO libertadDemoUser;
GRANT EXECUTE ON get_Provincias_por_Pais TO libertadDemoUser;
-- Ejecutar como SYSTEM:
GRANT CREATE SYNONYM TO libertadDemoUser;
-- Ejecutar como libertadDemoUser:
CREATE SYNONYM get_Pais_ID FOR libertadAdmin.get_Pais_ID;
CREATE SYNONYM get_Provincias_por_Pais FOR libertadAdmin.get_Provincias_por_Pais;
