package Programmers.Winter2018;
/*
 * 2018-10-27 Sat
 * 코딩테스트 - 쿠키
 * 
 * - 문제정의 -  
 * 철수 씨는 쿠키 가게에서 두 아들에게 줄 쿠키를 사기로 했습니다. 
 * 가게의 긴 선반에는 여러 개의 바구니가 있고, 각각의 바구니 안에는 같은 종류의 쿠키들이 들어 있습니다. 
 * 서로 다른 바구니 안에 들어있는 쿠키들은 서로 다른 종류이며 개수도 제각각입니다. 
 * 가게는 쿠키를 바구니 단위로 판매하고 있습니다.
 * 철수 씨는 몇 개의 쿠키 바구니를 구매하여 두 아들이 같은 수의 쿠키를 받을 수 있도록 바구니를 나눠주고 싶습니다. 
 * 또한, 두 아들에게 최대한 비슷한 모양의 쿠키를 주고 싶습니다. 
 * 다행히 가게는 담겨있는 바구니의 위치가 가까울수록 쿠키가 비슷한 모양이도록 진열을 해놨습니다.
 * 각각의 바구니는 1번부터 N번 까지의 번호가 붙어있었기 때문에 
 * 철수 씨는 첫째 아들에게 사줄 쿠키들의 바구니 번호가 l번부터 m번 까지라면 
 * 둘째 아들에게 사줄 쿠키들의 바구니 번호는 m+1번부터 r번까지가 되도록 쿠키를 사려 합니다(1 <= l <= m, m+1 <= r <= N). 
 * 물론 두 아들에게 주는 쿠키 개수의 합이 같아야 합니다. 
 * 즉, A[i] 를 i번 바구니에 들어있는 쿠키의 개수라고 했을 때, 
 * 첫째 아들에게 l번부터 m번까지의 쿠키를 주고, 
 * 둘째 아들에게 m+1번부터 r번까지의 쿠키를 준다면, 
 * 'A[l]+..+A[m] = A[m+1]+..+A[r]' 를 만족해야 합니다.
 * N개의 쿠키 바구니 안에 들어있는 쿠키의 개수에 대한 정보가 담긴 배열 cookie가 주어질 때, 
 * 조건에 맞게 쿠키를 살 경우 한 명의 아들에게 줄 수 있는 가장 많은 쿠키의 수를 return 하는 solution 함수를 완성해주세요. 
 * (단, 조건에 맞게 쿠키를 구매할 수 없다면 0을 return 합니다)
 *
 *  
 * - 제한사항 - 
 * cookie의 길이는 1이상 2,000이하입니다.
 * cookie의 각각의 원소들은 1이상 500이하의 자연수입니다.
 * 
 * ex1) 
 * 입력 cookie : {1,1,2,3};
 * 출력 : 3;
 * 
 * ex2) 
 * 입력 cookie : {1,2,4,5};
 * 출력 : 0;
 * 
 */
public class Test2 {
	public static int solution(int[] cookie) {
        int answer = -1;
        
        int sumI = 0;
        int sumJ = 0;
        for(int i = 0; i < cookie.length; i++) {
        	System.out.println("i : " + i);
        	sumI += cookie[i];
        	System.out.println("sumI : " + sumI);
        	for(int j = i+1; j < cookie.length; j++) {
        		System.out.println("j : " + j);
        		sumJ += cookie[j];
        		System.out.println("sumJ : " + sumJ);
        		if(sumI == sumJ) {
        			System.out.println("max : " + sumI);
        		}
        	}
        	System.out.println("====================");
        }
        
        return answer;
    }
	

	public static void main(String[] args) {
		int[] cookie = {1,1,2,3};
		System.out.println(solution(cookie));

	}

}
