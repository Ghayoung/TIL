/*�� �ҽ��ڵ�� ��� ��ȣ�� ��1���̰�, ���� ���� ��0���̸� ����� �����ϰ� �ִ� �����Ͱ� �������͡��� �ϳ��� ����� ������ �ڿ�
�� ��Ͽ� ���� ������ ����Ѵ�.*/

package core;

public class BlockChainStarter {
	
  public static void main(String[] args) {
	  
	  Block block = new Block(1, 0, "�ٲ� ������");
	  block.mine();
	  block.getInformation();

  }

}