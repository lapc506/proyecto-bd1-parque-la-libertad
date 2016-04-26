INSERT INTO Nacionalidad (id,idPais,Descripcion) VALUES(s_Nacionalidad.Nextval, 1, 'Argentino');
INSERT INTO Nacionalidad (id,idPais,Descripcion) VALUES(s_Nacionalidad.Nextval, 2, 'Costarricense');
INSERT INTO Nacionalidad (id,idPais,Descripcion) VALUES(s_Nacionalidad.Nextval, 3, 'Panameño');
INSERT INTO Nacionalidad (id,idPais,Descripcion) VALUES(s_Nacionalidad.Nextval, 4, 'Ruso');
  SELECT * FROM NACIONALIDAD;
INSERT INTO Persona(id, nombre,primerApellido, segundoApellido,idDistrito,direccionExacta,fechaRegistro)
  VALUES (s_Persona.Nextval,'Maria','Soto','Gomez',13,'Del Bar Cachos 400m N 120m E',SYSDATE);
INSERT INTO NACIONALIDADESXPERSONA (IDNACIONALIDAD,IDPERSONA) VALUES (2, 1);
    
INSERT INTO Persona(id, nombre,primerApellido, segundoApellido,idDistrito,direccionExacta,fechaRegistro)
  VALUES (s_Persona.Nextval,'Alejandra','Fernandez','Garcia',14,'De la plaza 350m O 120m S',SYSDATE);
INSERT INTO NACIONALIDADESXPERSONA (IDNACIONALIDAD,IDPERSONA) VALUES (2, 2);
    
INSERT INTO Persona(id, nombre,primerApellido, segundoApellido,idDistrito,direccionExacta,fechaRegistro)
  VALUES (s_Persona.Nextval,'Carlos','Guadamuz','Ruiz',15,'De la escuela 800m N 100m O',SYSDATE);
INSERT INTO NACIONALIDADESXPERSONA (IDNACIONALIDAD,IDPERSONA) VALUES (3, 3);
    
INSERT  INTO Persona(id, nombre,primerApellido, segundoApellido,idDistrito,direccionExacta,fechaRegistro)
  VALUES (s_Persona.Nextval,'Tatiana','Rojas','Alvarez',13,'De los tribunales 200m S 50m E',SYSDATE);
INSERT    INTO NACIONALIDADESXPERSONA (IDNACIONALIDAD,IDPERSONA) VALUES (3, 4);
    
INSERT  INTO Persona(id, nombre,primerApellido, segundoApellido,idDistrito,direccionExacta,fechaRegistro)
  VALUES (s_Persona.Nextval,'Maria Elena','Perez','Sanchez',14,'Del Restaurante Luna 600m S 250m E',SYSDATE);
INSERT    INTO NACIONALIDADESXPERSONA (IDNACIONALIDAD,IDPERSONA) VALUES (4, 5);
    
INSERT  INTO Persona(id, nombre,primerApellido, segundoApellido,idDistrito,direccionExacta,fechaRegistro)
  VALUES (s_Persona.Nextval,'Julian','Camacho','Zumbado',15,'Del Bar Cachos 400m N 120m E',SYSDATE);
INSERT    INTO NACIONALIDADESXPERSONA (IDNACIONALIDAD,IDPERSONA) VALUES (4, 6);
    
INSERT  INTO Persona(id, nombre,primerApellido, segundoApellido,idDistrito,direccionExacta,fechaRegistro)
  VALUES (s_Persona.Nextval,'Andres','Mora','Salas',13,'De la iglesa central 500m E 120m N',SYSDATE);
INSERT    INTO NACIONALIDADESXPERSONA (IDNACIONALIDAD,IDPERSONA) VALUES (1, 7);
    
INSERT  INTO Persona(id, nombre,primerApellido, segundoApellido,idDistrito,direccionExacta,fechaRegistro)
  VALUES (s_Persona.Nextval,'Sergio','Aguirre','Rios',14,'De la UNED 300m N 75m E',SYSDATE);
INSERT    INTO NACIONALIDADESXPERSONA (IDNACIONALIDAD,IDPERSONA) VALUES (1, 8);
    
