/*
 * 2018-10-07 Sun
 * Part1 - 논리구현 
 * 
 * 문제 : 영어 대소문자와 띄어쓰기만으로 이루어진 문장이 주어진다. 이 문장에는 몇 개의 단어가 있을까? 
 * 		이를 구하는 프로그램을 작성하시오.
 * 
 * 입력 : 첫 줄에 영어 대소문자와 띄어쓰기로 이루어진 문장이 주어진다. 
 * 		이 문장의 길이는 1,000,000을 넘지 않는다. 단어는 띄어쓰기 한 개로 구분되며, 
 * 		공백이 연속해서 나오는 경우는 없다.
 * 
 * 출력 : 첫째 줄에 단어의 갯수를 출력한다. 
 * 
 * ex) 입력 : The Curious Case of Benjamin Button
 *     출력 : 6
 *     
 *     입력 :  Mazatneunde Wae Teullyeoyo
 *     출력 : 3 (맨 앞에 띄어쓰기 주의)
 * 
 */

package Programmers.Learnit.Part1;

import java.util.Scanner;

public class WordsCount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력부 
		String inputString = sc.nextLine();
		
		// 입력받은 문장을 공백으로 스플릿해서 배열에 저장 
		String printStrings[];
		printStrings = inputString.split(" ");
		int index = 0; // 단어의 갯수
		
		// 공백이 아닌 단어의 수 계산
		for(String printString : printStrings) {
			if(!printString.equals("")) {				
				index++;
			}
		}
		System.out.println(index);
		
	}

}
