package com.s3test.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.s3test.object.AWSClient;

@Service
public class S3Uploader {

	AWSClient awsClient = new AWSClient(); //클라이언트 정보를 가져오기 위한 객체

	//현재 시간 + 원본 파일명으로 파일명 지정
	public void upload(MultipartFile file) {
		try {
			String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
			upload(file.getInputStream(), fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//AmazonS3 객체에 파일과 버킷명을 입력하여 파일 업로드
	private void upload(InputStream inputStream, String uploadKey) {
		PutObjectRequest putObjectRequest = new PutObjectRequest(awsClient.getBucket(), uploadKey, inputStream, new ObjectMetadata());
		putObjectRequest.setCannedAcl(CannedAccessControlList.PublicRead);
		AmazonS3 amazonS3 = this.s3Client();
		amazonS3.putObject(putObjectRequest);
		IOUtils.closeQuietly(inputStream);
	}

	//파일 업로드를 위해 accessKey와 secretKey로 AmazonS3 객체 생성
	public AmazonS3 s3Client(){
		System.out.println("s3Client");
		AWSCredentials creds = new BasicAWSCredentials(awsClient.getAccessKey(), awsClient.getSecretKey());
		return AmazonS3ClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(creds))
				.withRegion(awsClient.getRegion())
				.build();
	}

}