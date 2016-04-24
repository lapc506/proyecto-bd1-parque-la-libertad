CREATE OR REPLACE PROCEDURE insert_Evento(DESCRIPCION VARCHAR2,FECHAHORAINICIO DATE, DURACIONHORAS NUMBER,DURACIONMINUTOS NUMBER,
CUPOMAXIMO NUMBER,IDTIPOEVENTO NUMBER,IDINSTITUCION NUMBER) AS
BEGIN
INSERT INTO EVENTO(id, descripcion, fechahorainicio, duracionhoras, duracionminutos, cupomaximo,idtipoevento, idinstitucion)
VALUES(s_Evento.NEXTVAL, DESCRIPCION,FECHAHORAINICIO,DURACIONHORAS,DURACIONMINUTOS,CUPOMAXIMO,IDTIPOEVENTO,IDINSTITUCION);
END;
