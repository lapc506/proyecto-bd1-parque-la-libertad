DECLARE
  DESCRIPCION VARCHAR2(200);
BEGIN
  DESCRIPCION := 'Costa Rica';

  INSERT_PAIS(
    DESCRIPCION => DESCRIPCION
  );
END;