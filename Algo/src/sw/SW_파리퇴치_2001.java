package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_파리퇴치_2001 {
	
	static int T,N,M;
	static int map[][];

	public static void main(String[] args) throws Exception {
		//테케 수 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		//테케만큼 반복
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer( br.readLine() );
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];

			//입력 
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer( br.readLine() );
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int sum=0;
			int max_sum=0;
;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i >=0 && i <= N-M && j >=0 && j<= N-M ) {   //파리채가 들어가도 되는 구역인지 확인
						sum=0;                                     //가능 구역이면 MxM만큼 반복해서 합
						for (int y = 0; y < M; y++) {
							for (int x = 0; x < M; x++) {
								sum += map[i+y][j+x];
							}
						}
						if(sum > max_sum) {   // 가장 큰 sum 찾기
							max_sum = sum;
						}
					}
					
				}
			}
			//출력
			System.out.println("#" + t + " " + max_sum);
		}

	}

}
