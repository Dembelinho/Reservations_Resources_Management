import {Component, OnInit} from '@angular/core';
import {KeycloakProfile} from "keycloak-js";
import {KeycloakService} from "keycloak-angular";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'angular-front-app';
  public Profile: KeycloakProfile | null = null;
  public isLoggedIn = false;

  constructor(public keycloakService:KeycloakService) {
  }
  logout() {
    this.keycloakService.logout(window.location.origin)
  }

   login() {
    this.keycloakService.login();
  }

  public async ngOnInit(): Promise<void> {

    this.isLoggedIn = await this.keycloakService.isLoggedIn();

    if (this.isLoggedIn) {
      this.Profile = await this.keycloakService.loadUserProfile();
    }
  }

  profile() {
    window.location.href="http://localhost:8080/realms/sdia-realm/account/#/personal-info";
  }
}
