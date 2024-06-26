import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UploadVideoComponent } from './upload-video/upload-video.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule} from "@angular/common/http";
import { NgxFileDropModule} from "ngx-file-drop";
import { HeaderComponent } from './header/header.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { SaveVideoDetailsComponent } from './save-video-details/save-video-details.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatOptionModule} from "@angular/material/core";
import {MatChipsModule} from "@angular/material/chips";
import {VgCoreModule} from '@videogular/ngx-videogular/core';
import {VgControlsModule} from '@videogular/ngx-videogular/controls';
import {VgOverlayPlayModule} from '@videogular/ngx-videogular/overlay-play';
import {VgBufferingModule} from '@videogular/ngx-videogular/buffering';
import {MatSnackBarModule} from "@angular/material/snack-bar";
import { VideoPlayerComponent } from './video-player/video-player.component';
import { AuthConfigModule } from './auth/auth-config.module';

@NgModule({
  declarations: [
    AppComponent,
    UploadVideoComponent,
    HeaderComponent,
    SaveVideoDetailsComponent,
    VideoPlayerComponent,
    
  ],
  imports: [
	  BrowserModule,
	  AppRoutingModule,
	  BrowserAnimationsModule,
	  FormsModule,
	  HttpClientModule,
	  NgxFileDropModule,
	  MatToolbarModule,
	  MatIconModule,
	  FlexLayoutModule,
	  MatFormFieldModule,
	  MatInputModule,
	  MatSelectModule,
	  MatOptionModule,
	  ReactiveFormsModule,
	  MatChipsModule,
	  BrowserModule,
	  VgCoreModule,
	  VgControlsModule,
	  VgOverlayPlayModule,
	  VgBufferingModule,
	  MatSnackBarModule,
   AuthConfigModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
