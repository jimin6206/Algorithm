package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_과일서리_17213 {

	static int N, M;
	static int result;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		result = func1(N-1, M-N);
		
		System.out.println(result);
		
	}
	
	static int func1(int n, int r) {
		
		if(n==r || r==0 || n==0) {
			return 1;
		}
		
		else {
			// nHr 구하는 공식
			int[] fac = new int[n+r+1];

			fac[1] = 1;
			for (int i = 2; i <= (n+r); i++) {
				fac[i] = fac[i-1]*i;
			}
			
			int a = fac[n+r];  //분자
			int b = fac[n] * fac[r];           //분모
			int C = a/b;
			
			return C;
		}
		
	}
}
