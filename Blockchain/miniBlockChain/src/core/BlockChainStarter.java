/*������ �Է� ���� ���ؼ� SHA-256�� ������ ��� ���� �տ������� 6�ڸ���ŭ ��� ���� ��0������ �����Ǿ��ִ��� �����,
���� 6�ڸ��� ��� ��0������ �����Ǿ� �ִٸ� ������ ã�Ҵٰ� ����Ѵ�.*/

package core;

import util.Util;

public class BlockChainStarter {
	
  public static void main(String[] args) {

	  int nonce = 0;

	    while(true) {

	      if(Util.getHash(nonce + "").substring(0, 6).equals("000000")) {

	        System.out.println("����: " + nonce);

	        break;

	      }

	      nonce++;

	    }

  }

}