import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UploadVideoReponse } from './upload-video/UploadVideoResponse';
import {VideoDto} from "./video-dto";


@Injectable({
  providedIn: 'root'
})
export class VideoService {

  constructor(private httpClient : HttpClient) { }
  
  uploadVideo(fileEntry : File) : Observable<UploadVideoReponse>{
	  
	  //Http host call to upload a video
	   const formData = new FormData()
           formData.append('file', fileEntry, fileEntry.name)
           
	  return this.httpClient.post<UploadVideoReponse>("http://localhost:8080/api/videos/", formData);
	  
	  
  }
  
  uploadThumbnail(fileEntry: File, videoId: string) : Observable<String>{
	  
	  //Http host call to upload a video
	   const formData = new FormData()
           formData.append('file', fileEntry, fileEntry.name);
           formData.append('videoId', videoId);
           
	  return this.httpClient.post("http://localhost:8080/api/videos/thumbnail", formData,{
		  responseType:'text'
	  });
  }
  
   getVideo(videoId: string): Observable<VideoDto> {
    return this.httpClient.get<VideoDto>("http://localhost:8080/api/videos/" + videoId);
  }
}