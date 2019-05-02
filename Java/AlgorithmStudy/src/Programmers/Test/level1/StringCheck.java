package Programmers.Test.level1;

public class StringCheck {
	public static boolean solution(String s) {
	      boolean answer = true;
	      int a;
	      
	      // 문자열의 길이가 4 또는 6이라면
	      if(s.length() == 4 || s.length() == 6) {
	    	  try {
				a = Integer.parseInt(s);
			} catch (Exception e) {
				return false;
			}
	    	  return true;
	      } else {
	    	  return false;
	      }
	      
	  }

	public static void main(String[] args) {
		System.out.println(solution("a234"));
		System.out.println(solution("1234"));
	}

}
