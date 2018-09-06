declare var $: any;
export class NotifUtil {
  static notifError(msg: string) {
    $.notify({message: msg}, {type: "danger"});
  }

  static notifSuccess(msg: string) {
    $.notify({message: msg}, {type: "success"});
  }
}