INSERT  INTO Persona(id, nombre,primerApellido, segundoApellido,idDistrito,direccionExacta,fechaRegistro)
  VALUES (s_Persona.Nextval,'Roy','Bermudez','Vidal',15,'Frente a la Cerrajeria Arce',SYSDATE);
INSERT    INTO NACIONALIDADESXPERSONA (IDNACIONALIDAD,IDPERSONA) VALUES (2, 9);
    
INSERT  INTO Persona(id, nombre,primerApellido, segundoApellido,idDistrito,direccionExacta,fechaRegistro)
  VALUES (s_Persona.Nextval,'Eduardo','Figueroa','Campos',13,'Diagonal al colegio Golden Valley',SYSDATE);
INSERT    INTO NACIONALIDADESXPERSONA (IDNACIONALIDAD,IDPERSONA) VALUES (3, 10);
  
INSERT  INTO RangoEdad(id,valorMin,valorMax) VALUES(s_rangoedad.nextval,0,4);
INSERT  INTO RangoEdad(id,valorMin,valorMax) VALUES(s_rangoedad.nextval,5,12);
INSERT  INTO RangoEdad(id,valorMin,valorMax) VALUES(s_rangoedad.nextval,13,17);
INSERT  INTO RangoEdad(id,valorMin,valorMax) VALUES(s_rangoedad.nextval,18,30);
INSERT  INTO RangoEdad(id,valorMin,valorMax) VALUES(s_rangoedad.nextval,31,60);
INSERT  INTO RangoEdad(id,valorMin,valorMax) VALUES(s_rangoedad.nextval,61,99);
  
INSERT  INTO TipoDocumentoIdentidad(id,descripcion) VALUES(s_tipodocumentoidentidad.nextval, 'Cédula');
INSERT  INTO TipoDocumentoIdentidad(id,descripcion) VALUES(s_tipodocumentoidentidad.nextval, 'Tarjeta Identificacion Menores');
INSERT  INTO TipoDocumentoIdentidad(id,descripcion) VALUES(s_tipodocumentoidentidad.nextval, 'Pasaporte');
  
INSERT  INTO DocumentoIdentidad(id,numeroIdentidad,idPersona,idRangoEdad,idTipo)
  VALUES (s_documentoidentidad.nextval,402501230,10,4,1);
INSERT  INTO DocumentoIdentidad(id,numeroIdentidad,idPersona,idRangoEdad,idTipo)
  VALUES (s_documentoidentidad.nextval,501500025,5,3,1);
INSERT  INTO DocumentoIdentidad(id,numeroIdentidad,idPersona,idRangoEdad,idTipo)
  VALUES (s_documentoidentidad.nextval,11310256,1,2,2);
INSERT  INTO DocumentoIdentidad(id,numeroIdentidad,idPersona,idRangoEdad,idTipo)
  VALUES (s_documentoidentidad.nextval,701250458,2,4,1);
INSERT  INTO DocumentoIdentidad(id,numeroIdentidad,idPersona,idRangoEdad,idTipo)
  VALUES (s_documentoidentidad.nextval,201650784,6,4,3);
  
INSERT  INTO Institucion(id,nombre,idDistrito) VALUES(s_Institucion.nextval,'Parque La Libertad',16);
  
INSERT  INTO TipoEvento(id,descripcion) VALUES(s_tipoevento.nextval,'Charla');
  
INSERT  INTO Evento(id,descripcion,fechaHoraInicio,duracionHoras,duracionMinutos,cupoMaximo,idTipoEvento,idInstitucion)
  VALUES(s_evento.nextval,'Salud mental', '07-JUN-2016', 1,40,50,0,0);
  
INSERT  INTO Eventoxpersona(id,idPersona,idEvento) VALUES(s_eventoxpersona.nextval,10,1);
  
INSERT  INTO TipoActividad(id, descripcion) VALUES(s_tipoactividad.nextval,'Actividad Fisica');
  
INSERT  INTO Actividad(id,descripcion,isActiva,idTipo) 
  VALUES(s_actividad.nextval,'Zumba al aire libre',1,0);
  
INSERT  INTO VisitasActividades(id,idPersona,idActividad,fechaHora) VALUES(s_visitasactividades.nextval,4,0,'07-JUN-2016');
