package core;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.ECGenParameterSpec;

public class BlockChainStarter {
	
  public static void main(String[] args) throws Exception {
	  
	  //�������� ����Ű�� ����Ű�� �����ϱ� ���� Ű ���� ��ü�� �����մϴ�.
	  KeyPairGenerator kpg;
	  kpg = KeyPairGenerator.getInstance("EC", "SunEC");
	  
	  //Ÿ�� � ������ ���� �˰��� ��ü�� �����մϴ�.
	  ECGenParameterSpec ecsp;
	  //���� �˰��� ������ �����մϴ�.
	  ecsp = new ECGenParameterSpec("sect163k1");
	  //�������� ������ Ű�� �����մϴ�.
	  kpg.initialize(ecsp, new SecureRandom());
	  
	  //����Ű�� ����Ű �� ���� �����մϴ�.
	  KeyPair kp = kpg.genKeyPair();
	  PrivateKey privKey = kp.getPrivate();
	  PublicKey pubKey = kp.getPublic();
	  
	  //���� ��ü�� ������ ����Ű�� �����մϴ�.
	  Signature ecdsa;
	  ecdsa = Signature.getInstance("SHA1withECDSA", "SunEC");
	  ecdsa.initSign(privKey);
	  
	  //������ ���� ������ �����մϴ�.
	  String text = "�Ͽ��̰� ȫ���̿��� 100 ���� ����";
	  System.out.println("���� ����: " + text);
	  
	  //���� ���忡 ���� ��ȣȭ�� ������ ���� ��(��ȣ��)�� �����ϴ�.
	  ecdsa.update(text.getBytes("UTF-8"));
	  byte[] signatureByte = ecdsa.sign();
	  System.out.println("��ȣ��: 0x" + (new BigInteger(1, signatureByte).toString(16)).toUpperCase());
	  
	  //���� ��ü�� ������ ����Ű�� �̿��� ��ȣȭ�� �� �ֵ��� �����մϴ�.
	  Signature signature;
	  signature = Signature.getInstance("SHA1withECDSA", "SunEC");
	  signature.initVerify(pubKey);
	  
	  //���� ������ ����Ű�� ��ȣȭ�� �����մϴ�.
	  signature.update(text.getBytes("UTF-8"));
	  System.out.println("���� ���� ����: " + signature.verify(signatureByte));
	  
  }

}