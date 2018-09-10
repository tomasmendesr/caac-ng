import { Component } from '@angular/core';
import {APP_SETTINGS} from "./services/APP_SETTINGS";
import MainConstants from "./constants/main-constants";
declare var $:any;
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'aplicacion';

  ngOnInit(){
  }

  ngAfterViewInit(){
    // this.removeSideBar();
  }

  private removeSideBar() {
    $(".ContentContainer").css('marginLeft', '0px');
    $(".SidebarHeader").css('display','none');
    $("#SidebarFooter").css('display','none');
    $(".SidebarContainer").css({width: 0});
    $(".HeaderContainer").css({top: 0});
    $(".HeaderContainer").css({left: 0});
    $("#HeaderSidebarToggleButton").hide();
  }
  //
  // private addSidebar(){
  //   $(".ContentContainer").css('marginLeft', 'var(--DashboardSidebarWidth)');
  //   $(".SidebarHeader").css('display','block');
  //   $("#SidebarFooter").css('display','block');
  //   $(".SidebarContainer").css('width','var(--DashboardSidebarWidth)');
  //   $(".HeaderContainer").css({top: 0});
  //   $(".HeaderContainer").css('left','var(--DashboardSidebarWidth)');
  //   $("#HeaderSidebarToggleButton").show();
  // }
}
