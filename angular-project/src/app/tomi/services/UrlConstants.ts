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
  static readonly VALIDATE_INPUTS_HOJA_MENSUAL_SECCION_A_MENSUAL = '/services/hoja/validateInputsDatosIniciales'
  static readonly SAVE_OR_UPDATE_HOJA = '/services/hoja/saveOrUpdate'
  static readonly FIND_HOJA_BY_CASA_AND_PERIODO = '/services/hoja/findByPeriodoAndCasa'

  //hoja datos iniciales service
  static readonly SAVE_OR_UPDATE_DATOS_INICIALES_MENSUAL = '/services/hojaDatosIniciales/saveOrUpdateMensual'

  //Pics Geo Service
  static readonly FIND_PROVINCIAS_COMBO = '/services/pics/findAllProvinciasCombo';
  static readonly FIND_LOCALIDADES = '/services/pics/findAllLocalidades';
  static readonly FIND_DEPARTAMENTOS = '/services/pics/findAllDepartamentos';
  static readonly FIND_DEPARTAMENTOS_BY_PROVINCIA = '/services/pics/findAllDepartamentosByProvincia';
  static readonly FIND_LOCALIDADES_BY_DEPARTAMENTO = '/services/pics/findAllLocalidadesByDepartamento';

  // hoja mensual asistidos service
  static readonly SAVE_OR_UPDATE_HOJA_MENSUAL_ASISTIDOS = '/services/hojaMensualAsistidos/saveOrUpdate'
  static readonly FIND_HOJA_MENSUAL_ASISTIDOS_BY_ID = '/services/hojaMensualAsistidos/findById'

  //alimentacion service
  static readonly FIND_ALL_ALIMENTACION = '/services/alimentacion/findAll';

  // mensual seccion c service
  static readonly SAVE_DATA_MENSUAL_SECCION_C1 = '/services/mensualSeccionC/saveOrUpdateSeccionC1';
  static readonly GET_DATA_FOR_SECCION_C1_BY_HOJA_ID = '/services/mensualSeccionC/getDataForSeccionC1ByHojaId';
  static readonly SAVE_DATA_MENSUAL_SECCION_C2 = '/services/mensualSeccionC/saveOrUpdateSeccionC2';
  static readonly GET_DATA_FOR_SECCION_C2_BY_HOJA_ID = '/services/mensualSeccionC/getDataForSeccionC2ByHojaId';

  //acompaniamiento service
  static readonly FIND_ALL_ESTABLECIMIENTOS_DE_SALUD = '/services/acompaniamiento/findAllEstablecimientosDeSalud';






}
