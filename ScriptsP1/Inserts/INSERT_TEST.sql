create or replace
PROCEDURE UPDATE_TEST(nombreColumna VARCHAR2,text VARCHAR2) AS
BEGIN
execute immediate 'INSERT INTO TESTNVL ( ' || nombreColumna || ') values(:text)' USING text;
--execute immediate 'INSERT INTO TESTNVL''( ' || nombreColumna || ')''VALUES(TEXT)';

END;
