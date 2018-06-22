package core;

import util.Util;

public class Block {
	
	private int blockID; //��� ��ȣ
	private int nonce; //���� ��
	private String data; //������
	private String previousBlockHash; //���� ����� �ؽ� ��
	
	public String getPreviousBlockHash() {
		return previousBlockHash;
	}

	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}

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
	
	public Block(int blockID, int nonce, String data, String previousBlockHash) {
		this.blockID = blockID;
		this.nonce = nonce;
		this.data = data;
		this.previousBlockHash = previousBlockHash;
	}
	
	//���� Ư���� ����� ������ ���� ���
	public void getInformation() {
		System.out.println("--------------------------------------");
		System.out.println("��� ��ȣ: " + getBlockID());
		System.out.println("���� �ؽ�: " + getPreviousBlockHash());
		System.out.println("ä�� ���� ��: " + getNonce());
		System.out.println("��� ������: " + getData());
		System.out.println("��� �ؽ�: " + getBlockHash());
		System.out.println("--------------------------------------");
	}
	
	
	public String getBlockHash() {
		return Util.getHash(nonce + data + previousBlockHash);
	}
	
	public void mine() {
		while(true) {
			if(getBlockHash().substring(0, 4).equals("0000")) {
				System.out.println(blockID + "��° ����� ä���� �����߽��ϴ�.");
				break;
		    }
		    nonce++;
		}
	}

}
