INSERT ALL
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(0,'Pintacaritas',1000,12,511,631,1,1)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(4,'Equidad de Genero',3000,75,541,721,3,1)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(5,'TaLler Adulto Mayor',2000,64,541,721,5,1)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(6,'Prevencion Violencia',1000,40,300,541,3,1)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(7,'Resolucion de conflictos',1000,20,500,815,4,1)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(8,'Serigrafia',1000,100,511,750,3,1)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(9,'Futbol Femenino',4000,88,400,650,3,1)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(10,'Futbol Masculino',5000,25,461,721,3,1)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(11,'Volleyball',2500,26,510,800,3,1)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(12,'Danza Popular',7000,27,600,840,4,0)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(13,'Mascaradas',3000,28,750,981,4,0)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(14,'Teatro Popular',6000,29,491,785,3,0)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(15,'Taller de Meditacion',3000,30,658,1201,4,1)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(16,'Robotica',8000,31,651,976,3,1)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(17,'Torneo de basquetbol',2000,32,751,1201,3,0)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(18,'Tutoria Matematicas',3000,33,690,951,2,1)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(19,'Adaptacion Mercado laboral',7000,34,511,980,4,0)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(20,'Yoga',2000,35,521,865,5,1)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(21,'Exposicion de Pinturas',3000,36,461,1260,4,0)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(22,'Concierto Sinfonico',3000,37,999,1320,4,1)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(23,'Mezclas en vivo',5000,38,641,846,3,1)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(24,'Periodismo comunitario',15000,39,720,981,3,1)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(25,'Club de fotografia',9000,40,750,900,3,1)
  INTO Curso(id,nombre,costo,idHorarioSemanal,idtranscursoDiaInicio,idtranscursoDiaFinal,idMercadoMeta,isActivo)
  VALUES(26,'Manipulacion de alimentos',8000,41,790,1000,3,1)
  
  INTO TipoEvento(id,descripcion) VALUES(1,'Deportivo')
  
  INTO Evento(id,descripcion,fechaHoraInicio,duracionHoras,duracionMinutos,cupoMaximo,idTipoEvento,idInstitucion)
  VALUES(1,'Carrera Sacos','16-APR-16',2,0,25,1,0)
  INTO Evento(id,descripcion,fechaHoraInicio,duracionHoras,duracionMinutos,cupoMaximo,idTipoEvento,idInstitucion)
  VALUES(2,'Carrera 3 pies','16-APR-16',2,0,50,1,0)
  
  INTO Periodo(id,IDFECHAINICIAL,IDFECHAFINAL) VALUES(1,'08-FEB-16','23-JUN-16')
  INTO Periodo(id,IDFECHAINICIAL,IDFECHAFINAL) VALUES(2,'26-JUL-16','24-NOV-16')
  
  INTO Empleado(id,idPersona) VALUES(1,1)
  INTO Empleado(id,idPersona) VALUES(2,2)
  
  INTO CuentaUsuario(id,usuario,contraseņa,idEmpleado) 
  VALUES(1,'user1','user1',1)
  INTO CuentaUsuario(id,usuario,contraseņa,idEmpleado) 
  VALUES(2,'user2','user2',2)
  
  INTO Alumno(id,idPersona,ANIOMATRICULA) VALUES(1,3,2016)
  INTO Alumno(id,idPersona,ANIOMATRICULA) VALUES(0,4,2014)
  
  INTO EventoXPersona(id,idEvento,idPersona) VALUES(0,0,5)
  INTO EventoXPersona(id,idEvento,idPersona) VALUES(1,1,6)
  
  INTO CursoXPeriodo(id,id_Curso,id_Periodo) VALUES(0,16,2)
  INTO CursoXPeriodo(id,id_Curso,id_Periodo) VALUES(1,12,2)
  INTO CursoXPeriodo(id,id_Curso,id_Periodo) VALUES(2,10,2)
  INTO CursoXPeriodo(id,id_Curso,id_Periodo) VALUES(3,8,1)
  
  INTO ActividadXPersona(id,idActividad,idPersona) VALUES(0,0,8)
  
  INTO CURSOXPERIODO(ID, ID_CURSO, ID_PERIODO) VALUES(0,22,1)
  INTO CURSOXPERIODO(ID, ID_CURSO, ID_PERIODO) VALUES(1,18,1)
  INTO CURSOXPERIODO(ID, ID_CURSO, ID_PERIODO) VALUES(2,13,2)
  INTO CURSOXPERIODO(ID, ID_CURSO, ID_PERIODO) VALUES(3,14,2)
  INTO CURSOXPERIODO(ID, ID_CURSO, ID_PERIODO) VALUES(4,15,1)
  INTO CURSOXPERIODO(ID, ID_CURSO, ID_PERIODO) VALUES(5,13,1)
  INTO CURSOXPERIODO(ID, ID_CURSO, ID_PERIODO) VALUES(6,8,2)
  INTO CURSOXPERIODO(ID, ID_CURSO, ID_PERIODO) VALUES(7,24,2)

  
  INTO IMPARTE(id, ID_EMPLEADO,ID_CURSOXPERIODO) VALUES(0,1,0)
  INTO IMPARTE(ID, ID_EMPLEADO,ID_CURSOXPERIODO) VALUES(1,1,2)
  INTO IMPARTE(ID, ID_EMPLEADO,ID_CURSOXPERIODO) VALUES(2,2,1)
  
  INTO MATRICULA(ID, ID_ALUMNO,ID_CURSOXPERIODO) VALUES(0,0,5)
  INTO MATRICULA(ID, ID_ALUMNO,ID_CURSOXPERIODO) VALUES(1,1,6)
  
  INTO DESERCIONES(ID, ID_ALUMNO,ID_CURSOXPERIODO) VALUES(0,0,1)
  INTO DESERCIONES(ID, ID_ALUMNO,ID_CURSOXPERIODO) VALUES(1,1,3)
  
  select * from dual
;