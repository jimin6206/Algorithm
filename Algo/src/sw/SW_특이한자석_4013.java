package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_특이한자석_4013 {
	
	static int T, K, ans;
	static int[] score = {1,2,4,8};
	static int[] dir; //자석별 움직임 표시
	static int[][] gear; //자석

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			K = Integer.parseInt(br.readLine());
			gear = new int[4][8];
			ans = 0;
			
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					gear[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//시물레이션 K 만큼 회전
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int id = Integer.parseInt(st.nextToken()) - 1; // 0 based
				int dir = Integer.parseInt(st.nextToken());
				
				//id, dir 을 이용해서 각각의 자석이 어느 방향으로 움직여야 하는지, 혹은 움직이지 않아도 되는지 계산
				check(id, dir);
				//회전
				rotate();
			}
			
			//채점
			for (int i = 0; i < 4; i++) {
				if(gear[i][0] == 1) ans += score[i];
			}
			
			System.out.println("#" + t + " " + ans);
			
		}
	}
	
	static void rotate() {
		for (int i = 0; i < 4; i++) {
			int temp;
			switch( dir[i] ) {
				case  1: // 시계 방향
					temp = gear[i][7];
					for (int j = 7; j > 0; j--) {
						gear[i][j] = gear[i][j-1];
					}
					gear[i][0] = temp;
					break;
				case -1:  // 반시계 방향
					temp = gear[i][0];
					for (int j = 0; j < 7; j++) {
						gear[i][j] = gear[i][j+1];
					}
					gear[i][7] = temp;
					break;
			}
		}
	}
	
	static void check(int id, int d) {
		dir = new int[4];  // 0 으로 초기화
		dir[id] = d;
		
		// 회전할 자석 기준 오른쪽 계산
		for (int i = id+1; i < 4; i++) {
			if(gear[i-1][2] != gear[i][6]) {
				dir[i] = dir[i-1] * (-1);
			}
		}
		//왼쪽 계산
		for (int i = id-1; i >=0; i--) {
			if(gear[i][2] != gear[i+1][6]) {
				dir[i] = dir[i+1] * (-1);
			}
		}
	}
	
}
