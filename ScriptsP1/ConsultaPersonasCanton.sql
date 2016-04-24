SELECT P.Nombre, P.PrimerApellido, P.SegundoApellido, C.Descripcion
FROM PERSONA P INNER JOIN
DISTRITO D ON P.IDDISTRITO=D.ID
INNER JOIN CANTON C
ON C.ID= d.idcanton;