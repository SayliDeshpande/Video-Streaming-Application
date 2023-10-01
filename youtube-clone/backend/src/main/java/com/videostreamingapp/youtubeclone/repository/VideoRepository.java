package com.videostreamingapp.youtubeclone.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.videostreamingapp.youtubeclone.model.Video;

public interface VideoRepository extends MongoRepository<Video, String>{

}
