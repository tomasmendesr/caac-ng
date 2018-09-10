export class AppResponse {
  static readonly SUCCESS = 200;
  static readonly ERROR = -1;

  code: number;
  message: string;
  data: any;

}
