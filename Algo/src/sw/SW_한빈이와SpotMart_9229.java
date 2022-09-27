package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_한빈이와SpotMart_9229 {

	static int T,N,M;
	static int[] snack;

	
	public static void main(String[] args) throws Exception{
		
		//테케 수 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			int sum=0;
			int result=-1;
			
			StringTokenizer st = new StringTokenizer( br.readLine() );
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			snack = new int[N];
			
			st = new StringTokenizer( br.readLine() );
			//과자 무게 입력받기
			for (int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			
					
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					
					if(snack[i] + snack[j] <=M) {
						sum = snack[i] + snack[j];
						if(sum > result ) {
							result = sum;
						}
					}
				}
			}

			System.out.println("#" + t +" " + result);	
		}
	}
	
}
