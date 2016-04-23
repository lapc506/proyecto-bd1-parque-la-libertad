SELECT usr.TABLE_NAME, usr.COMMENTS FROM user_tab_comments usr ORDER BY usr.TABLE_NAME;
SELECT usr.TABLE_NAME FROM user_tab_comments usr ORDER BY usr.TABLE_NAME;

COMMENT ON TABLE ACTIVIDAD IS 'Listado de actividades periódicas del Parque.';
COMMENT ON TABLE ALUMNO IS 'Conjunto de personas promovidas a ser alumnas del Parque.';
COMMENT ON TABLE CANTON IS 'Listado de cantones de cada provincia registrados por un administrador.';
COMMENT ON TABLE CUENTAUSUARIO IS 'Conjunto de pares llave-valor para accesos al sistema.';
COMMENT ON TABLE DISTRITO IS 'Listado de distritos de cada cantón registrados por un administrador.';
COMMENT ON TABLE DOCUMENTOIDENTIDAD IS 'Conjunto de documentos personales por persona.';
COMMENT ON TABLE EMPLEADO IS 'Conjunto de personas promovidas a ser empleadas del Parque.';
COMMENT ON TABLE EVENTO IS 'Listado de eventos no recurrentes del Parque.';
COMMENT ON TABLE HORARIOSEMANAL IS
    'Conjunto de todos los posibles horarios por semana para cursos del Parque. Sus valores son representaciones en binario';
COMMENT ON TABLE INSTITUCION IS 'Listado de parques que forman parte de la Fundación.';
COMMENT ON TABLE NACIONALIDAD IS 'Listado de nacionalidades por país registrado en el parque.';
COMMENT ON TABLE NACIONALIDADESxPERSONA IS 'Conjunto de nacionalidades que posee cada persona.';
COMMENT ON TABLE PAIS IS 'Listado de países registrados por un administrador.';
COMMENT ON TABLE PERIODO IS 'Conjunto de rangos de fechas que determinan la duración de un curso.';
COMMENT ON TABLE PERSONA IS 'Conjunto de personas registradas, inicialmente usuarios del Parque.';
COMMENT ON TABLE PROVINCIA IS 'Listado de provincias de cada país registrado por un administrador.';
COMMENT ON TABLE RANGOEDAD IS 'Conjunto de rangos de edad de los visitantes del Parque.';
COMMENT ON TABLE TIPOACTIVIDAD IS 'Listado de tipos de actividades del Parque.';
COMMENT ON TABLE TIPODOCUMENTOIDENTIDAD IS 'Listado de tipos de documentos personales del Parque.';
COMMENT ON TABLE TIPOEMPLEADO IS 'Listado de tipos de empleado del Parque.';
COMMENT ON TABLE TIPOEVENTO IS 'Listado de tipos de evento del Parque.';
COMMENT ON TABLE TRANSCURSODIA IS 'Conjunto de las horas y minutos posibles en un día.';
COMMENT ON TABLE VISITASACTIVIDADES IS 'Conjunto de intereses de los usuarios en un día en el Parque.';
COMMENT ON TABLE EventoXPersona IS 'Listado de eventos a los que una persona ha asistido';
