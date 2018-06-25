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

		/*
		 * //�ٿ�� ĳ���� ��ȣȭ ���̺귯���� ����ϵ��� �����մϴ�. Security.addProvider(new
		 * BouncyCastleProvider());
		 * 
		 * //Ÿ�� � ��ü�� ������ ����Ű�� ����Ű�� ���� private.pem, public.pem���� �����մϴ�. EC ec =
		 * new EC(); ec.generate("private.pem", "public.pem");
		 * 
		 * //���Ϸ� ������ ����Ű�� ����Ű�� �ٽ� ���α׷����� �ҷ��ɴϴ�. PrivateKey privateKey =
		 * ec.readPrivateKeyFromPemFile("private.pem"); PublicKey publicKey =
		 * ec.readPublicKeyFromPemFile("public.pem");
		 */

		Security.addProvider(new BouncyCastleProvider());
		EC ec = new EC();

		//�� �� ���� Ű�� ������ ���� ���·� �����մϴ�.
		ec.generate("private1.pem", "public1.pem");
		ec.generate("private2.pem", "public2.pem");

		//���� ���·� ������ Ű �����͸� ���α׷����� �ҷ��ɴϴ�.
		PrivateKey privateKey1 = ec.readPrivateKeyFromPemFile("private1.pem");
		PublicKey publicKey1 = ec.readPublicKeyFromPemFile("public1.pem");
		PrivateKey privateKey2 = ec.readPrivateKeyFromPemFile("private2.pem");
		PublicKey publicKey2 = ec.readPublicKeyFromPemFile("public2.pem");

		Signature ecdsa;
		ecdsa = Signature.getInstance("SHA1withECDSA");
		//����Ű 1�� �̿��� ��ȣȭ(����)�մϴ�.
		ecdsa.initSign(privateKey1);

		String text = "���Դϴ�.";
		System.out.println("�� ����: " + text);
		byte[] baText = text.getBytes("UTF-8");

		//�� �����͸� ��ȣȭ�Ͽ� ������ �����͸� ����մϴ�.
		ecdsa.update(baText);
		byte[] baSignature = ecdsa.sign();
		System.out.println("����� ��: 0x" + (new BigInteger(1, baSignature).toString(16)).toUpperCase());

		Signature signature;
		signature = Signature.getInstance("SHA1withECDSA");

		//������ ���� ����Ű 2�� �̿��� ��ȣȭ�� �����մϴ�.
		signature.initVerify(publicKey2);
		signature.update(baText);
		boolean result = signature.verify(baSignature);

		//����Ű�� ��Ī�Ǵ� ����Ű�� �ƴϹǷ� ��ȣȭ�� �����մϴ�.
		System.out.println("�ſ� ����: " + result);

	}

}