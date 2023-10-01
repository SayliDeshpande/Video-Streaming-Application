package com.videostreamingapp.youtubeclone.model;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("Video")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Video {
	@Id
	private String id;
	private String title;
	private String description;
	private String userId;
	private Integer likes;
	private Integer dislikes;
	private Set<String> tags;
	private String videoUrl;
	private VideoStatus videoStatus;
	private Integer viewCount;
	private String thumbnailUrl;
	private List<Comment> comment;

}
