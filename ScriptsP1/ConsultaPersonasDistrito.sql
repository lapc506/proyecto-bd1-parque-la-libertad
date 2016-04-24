SELECT P.Nombre, P.PrimerApellido, P.SegundoApellido, D.Descripcion
FROM PERSONA P INNER JOIN
DISTRITO D ON P.IDDISTRITO=D.ID;