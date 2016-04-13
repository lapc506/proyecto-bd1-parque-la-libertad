/**
 * 
 */
package org.parquelibertad.model;

/**
 * proyecto-bd1-parque-la-libertad
 * org.parquelibertad.model
 * 
 * @author Luis Andrés Peña Castillo 2014057250
 *         Derechos reservados bajo licencia MIT.
 *
 */
public class LibertadDatabaseConstraints {
  public static int Persona_id_NUMBER                            = 10;
  public static int Persona_nombre_VARCHAR2                      = 30;
  public static int Persona_primerApellido_VARCHAR2              = 30;
  public static int Persona_segundoApellido_VARCHAR2             = 30;
  public static int Persona_idNacionalidad_NUMBER                = 6;
  public static int Persona_idDistrito_NUMBER                    = 10;
  public static int Persona_direccionExacta_VARCHAR2             = 250;
  // persona.fecharegistro ya es tipo DATE

  public static int DocumentoIdentidad_id_NUMBER                 = 10;
  public static int DocumentoIdentidad_numeroIdentidad_NUMBER    = 10;
  public static int DocumentoIdentidad_idPersona_NUMBER          = 10;
  public static int DocumentoIdentidad_idRangoEdad_NUMBER        = 5;
  public static int DocumentoIdentidad_idTipo_NUMBER             = 5;

  public static int RangoEdad_id_NUMBER                          = 5;
  public static int RangoEdad_valorMin_NUMBER                    = 2;
  public static int RangoEdad_valorMax_NUMBER                    = 2;

  public static int TipoDocumentoIdentidad_id_NUMBER             = 5;
  public static int TipoDocumentoIdentidad_descripcion_VARCHAR2  = 30;

  public static int Pais_id_NUMBER                               = 4;
  public static int Pais_descripcion_VARCHAR2                    = 30;

  public static int Provincia_id_NUMBER                          = 6;
  public static int Provincia_idPais_NUMBER                      = 4;
  public static int Provincia_descripcion_VARCHAR2               = 30;

  public static int Canton_id_NUMBER                             = 8;
  public static int Canton_idProvincia_NUMBER                    = 6;
  public static int Canton_descripcion_VARCHAR2                  = 30;

  public static int Distrito_id_NUMBER                           = 10;
  public static int Distrito_idCanton_NUMBER                     = 8;
  public static int Distrito_descripcion_VARCHAR2                = 30;

  public static int Nacionalidad_id_NUMBER                       = 4;
  public static int Nacionalidad_idPais_NUMBER                   = 4;
  public static int Nacionalidad_descripcion_VARCHAR2            = 30;

  public static int NacionalidadesXPersona_idNacionalidad_NUMBER = 4;
  public static int NacionalidadesXPersona_idPersona_NUMBER      = 4;

  public static int Evento_id_NUMBER                             = 20;
  public static int Evento_descripcion_VARCHAR2                  = 30;
  // evento.fechaHoraInicio ya es tipo DATE
  public static int Evento_duracionHoras_NUMBER                  = 2;
  public static int Evento_duracionMinutos_NUMBER                = 2;
  public static int Evento_cupoMaximo_NUMBER                     = 4;
  public static int Evento_idTipoEvento_NUMBER                   = 3;
  public static int Evento_idInstitucion_NUMBER                  = 3;

  public static int TipoEvento_id_NUMBER                         = 3;
  public static int TipoEvento_descripcion_VARCHAR2              = 30;

  public static int Institucion_id_NUMBER                        = 3;
  public static int Institucion_nombre_VARCHAR2                  = 30;
  public static int Institucion_idDistrito_NUMBER                = 10;

  public static int VisitasEventos_id_NUMBER                     = 30;
  public static int VisitasEventos_idPersona_NUMBER              = 10;
  public static int VisitasEventos_idEvento_NUMBER               = 20;

  public static int Actividad_id_NUMBER                          = 20;
  public static int Actividad_descripcion_VARCHAR2               = 30;
  // Actividad_isActiva representa un boolean
  public static int Actividad_idTipo_NUMBER                      = 3;

  public static int TipoActividad_id_NUMBER                      = 3;
  public static int TipoActividad_descripcion_VARCHAR2           = 30;

  public static int Curso_id_NUMBER                              = 10;
  public static int Curso_nombre_VARCHAR2                        = 30;
  public static int Curso_costo_NUMBER                           = 20;
  public static int Curso_horaInicio_NUMBER                      = 2;
  public static int Curso_horaFin_NUMBER                         = 2;
  public static int Curso_estaActivo_NUMBER                      = 1;

  // Clase período son DATES:
  public static int Periodo_id_NUMBER                            = 10;

  public static int CuentaUsuario_id_NUMBER                      = 10;
  public static int CuentaUsuario_usuario_VARCHAR                = 20;
  public static int CuentaUsuario_contrasena_VARCHAR             = 20;
  public static int CuentaUsuario_idEmpleado_NUMBER              = 20;

  public static int Empleado_id_NUMBER                           = 10;
  public static int Empleado_idPersona_NUMBER                    = 10;

  public static int Alumno_id_NUMBER                             = 10;
  public static int Alumno_idPersona_NUMBER                      = 10;

  public static int EventoXPersona_id                            = 10;
  public static int EventoXPersona_idEvento                      = 20;
  public static int EventoXPersona_idPersona                     = 10;

  public static int CursoXPeriodo_id                             = 10;
  public static int CursoXPeriodo_idEvento                       = 20;
  public static int CursoXPeriodo_idPersona                      = 10;

  public static int CursoXEmpleado_id                            = 10;
  public static int CursoXEmpleado_idEvento                      = 20;
  public static int CursoXEmpleado_idPersona                     = 10;

  public static int CursoXPeriodo_id_NUMBER                      = 10;
  public static int CursoXPeriodo_idCurso_NUMBER                 = 10;
  public static int CursoXPeriodo_idPeriodo_NUMBER               = 10;

  public static int CursoXEmpleado_id_NUMBER                     = 10;
  public static int CursoXEmpleado_idCurso_NUMBER                = 10;
  public static int CursoXEmpleado_idEmpleado_NUMBER             = 10;
}
