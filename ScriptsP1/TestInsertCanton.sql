DECLARE
  IDPROVINCIA NUMBER;
  DESCRIPCION VARCHAR2(200);
BEGIN
  IDPROVINCIA := 1;
  DESCRIPCION := 'Belen';

  INSERT_CANTON(
    IDPROVINCIA => IDPROVINCIA,
    DESCRIPCION => DESCRIPCION
  );
  COMMIT;
END;