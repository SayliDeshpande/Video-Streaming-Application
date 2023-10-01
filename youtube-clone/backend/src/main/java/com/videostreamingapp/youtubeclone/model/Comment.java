package com.videostreamingapp.youtubeclone.model;



import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Comment {
	
	@Id
	private String id;
	private String text;
	private String authorId;
	private Integer likeCount;
	private Integer dislikeCount;

}
