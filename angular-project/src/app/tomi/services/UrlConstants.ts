import MainConstants from "../../constants/main-constants";
export class UrlConstants {

  // routing
  static readonly INICIO = 'inicio';
  static readonly BLANK = 'blank';
  static readonly ERROR_PAGE = 'error';
  static readonly CONSULTAS = MainConstants.SIGESE + '/consultas';
  static readonly MENSUAL_SECCION_A = MainConstants.SIGESE + '/mensual_seccion_A'
  static readonly MENSUAL_SECCION_B = MainConstants.SIGESE + '/mensual_seccion_B'
  static readonly MENSUAL_SECCION_C1 = MainConstants.SIGESE + '/mensual_seccion_C1'
  static readonly MENSUAL_SECCION_C2 = MainConstants.SIGESE + '/mensual_seccion_C2'
  static readonly MENSUAL_SECCION_C3 = MainConstants.SIGESE + '/mensual_seccion_C3'
  static readonly MENSUAL_SECCION_C4 = MainConstants.SIGESE + '/mensual_seccion_C4'
  static readonly MENSUAL_SECCION_C5 = MainConstants.SIGESE + '/mensual_seccion_C5'
  static readonly MENSUAL_SECCION_C6 = MainConstants.SIGESE + '/mensual_seccion_C6'
  static readonly MENSUAL_SECCION_D = MainConstants.SIGESE + '/mensual_seccion_D'
  static readonly CIERRE_PERIODO = MainConstants.SIGESE + '/cierre_periodo'
  static readonly ESTRUCTURAL_SECCION_A = MainConstants.SIGESE + '/estructural_seccion_A'
  static readonly ESTRUCTURAL_SECCION_B = MainConstants.SIGESE + '/estructural_seccion_B'
  static readonly ESTRUCTURAL_SECCION_C_D = MainConstants.SIGESE + '/estructural_seccion_C_D'
  static readonly ESTRUCTURAL_SECCION_E = MainConstants.SIGESE + '/estructural_seccion_E'
  static readonly ESTRUCTURAL_SECCION_E2 = MainConstants.SIGESE + '/estructural_seccion_E2'
  static readonly ESTRUCTURAL_SECCION_E3 = MainConstants.SIGESE + '/estructural_seccion_E3'
  static readonly ESTRUCTURAL_SECCION_F = MainConstants.SIGESE + '/estructural_seccion_F'
  static readonly ESTRUCTURAL_SECCION_G = MainConstants.SIGESE + '/estructural_seccion_G'
  static readonly ESTRUCTURAL_SECCION_H = MainConstants.SIGESE + '/estructural_seccion_H'

  // config service
  static readonly GET_PARAMETROS_INICIALES = ''; // TODO

  // usuario service
  static readonly GET_USERS_FOR_TABLE = '/services/usuario/getUsersForTable';
  static readonly VALIDATE_USER_INPUTS = '/services/usuario/validateInputs';
  static readonly SAVE_USER = '/services/usuario/saveOrUpdate';
  static readonly DELETE_USER = '/services/usuario/delete';
  static readonly USER_IN_USE = '/services/usuario/isInUse';

  //mes service
  static readonly FIND_ALL_MESES = '/services/mes/findAllForGeneral';

  //tramite service
  static readonly FIND_ALL_TRAMITES = '/services/tramite/findAll';

  // casa service
  static readonly FIND_ALL_CASAS_LIGTH = '/services/casa/findAllLight';
  static readonly FIND_ALL_CASAS = '/services/casa/findAllGeneral';
  static readonly FIND_ALL_CASAS_DTO = '/services/casa/findAll';
  static readonly SAVE_OR_UPDATE_CASA = '/services/casa/saveOrUpdateCasa';
  static readonly SAVE_OR_UPDATE_CASA_GENERAL = '/services/casa/saveOrUpdateCasaGeneral';

