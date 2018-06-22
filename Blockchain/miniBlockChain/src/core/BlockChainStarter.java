/*위 소스코드는 블록 번호가 ‘1’이고, 정답 값이 ‘0’이며 블록이 포함하고 있는 데이터가 ‘데이터’인 하나의 블록을 생성한 뒤에
그 블록에 대한 정보를 출력한다.*/

package core;

public class BlockChainStarter {
	
  public static void main(String[] args) {
	  
	  Block block = new Block(1, 0, "바뀐 데이터");
	  block.mine();
	  block.getInformation();

  }

}