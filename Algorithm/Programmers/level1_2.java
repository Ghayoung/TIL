class Solution {
  public String solution(int a, int b) {
      int cnt = count(a, b);
      String answer = day(cnt);
      return answer;
  }
    public int count(int a, int b) {
        int cnt = 0;
        if(a >= 1) cnt += 0;
        if(a >= 2) cnt += 31;
        if(a >= 3) cnt += 29;
        if(a >= 4) cnt += 31;
        if(a >= 5) cnt += 30;
        if(a >= 6) cnt += 31;
        if(a >= 7) cnt += 30;
        if(a >= 8) cnt += 31;
        if(a >= 9) cnt += 31;
        if(a >= 10) cnt += 30;
        if(a >= 11) cnt += 31;
        if(a >= 12) cnt += 30;
      
        return cnt + b;
    }
    
    public String day(int cnt) {
        int n = cnt%7;
        switch(n) {
            case 0:
                return "THU";
            case 1:
                return "FRI";
            case 2:
                return "SAT";
            case 3:
                return "SUN";
            case 4:
                return "MON";
            case 5:
                return "TUE";
            case 6:
                return "WED";
            default:
                return "ERROR";
        }
    }
}