  //hoja service
  static readonly GET_HOJAS_FOR_TABLE = '/services/hoja/getHojasForTable';
  static readonly GET_HOJAS_ABIERTAS_FOR_TABLE = '/services/hoja/getHojasAbiertasForTable';
  static readonly VALIDATE_INPUTS_HOJA_MENSUAL_SECCION_A_MENSUAL = '/services/hoja/validateInputsDatosIniciales'
  static readonly SAVE_OR_UPDATE_HOJA = '/services/hoja/saveOrUpdate'
  static readonly FIND_HOJA_ABIERTA_BY_CASA_AND_PERIODO = '/services/hoja/findHojaAbiertaByPeriodoAndCasa'
  static readonly CERRAR_PERIODO_HOJA = '/services/hoja/cerrarPeriodo'

  //hoja datos iniciales service
  static readonly SAVE_OR_UPDATE_DATOS_INICIALES_MENSUAL = '/services/hojaDatosIniciales/saveOrUpdateMensual'

  //Pics Geo Service
  static readonly FIND_PROVINCIAS_COMBO = '/services/pics/findAllProvinciasCombo';
  static readonly FIND_LOCALIDADES = '/services/pics/findAllLocalidades';
  static readonly FIND_DEPARTAMENTOS = '/services/pics/findAllDepartamentos';
  static readonly FIND_DEPARTAMENTOS_BY_PROVINCIA = '/services/pics/findAllDepartamentosByProvincia';
  static readonly FIND_LOCALIDADES_BY_DEPARTAMENTO = '/services/pics/findAllLocalidadesByDepartamento';
  static readonly FIND_ALL_TIPOS_DOCUMENTO = '/services/pics/findAllTiposDocumento';
  static readonly FIND_MUNICIPIOS_BY_DPTO_ID = '/services/pics/findMunicipiosByDepartamentoId';

  // hoja mensual asistidos service
  static readonly SAVE_OR_UPDATE_HOJA_MENSUAL_ASISTIDOS = '/services/hojaMensualAsistidos/saveOrUpdate'
  static readonly FIND_HOJA_MENSUAL_ASISTIDOS_BY_ID = '/services/hojaMensualAsistidos/findById'

  //alimentacion service
  static readonly FIND_ALL_ALIMENTACION = '/services/alimentacion/findAll';
  static readonly FIND_ALIMENTACION_EN_SEDE = '/services/alimentacion/findAllEnSede';
  static readonly FIND_ALIMENTACION_FUERA_DE_SEDE = '/services/alimentacion/findAllFueraDeSede';

  // mensual seccion c service
  static readonly SAVE_DATA_MENSUAL_SECCION_C1 = '/services/mensualSeccionC/saveOrUpdateSeccionC1';
  static readonly GET_DATA_FOR_SECCION_C1_BY_HOJA_ID = '/services/mensualSeccionC/getDataForSeccionC1ByHojaId';
  static readonly SAVE_DATA_MENSUAL_SECCION_C2 = '/services/mensualSeccionC/saveOrUpdateSeccionC2';
  static readonly GET_DATA_FOR_SECCION_C2_BY_HOJA_ID = '/services/mensualSeccionC/getDataForSeccionC2ByHojaId';
  static readonly SAVE_DATA_MENSUAL_SECCION_C3 = '/services/mensualSeccionC/saveOrUpdateSeccionC3';
  static readonly GET_DATA_FOR_SECCION_C3_BY_HOJA_ID = '/services/mensualSeccionC/getDataForSeccionC3ByHojaId';
  static readonly SAVE_DATA_MENSUAL_SECCION_C4 = '/services/mensualSeccionC/saveOrUpdateSeccionC4';
  static readonly GET_DATA_FOR_SECCION_C4_BY_HOJA_ID = '/services/mensualSeccionC/getDataForSeccionC4ByHojaId';
  static readonly SAVE_DATA_MENSUAL_SECCION_C5 = '/services/mensualSeccionC/saveOrUpdateSeccionC5';
  static readonly GET_DATA_FOR_SECCION_C5_BY_HOJA_ID = '/services/mensualSeccionC/getDataForSeccionC5ByHojaId';
  static readonly SAVE_DATA_MENSUAL_SECCION_C6 = '/services/mensualSeccionC/saveOrUpdateSeccionC6';
  static readonly GET_DATA_FOR_SECCION_C6_BY_HOJA_ID = '/services/mensualSeccionC/getDataForSeccionC6ByHojaId';

