/*
 * 2018-11-11 Sun
 * Level2 - 가장 큰 정사각형 찾기 
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
 * 입력 board : {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}
 * 출력 : 9
 * 
 * ex2)
 * 입력 board : {{0,0,1,1},{1,1,1,1}}
 * 출력 : 4
 * 
 */

package Programmers.Level2;

public class LargestLectangle {
	public static int solution(int[][] board) {
		// dp 배열 만들기
		int[][] dp = new int[1001][1001];
//		int[][] dp = new int[10][10];
		int ans = 0;	// 정답 변수
		
		// 제일 끝 모서리가 1이 아닐 때, 다른 좌표의 최소 정사각형 수에서 1을 더해줌
		for(int i = 1; i <= board.length; i++) {
			for(int j = 1; j <= board[0].length; j++) {
				if(board[i-1][j-1] != 0) {
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1; 
					ans = Math.max(ans, dp[i][j]);
				}
			}
		}
		
//		for(int i = 0; i < board.length; i++) {
//			for(int j = 0; j < board[i].length; j++) {
//				System.out.print(board[i][j] + "\t");
//			}
//			System.out.println();
//		}
//		System.out.println("========================================");
//		for(int i = 0; i < dp.length; i++) {
//			for(int j = 0; j < dp[i].length; j++) {
//				System.out.print(dp[i][j] + "\t");
//			}
//			System.out.println();
//		}

		return ans * ans;
	}

	public static void main(String[] args) {
		int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		System.out.println(solution(board));
	}

}
