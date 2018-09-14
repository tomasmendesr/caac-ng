import MainConstants from "./constants/main-constants";
declare var $: any;
export class SidebarUtils {
  private static sidebarIsOpen: boolean = true;

  private static hideSidebar(){
    this.sidebarIsOpen = false;
    $('#HeaderSidebarToggleButton').click();
    $("#HeaderSidebarToggleButton").hide();
  }

  private static showSidebar(){
    this.sidebarIsOpen = true;
    $("#HeaderSidebarToggleButton").show();
    $('#HeaderSidebarToggleButton').click();
  }

  static handleSidebar(currentUrl: string){
    if(currentUrl.indexOf(MainConstants.SIGESE) == -1) {
      if(this.sidebarIsOpen) this.hideSidebar();
    }else{
      if(!this.sidebarIsOpen) this.showSidebar();
    }
  }
}
