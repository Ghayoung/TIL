package core;

import util.Util;

public class Block {
	
	private int blockID; //��� ��ȣ
	private int nonce; //���� ��
	private String data; //������
	
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
	
	//���� Ư���� ����� ������ ���� ���
	public void getInformation() {
		System.out.println("--------------------------------------");
		System.out.println("��� ��ȣ: " + getBlockID());
		System.out.println("ä�� ���� ��: " + getNonce());
		System.out.println("��� ������: " + getData());
		System.out.println("��� �ؽ�: " + getBlockHash());
		System.out.println("--------------------------------------");
	}
	
	
	public String getBlockHash() {
		return Util.getHash(nonce + data);
	}

}
