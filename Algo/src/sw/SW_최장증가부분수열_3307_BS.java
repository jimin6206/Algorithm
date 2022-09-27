package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
1 3 2 5 4 
 */

public class SW_최장증가부분수열_3307_BS {

	static int T, N, len=0;
	static int[] input;
	static int[] memoi;  //LIT X // 부분 수열의 길이별로 가장 작은 값이 저장된다.
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			len=0;
			N = Integer.parseInt(br.readLine());
			input = new int[N];
			memoi = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				int pos = Arrays.binarySearch(memoi, 0,len,input[i]);
				pos = Math.abs(pos) - 1;
				memoi[pos] = input[i];
				if(len == pos) len++;
			}
			
			System.out.println("#" + t + " " + len);
			
		}
	}

}
