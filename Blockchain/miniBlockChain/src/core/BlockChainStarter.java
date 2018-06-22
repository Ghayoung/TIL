/*임의의 입력 값에 대해서 SHA-256을 적용한 결과 값이 앞에서부터 6자리만큼 모두 문자 ‘0’으로 구성되어있는지 물어보고,
만약 6자리가 모두 ‘0’으로 구성되어 있다면 정답을 찾았다고 출력한다.*/

package core;

import util.Util;

public class BlockChainStarter {
	
  public static void main(String[] args) {
	  
	  Block block = new Block(1, 0, "데이터");
	  block.getInformation();

  }

}