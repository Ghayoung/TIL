class Solution {
	public String solution(String s) {
		int i = s.length();
		String answer = "";
		if(i%2 == 0)
			answer = s.substring((i/2)-1, (i/2)+1);
		else
			answer = Character.toString(s.charAt(i/2));
		return answer;
	}
}