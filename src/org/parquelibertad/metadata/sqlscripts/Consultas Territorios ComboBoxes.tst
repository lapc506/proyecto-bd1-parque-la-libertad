PL/SQL Developer Test script 3.0
23
-- Created on 22/04/2016 by libertadAdmin 
DECLARE 
  pNombrePais VARCHAR2(30) := 'Costa Rica';
  selectedIDPais NUMBER(4);
  vID NUMBER(4);
  vDescripcion VARCHAR2(30);
  curProvincias SYS_REFCURSOR;
  
BEGIN
  selectedIDPais := get_Pais_ID(pNombrePais);
  DBMS_OUTPUT.PUT_LINE('ID del Pais: ' || selectedIDPais);
  get_Provincias_por_Pais(selectedIDPais, curProvincias);
  
  LOOP
      FETCH curProvincias INTO vID, vDescripcion;
    EXIT WHEN curProvincias%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE(vID || ' | ' || vDescripcion);
  END LOOP;
  
  -- Close cursor:
  CLOSE curProvincias;
  
end;
0
0
