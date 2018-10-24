/*
 * 2018-10-24 Wed
 * Level2 - 다음 큰 숫자
 * 
 * - 문제정의 -  
 * 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
 * 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
 * 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
 * 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
 * 예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
 * 자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
 *
 *  
 * - 제한사항 - 
 * n은 1,000,000 이하의 자연수 입니다.
 * 
 * ex1) 
 * 입력 : 78
 * 출력 : 83
 * 
 * ex2) 
 * 입력 : 15
 * 출력 : 23
 * 
 */

package Programmers.Level2;

// Integer.toBinaryString()을 이용해서 십진수를 이진수로 변환할 수 있음.
public class NextLargeNumber {
	public static int solution(int n) {
//	      System.out.println(Integer.toBinaryString(n));
		
		// 비교할 숫자(인풋값보다 1 크게 설정)
		int comp = n + 1;
		
		// 인풋숫자를 십진수에서 이진수로 변경
		String nBinary = Integer.toBinaryString(n);
		
		// 십진수 중에서 0을 공백으로 변경
		nBinary = nBinary.replace("0", "");
		
		// 1만 남기 때문에 길이를 세면 1의 갯수가 됨
		int nBinaryLength = nBinary.length();
//	      System.out.println(nBinary);
//	      System.out.println(nBinary.length());
		
		// 비교하는 숫자도 마찬가지로 이진수로 변환한 뒤 0을 제거하여 1의 갯수를 센다.
		// 인풋값의 1의 갯수와 같다면 해당하는 수를 리턴
		while (comp > n) {
			String compBinary = Integer.toBinaryString(comp);
			compBinary = compBinary.replace("0", "");
			int compBinaryLength = compBinary.length();
			if (compBinaryLength == nBinaryLength) {
				return comp;
			}
			comp++;
		}
		return comp;
	}

	public static void main(String[] args) {
		System.out.println(solution(78));
		System.out.println(solution(15));
	}

}
