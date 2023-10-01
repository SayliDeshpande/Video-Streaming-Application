package com.videostreamingapp.youtubeclone.model;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("User")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String fullName;
	private String emailAddress;
	private Set<String> susbscribedToUsers;
	private Set<String> subscribers;
	private List<String> videoHistory;
	private Set<String> likedVideos;
	private Set<String> disLikedVideos;

}
