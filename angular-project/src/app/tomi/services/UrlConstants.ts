
export class UrlConstants {
  static readonly INICIO = 'inicio';
  static readonly BLANK = 'blank';
  static readonly ERROR_PAGE = 'error';
  static readonly ABM_USUARIOS_VIEW = 'usuarios';

  // config service
  static readonly GET_PARAMETROS_INICIALES = ''; // TODO

  // usuario service
  static readonly GET_USERS_FOR_TABLE = '/services/usuario/getUsersForTable';
  static readonly VALIDATE_USER_INPUTS = '/services/usuario/validateInputs';
  static readonly SAVE_USER = '/services/usuario/saveOrUpdate';
  static readonly DELETE_USER = '/services/usuario/delete';
  static readonly USER_IN_USE = '/services/usuario/isInUse';

  //routing
  static readonly CAAC_VIEW = 'caac-view';
  static readonly CONSULTAS = 'consultas';

  //mes service
  static readonly FIND_ALL_MESES = '/services/mes/findAll';

  // casa service
  static readonly FIND_ALL_CASAS = '/services/casa/findAll'

  //hoja service
  static readonly GET_HOJAS_FOR_TABLE = '/services/hoja/getHojasForTable';

}
