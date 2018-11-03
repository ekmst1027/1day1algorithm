/*
 * 2018-10-16 Mon
 * 알고리즘 문제해설 - 가장 큰 정사각형
 * 
 * - 문제정의 -  
 * 1와 0로 채워진 표(board)가 있습니다. 
 * 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다. 
 * 표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요. 
 * (단, 정사각형이란 축에 평행한 정사각형을 말합니다.)
 *  
 * - 제한사항 - 
 * 표(board)는 2차원 배열로 주어집니다.
 * 표(board)의 행(row)의 크기 : 1000 이하의 자연수
 * 표(board)의 열(column)의 크기 : 1000 이하의 자연수
 * 표(board)의 값은 1또는 0으로만 이루어져 있습니다.
 * 
 * ex1) 
 * 입력 board : {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
 * 출력 result : 9
 * 
 * ex1) 
 * 입력 board : {{0,0,1,1},{1,1,1,1}};
 * 출력 result : 4
 * 
 * 
 */

package Programmers.ExplanationLecture;

// DP(Dynamic Programming) 문제
public class LargestSquare {
	public static int solution(int [][]board) {
//		for(int i = 0; i < board.length; i++) {
//			for(int j = 0; j < board[i].length; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("==========================");
		// 변수 생성
		int answer = 0;	// 제일 정사각형의 길이
//		int[][] dp = new int[10][10];	// dp 배열(연습용)
		int[][] dp = new int[1001][1001];	// dp 배열
		int row = board.length;	// 행 수
		int col = board[0].length;	// 열 수
		
		// dp적용
		for(int i = 1; i <= row; i++) {
			for(int j = 1; j <= col; j++) {
				// 오른쪽 아래 모서리가 0일 경우에는 정사각형이 될 수 없으므로 0이 아닌 경우만 확인
				if(board[i-1][j-1] != 0) {
					// 오른쪽 아래 모서리 기준으로 가장 가까운 경곗값을 기준으로 정사각형 카운트
					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
					answer = Math.max(answer, dp[i][j]);
				}
			}
		}
		
//		for(int i = 0; i < dp.length; i++) {
//			for(int j = 0; j < dp[i].length; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		
        return answer * answer;
    }

	public static void main(String[] args) {
		int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		System.out.println(solution(board));
		int[][] board2 = {{0,0,1,1},{1,1,1,1}};
		System.out.println(solution(board2));
	}

}
