package core;

import util.Util;

public class Block {
	
	private int blockID; //블록 번호
	private int nonce; //정답 값
	private String data; //데이터
	
	public int getBlockID() {
		return blockID;
	}
	
	public void setBlockID(int blockID) {
		this.blockID = blockID;
	}
	
	public int getNonce() {
		return nonce;
	}
	
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public Block(int blockID, int nonce, String data) {
		this.blockID = blockID;
		this.nonce = nonce;
		this.data = data;
	}
	
	//현재 특정한 블록이 가지는 정보 출력
	public void getInformation() {
		System.out.println("--------------------------------------");
		System.out.println("블록 번호: " + getBlockID());
		System.out.println("채굴 변수 값: " + getNonce());
		System.out.println("블록 데이터: " + getData());
		System.out.println("블록 해시: " + getBlockHash());
		System.out.println("--------------------------------------");
	}
	
	
	public String getBlockHash() {
		return Util.getHash(nonce + data);
	}

}
