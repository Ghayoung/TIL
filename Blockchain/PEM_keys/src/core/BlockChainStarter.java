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
	  
	  //바운시 캐슬의 암호화 라이브러리를 사용하도록 설정합니다.
	  Security.addProvider(new BouncyCastleProvider());
	  
	  //타원 곡선 객체를 생성해 개인키와 공개키를 각각 private.pem, public.pem으로 저장합니다.
	  EC ec = new EC();
	  ec.generate("private.pem", "public.pem");
	  
  }

}