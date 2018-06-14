package com.s3test.object;

//AWS 접속을 위한 설정을 해주는 클래스
public class AWSClient {

	final private String accessKey = "accessKey";
	final private String secretKey = "secretKey";
	final private String bucket = "bucket";
	final private String region = "region";

	public String getAccessKey() {
		return accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public String getBucket() {
		return bucket;
	}

	public String getRegion() {
		return region;
	}

}