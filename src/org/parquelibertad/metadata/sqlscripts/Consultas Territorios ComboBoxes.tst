PL/SQL Developer Test script 3.0
30
-- Created on 22/04/2016 by libertadAdmin 
DECLARE 
  vID CURSO.ID%TYPE;
  vNombre CURSO.NOMBRE%TYPE;
  vCosto CURSO.COSTO%TYPE;
  vActivo CURSO.ISACTIVO%TYPE;
  vEdadMin RANGOEDAD.VALORMIN%TYPE;
  vLunes HORARIOSEMANAL.LUNES%TYPE;
  vMartes HORARIOSEMANAL.MARTES%TYPE;
  vMiercoles HORARIOSEMANAL.MIERCOLES%TYPE;
  vJueves HORARIOSEMANAL.JUEVES%TYPE;
  vViernes HORARIOSEMANAL.VIERNES%TYPE;
  vSabado HORARIOSEMANAL.SABADO%TYPE;
  vDomingo HORARIOSEMANAL.DOMINGO%TYPE;
  
  curSOS SYS_REFCURSOR;
  
BEGIN
  get_CURSOS(curSOS);
  
  LOOP
      FETCH curSOS INTO vID, vNombre, vCosto, vActivo, vEdadMin, vLunes, vMartes, vMiercoles, vJueves, vViernes, vSabado, vDomingo;
    EXIT WHEN curSOS%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE(vID||' | '||vNombre);
  END LOOP;
  
  -- Close cursor:
  CLOSE curSOS;
  
end;
0
0
