package com.videostreamingapp.youtubeclone.service;

import java.io.IOException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class S3Service implements FileService{
	public static final String BUCKET_NAME = "myyoutubeclonerepo"; 
	private final AmazonS3Client awsS3Client;
	
	@Override
	public String uploadFile(MultipartFile file) {
		
		//logic to upload file to AWS s3
		
		
		
		//prepare the key 
		
		var filenameExtnesion = StringUtils.getFilenameExtension(file.getOriginalFilename());
		var key = UUID.randomUUID().toString() + "." + filenameExtnesion;
		
		var metadata = new ObjectMetadata();
		metadata.setContentLength(file.getSize());
		metadata.setContentType(file.getContentType());
		
		try {
			awsS3Client.putObject(BUCKET_NAME, key, file.getInputStream(), metadata);
		} catch (IOException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception from AWS Service");
		}
		awsS3Client.setObjectAcl(BUCKET_NAME, key, CannedAccessControlList.PublicRead );
		
		return awsS3Client.getResourceUrl(BUCKET_NAME, key);
	
	}

}
