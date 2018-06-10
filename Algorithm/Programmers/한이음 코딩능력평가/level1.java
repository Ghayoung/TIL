class Solution {
	public int solution(int n, int m) {
		String str = "";
		boolean b;
		int answer = 0;

		for(int i=n; i<=m; i++) {
			str = Integer.toString(i);
			b = this.compare(str);
			if(b)
				answer++;
		}

		return answer;
	}

	public boolean compare(String str) {
		int i = 0;
		int j = str.length()-1;
		while(i<j) {
			if(str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}