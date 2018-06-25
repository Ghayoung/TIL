package core;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.security.spec.ECGenParameterSpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import util.EC;

public class BlockChainStarter {
	
  public static void main(String[] args) throws Exception {
	  
	  //�ٿ�� ĳ���� ��ȣȭ ���̺귯���� ����ϵ��� �����մϴ�.
	  Security.addProvider(new BouncyCastleProvider());
	  
	  //Ÿ�� � ��ü�� ������ ����Ű�� ����Ű�� ���� private.pem, public.pem���� �����մϴ�.
	  EC ec = new EC();
	  ec.generate("private.pem", "public.pem");
	  
  }

}