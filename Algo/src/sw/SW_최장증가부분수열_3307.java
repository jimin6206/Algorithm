package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_최장증가부분수열_3307 {

	static int T, N, len=0;
	static int[] input;
	static int[] LIS;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			len=0;
			N = Integer.parseInt(br.readLine());
			input = new int[N];
			LIS = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				LIS[i] = 1;
				for (int j = 0; j < i; j++) {
					if(input[j] < input[i]) LIS[i] = Math.max(LIS[i], LIS[j]+1);
				}
				
				len = Math.max(len, LIS[i]);
			}
			
			System.out.println("#" + t + " " + len);
			
		}
	}

}
