create or replace
PROCEDURE UPDATE_TEST(nombreColumna ArrayVarchar,text ArrayVarchar) AS
ARRAYSIZE NUMBER(10);
BEGIN
ARRAYSIZE := nombrecolumna.COUNT;
FOR X IN 1..nombrecolumna.count LOOP
execute immediate 'UPDATE TESTNVL SET (' || nombreColumna(X) || ')=(:text) WHERE maslol=(:variable)' USING arraysize,'loles1';
END LOOP;
--execute immediate 'INSERT INTO TESTNVL''( ' || nombreColumna || ')''VALUES(TEXT)';

END;
