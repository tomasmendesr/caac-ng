export class UrlConstantsCaac {

  public static readonly CAAC = 'caac';
  public static readonly GENERAL_URL = UrlConstantsCaac.CAAC + '/general';
  public static readonly ADMINISTRATIVO_URL = UrlConstantsCaac.CAAC + '/administrativo';
  public static readonly VENCIMIENTOS_URL = UrlConstantsCaac.CAAC + '/vencimientos';
  public static readonly AUDITORIA_URL = UrlConstantsCaac.CAAC + '/auditoria';
  public static readonly PAGOS_URL = UrlConstantsCaac.CAAC + '/pagos';
  public static readonly REPORTES_URL = UrlConstantsCaac.CAAC + '/reportes';

  public static readonly FIND_ALL_CASAS_GENERAL = '/services/casa/findAllGeneral';
  public static readonly FIND_ALL_CASAS_ADMINISTRATIVO = '/services/casa/findAllAdministrativo';
  public static readonly FIND_ALL_CATEGORIAS = '/services/categoria/findAllCategorias';
  public static readonly SAVE_OR_UPDATE_REQUISITO = '/services/requisito/saveOrUpdate';
  public static readonly FIND_ALL_REQUISITOS = '/services/requisito/findAllRequisitosForAdministrativo';
  public static readonly FIND_ALL_VENCIMIENTOS = '/services/vencimiento/findAllForVencimientos';

}