  //acompaniamiento service
  static readonly FIND_ALL_ESTABLECIMIENTOS_DE_SALUD = '/services/acompaniamiento/findAllEstablecimientosDeSalud';
  static readonly FIND_ALL_ESTABLECIMIENTOS_PATROCINIO_LEGAL = '/services/acompaniamiento/findAllEstablecimientosPatrocinioLegal';
  static readonly FIND_ALL_ESTABLECIMIENTOS_COMUNIDAD_TERAPEUTICA = '/services/acompaniamiento/findAllEstablecimientosComunuidadTerapeutica';
  static readonly FIND_ALL_ESTABLECIMIENTO_PENALES_COMISARIAS_TIPO_ACOMPANIAMIENTO = '/services/acompaniamiento/findAllEstablecimientosPenalesAndTipoAcompaniamiento';
  static readonly FIND_ALL_ESTABLECIMIENTO_PENALES_COMISARIAS_TIPO_ACTIVIDADES = '/services/acompaniamiento/findAllEstablecimientosPenalesAndTipoActividades';
  static readonly FIND_ALL_ESTABLECIMIENTOS_DE_SALUD_TIPO_ACOMPANIAMIENTO = '/services/acompaniamiento/findAllEstablecimientosDeSaludAndTipoAcompaniamiento';
  static readonly FIND_ALL_ESTABLECIMIENTOS_DE_SALUD_TIPO_GESTION = '/services/acompaniamiento/findAllEstablecimientosDeSaludAndTipoGestion';
  static readonly FIND_ALL_ESTABLECIMIENTO_PENALES_COMISARIAS = '/services/acompaniamiento/findAllEstablecimientoPenalesComisarias';
  static readonly FIND_ALL_ACOMPANIAMIENTOS = '/services/acompaniamiento/findAll';
  static readonly FIND_ALL_ESTABLECIMIENTO_PROFESIONAL_DE_SALUD = '/services/acompaniamiento/findAllEstablecimientoProfesionalDeSalud';
  static readonly FIND_ALL_ESTABLECIMIENTO_TRAYECTORIAS_EDUCATIVAS = '/services/acompaniamiento/findAllEstablecimientoTrayectoriasEducativas';

  // recurso service
  static readonly FIND_ALL_RECURSOS = '/services/recurso/findAll';

  // actividad intervencion service
  static readonly FIND_ALL_ACT_INT_TIPO_ACTIVIDAD = '/services/actividadIntervencion/findAllTipoActividad';
  static readonly FIND_ALL_ACT_INT_TIPO_FAMILIA = '/services/actividadIntervencion/findAllTipoFamilia';
  static readonly FIND_ALL_ACT_INT_TIPO_INTERVENCION = '/services/actividadIntervencion/findAllTipoIntervencion';

  // hoja mensual personal service
  static readonly GET_HOJA_MENSUAL_PERSONAL_FOR_TABLE = '/services/hojaMensualPersonal/getDataForTable';
  static readonly SAVE_OR_UPDATE_SECCION_D_HOJA_MENSUAL_PERSONAL = '/services/hojaMensualPersonal/saveOrUpdateSeccionD';

  //hoja mensual observaciones service
  static readonly FIND_HOJA_MENSUAL_OBSERVACIONES_BY_HOJA_ID = '/services/hojaMensualObservaciones/findByHojaId';
  static readonly SAVE_OR_UPDATE_MENSUAL_OBSERVACIONES_SECCION_D = '/services/hojaMensualObservaciones/saveOrUpdateSeccionD';

  //personal service
  static readonly FIND_PERSONAL_BY_DOCUMENTO = '/services/personal/findByDocumento';

  // alternativa asistencial service
  static readonly FIND_ALL_ALTERNATIVAS_ASSISTENCIALES = '/services/alternativaAsistencial/findAll';

  // estructural service
  static readonly SAVE_DATA_ESTRUCTURAL_SECCION_A = '/services/estructural/saveOrUpdateSeccionA';
  static readonly GET_DATA_ESTRUCTURAL_SECCION_A_BY_HOJA_ID = '/services/estructural/findDataSeccionAByHojaId';




}
