import { NgModule } from '@angular/core';
import { AuthModule } from 'angular-auth-oidc-client';


@NgModule({
    imports: [AuthModule.forRoot({
        config: {
            authority: 'https://dev-68p18kj7eccfzuba.us.auth0.com',
            redirectUrl: window.location.origin,
            clientId: 'b49SBq0tYy6mInKaZvFnMu8p1yMq8KHV',
            scope: 'openid profile offline_access',
            responseType: 'code',
            silentRenew: true,
            useRefreshToken: true,
        }
      })],
    exports: [AuthModule],
})
export class AuthConfigModule {}
