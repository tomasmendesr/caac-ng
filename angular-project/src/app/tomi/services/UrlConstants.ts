export class UrlConstants {

  // routing
  static readonly INICIO = 'inicio';
  static readonly BLANK = 'blank';
  static readonly ERROR_PAGE = 'error';
  static readonly CONSULTAS = 'consultas';
  static readonly MENSUAL_SECCION_A = 'mensual_seccion_A'
  static readonly MENSUAL_SECCION_B = 'mensual_seccion_B'
  static readonly MENSUAL_SECCION_C1 = 'mensual_seccion_C1'
  static readonly MENSUAL_SECCION_C2 = 'mensual_seccion_C2'
  static readonly MENSUAL_SECCION_C3 = 'mensual_seccion_C3'
  static readonly MENSUAL_SECCION_C4 = 'mensual_seccion_C4'
  static readonly MENSUAL_SECCION_C5 = 'mensual_seccion_C5'
  static readonly MENSUAL_SECCION_C6 = 'mensual_seccion_C6'
  static readonly MENSUAL_SECCION_D = 'mensual_seccion_D'
  static readonly CIERRE_PERIODO = 'cierre_periodo'
  static readonly ESTRUCTURAL_SECCION_A = 'estructural_seccion_A'
  static readonly ESTRUCTURAL_SECCION_B = 'estructural_seccion_B'
  static readonly ESTRUCTURAL_SECCION_C_D = 'estructural_seccion_C_D'
  static readonly ESTRUCTURAL_SECCION_E = 'estructural_seccion_E'
  static readonly ESTRUCTURAL_SECCION_E2 = 'estructural_seccion_E2'
  static readonly ESTRUCTURAL_SECCION_E3 = 'estructural_seccion_E3'
  static readonly ESTRUCTURAL_SECCION_F = 'estructural_seccion_F'
  static readonly ESTRUCTURAL_SECCION_G = 'estructural_seccion_G'
  static readonly ESTRUCTURAL_SECCION_H = 'estructural_seccion_H'

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

  // casa service
  static readonly FIND_ALL_CASAS_LIGTH = '/services/casa/findAllLight';
  static readonly FIND_ALL_CASAS = '/services/casa/findAllGeneral';
  static readonly FIND_ALL_CASAS_DTO = '/services/casa/findAll';

  //hoja service
  static readonly GET_HOJAS_FOR_TABLE = '/services/hoja/getHojasForTable';
  static readonly VALIDATE_INPUTS_HOJA_MENSUAL_SECCION_A_MENSUAL = '/services/hoja/validateInputsDatosIniciales'
  static readonly SAVE_OR_UPDATE_HOJA = '/services/hoja/saveOrUpdate'

  //hoja datos iniciales service
  static readonly SAVE_OR_UPDATE_DATOS_INICIALES_MENSUAL = '/services/hojaDatosIniciales/saveOrUpdateMensual'

  //Pics Geo Service
  static readonly FIND_PROVINCIAS_COMBO = '/services/pics/findAllProvinciasCombo';

}
