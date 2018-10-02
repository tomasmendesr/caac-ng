import MainConstants from "./constants/main-constants";
declare var $: any;
export class SidebarUtils {

  private static hideSidebar(){
    if(!this.sidebarIsClose()) $('#HeaderSidebarToggleButton').click();
    $("#HeaderSidebarToggleButton").hide();
  }

  private static showSidebar(){
    if(this.sidebarIsClose()) $('#HeaderSidebarToggleButton').click();
    $("#HeaderSidebarToggleButton").show();
  }

  static handleSidebar(currentUrl: string){
    if(currentUrl.indexOf(MainConstants.SIGESE) == -1) {
      this.hideSidebar();
    }else{
      this.showSidebar();
    }
  }

  private static sidebarIsClose(): boolean{
    return $("#Dashboard").hasClass("-sidebar-closed-desktop") || !$("#Dashboard").hasClass("-sidebar-open-mobile");
  }
}
