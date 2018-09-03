
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
}
