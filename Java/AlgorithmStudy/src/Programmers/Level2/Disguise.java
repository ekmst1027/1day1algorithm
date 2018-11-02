/*
 * 2018-10-23 Tue
 * Level2 - 위장(HASH)
 * 
 * - 문제정의 -  
 * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
 * 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 
 * 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 
 * 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 *
 *  
 * - 제한사항 - 
 * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
 * 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
 * 같은 이름을 가진 의상은 존재하지 않습니다.
 * clothes의 모든 원소는 문자열로 이루어져 있습니다.
 * 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
 * 스파이는 하루에 최소 한 개의 의상은 입습니다.
 * 
 * ex1) 
 * 입력 clothes : {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
 * 출력 : 5;
 * 
 * ex2) 
 * 입력 clothes : {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}
 * 출력 : 3;
 * 
 */

package Programmers.Level2;

import java.util.Arrays;
import java.util.HashMap;

public class Disguise {
	static int[] visited;
	
	public static int btr(int index, int[] clothArr, int count, int result) {
		if(index == count) {
			System.out.println("visited : " + Arrays.toString(visited));
			System.out.println("result : " + result);
			return result;
		}
		
		for(int i = 0; i < clothArr.length; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				result *= clothArr[i];
				btr(index, clothArr, count, result);
				result /= clothArr[i];
				visited[i] = 0;
			}
		}
		
		return 0;
	}
	
	public static int fact(int n) {
		int result = 1;
		for(int i = n; i > 0; i--) {
			result *= i;
		}
		return result;
	}
	
	public static int solution(String[][] clothes) {
		HashMap<String, Integer> cloth = new HashMap<String, Integer>();
		
		for(int i = 0; i < clothes.length; i++) {
			if(cloth.containsKey(clothes[i][1])) {
				cloth.put(clothes[i][1], cloth.get(clothes[i][1]) + 1);
			} else {
				cloth.put(clothes[i][1], 1);
			}
		}
		int[] clothArr = new int[cloth.size()];
		visited = new int[cloth.size()];
		
		// 조합이 1일 경우
		int sum = 0;
		int idx = 0;
		for(String key : cloth.keySet()) {
			System.out.println("Key : " + key);
			System.out.println("Value : " + cloth.get(key));
			clothArr[idx++] = cloth.get(key);
			sum += cloth.get(key);			
		}
		
		for(int i = 0; i < clothArr.length; i++) {
			clothArr[i] = fact(clothArr[i]);
		}
		
		System.out.println("cloth.size : " + cloth.size());
		
		if(cloth.size() >= 2) {
			for(int i = 1; i < cloth.size(); i++) {
				System.out.println("포문안에 들어옴");
				int result = 1;
				sum += btr(i, clothArr, 0, result);
				System.out.println("sum : " + sum);
			}
		} else {
			return sum;
		}
		
//		
//		System.out.println("더한 후 sum : " + sum);
//		
//		int mul = 0;
//		if(count > 1) {
//			mul = 1;
//			for(String key : cloth.keySet()) {
//				mul *= cloth.get(key);
//			}
//		}
//		sum += mul;
		System.out.println("곱하기까지 더하고 sum : " + sum);
		
        return 0;
    }

	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(clothes));
		System.out.println("=======================================================");
		String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		System.out.println(solution(clothes2));
	}

}
