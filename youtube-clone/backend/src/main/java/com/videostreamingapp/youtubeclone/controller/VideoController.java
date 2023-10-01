package com.videostreamingapp.youtubeclone.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.videostreamingapp.youtubeclone.dto.UploadVideoResponse;
import com.videostreamingapp.youtubeclone.dto.VideoDto;
import com.videostreamingapp.youtubeclone.service.VideoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/videos")
@RequiredArgsConstructor
public class VideoController {
	
	private final VideoService videoService;
	// this is for upload video
	@PostMapping (consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public UploadVideoResponse uoloadVideo(@RequestParam("file") MultipartFile file) {
		return videoService.uoloadVideo(file);
	}

	// to edit video metadata, update existing resource
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public VideoDto editVideoMetadata(@RequestBody VideoDto videoDto){
		return videoService.editVideo(videoDto);
	}
	
	// upload thumbnail
	
	@PostMapping (value = "/thumbnail", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public String uoloadThumbnail(@RequestParam("file") MultipartFile file, @RequestParam("videoId") String videoId) {
		return videoService.uoloadThumbnail(file, videoId);
	}
	
	@GetMapping("/{videoId}")
    @ResponseStatus(HttpStatus.OK)
    public VideoDto getVideoDetails(@PathVariable String videoId) {
        return videoService.getVideoDetails(videoId);
    }

}
