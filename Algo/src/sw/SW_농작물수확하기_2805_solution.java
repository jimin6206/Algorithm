package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_농작물수확하기_2805_solution {

	static int T,N;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {	
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp[j] - '0';
				}
			}
			
			int sum = 0;  //합
			int wide = 0;
			int half = N/2;  //  5/2 = 2 (가운데 index)
			int startX, endX;  // 가로  수확 시작과 끝
			
			for (int i = 0; i < N; i++) {
				startX = half - wide;
				endX = half + wide;
				
				for (int j = startX; j <= endX; j++) {
					sum += map[i][j];
				}
				
				//wide 조정
				if(i < half) { //반을 지나지않았음
					wide++;
				}else {
					wide--;
				}
			}
			
			//출력
			System.out.println("#" + t + " " + sum);
	
		}
	}
}
