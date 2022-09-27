package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_농작물수확하기_2805 {

	static int T,N;
	static int[][] map;
	
	public static void main(String[] args) throws Exception{		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {	
				String empty = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] =empty.charAt(j) - '0';
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
				}
			}

			
		}
	}
}
