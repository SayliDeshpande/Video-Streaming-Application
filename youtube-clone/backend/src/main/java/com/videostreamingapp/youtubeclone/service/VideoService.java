package com.videostreamingapp.youtubeclone.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.videostreamingapp.youtubeclone.dto.UploadVideoResponse;
import com.videostreamingapp.youtubeclone.dto.VideoDto;
import com.videostreamingapp.youtubeclone.model.Video;
import com.videostreamingapp.youtubeclone.repository.VideoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideoService {
	// this method will upload file to AWS S3 
	//and save video data to database
	private final S3Service s3Service;
	private final VideoRepository videoRepository;
	
	public UploadVideoResponse uoloadVideo(MultipartFile multipartFile) {
		String videoUrl = s3Service.uploadFile(multipartFile);
		var video = new Video();
		video.setVideoUrl(videoUrl);
		
		var savedVideo =videoRepository.save(video);
		return new UploadVideoResponse(savedVideo.getId(), savedVideo.getVideoUrl());
		
	}

	public VideoDto editVideo(VideoDto videoDto) {
		// Find the video by VideoId
		
		var savedVideo = getVideoById(videoDto.getId());
		
		// Map new video details from request body i.e videoDto object to old video details, savedVideo
		savedVideo.setTitle(videoDto.getTitle());
		savedVideo.setDescription(videoDto.getDescription());
        savedVideo.setTags(videoDto.getTags());
        savedVideo.setThumbnailUrl(videoDto.getThumbnailUrl());
        savedVideo.setVideoStatus(videoDto.getVideoStatus());
        
        
		// save new video details to database
		videoRepository.save(savedVideo);
		// return this object to controller
		return videoDto;
	}

	Video getVideoById(String videoId) {
		return videoRepository.findById(videoId)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find video by id - " + videoId));
	}

	public String uoloadThumbnail(MultipartFile file, String videoId) {
		var savedVideo = getVideoById(videoId);
		String thumbnailUrl = s3Service.uploadFile(file);
		savedVideo.setThumbnailUrl(thumbnailUrl);
		videoRepository.save(savedVideo);
		return thumbnailUrl;
	}

	public VideoDto getVideoDetails(String videoId) {
        Video savedVideo = getVideoById(videoId);

        //increaseVideoCount(savedVideo);
       // userService.addVideoToHistory(videoId);

        return mapToVideoDto(savedVideo);
    }
//	
//	private void increaseVideoCount(Video savedVideo) {
//        savedVideo.incrementViewCount();
//        videoRepository.save(savedVideo);
//    }
	
	 private VideoDto mapToVideoDto(Video videoById) {
	        VideoDto videoDto = new VideoDto();
	        videoDto.setVideoUrl(videoById.getVideoUrl());
	        videoDto.setThumbnailUrl(videoById.getThumbnailUrl());
	        videoDto.setId(videoById.getId());
	        videoDto.setTitle(videoById.getTitle());
	        videoDto.setDescription(videoById.getDescription());
	        videoDto.setTags(videoById.getTags());
	        videoDto.setVideoStatus(videoById.getVideoStatus());
	       // videoDto.setLikeCount(videoById.getLikes().get());
	       // videoDto.setDislikeCount(videoById.getDisLikes().get());
	        //videoDto.setViewCount(videoById.getViewCount().get());
	        return videoDto;
	    }

}
