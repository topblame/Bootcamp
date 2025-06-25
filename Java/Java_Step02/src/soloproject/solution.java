package soloproject;

import java.util.Arrays;

public class solution {
	
	public int solution(int[] mats, String[][] park) {
		int answer = 0;
		int n = park.length; // 세로
		int m = park[0].length; // 가로
		Arrays.sort(mats);
		
		for(int i = mats.length-1; i>=0; i--) { // 가장 큰돗자리. mats.length -1 최대값임. mats.length 범위초과. 배열
			answer = mats[i]; // answer= mats의 크기. 
			for(int row = 0; row <= n- answer; row++) {
				for(int col = 0; col <= m - answer; col++) {
					
					boolean canPlace = true; // answer* answer 의 돗자리를 깔 수 있는지 확인하는 boolean 
					
					for(int r = row; r < row + answer; r++) { //0,0 부터 n- answer 좌표까지 돗자리를 깔 수있는지 탐색하는 영역.
						for(int c = col; c < col + answer; c++) {
							if(!park[r][c].equals("-1")) { //한 칸이라도 -1인게 있으면 깔 수 없음.
								canPlace = false;
								break;
							}
							
						}
						if(!canPlace) break;
					}
					if(canPlace) {
						return answer;
					}
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		
	}

}
