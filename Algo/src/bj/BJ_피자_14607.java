package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_피자_14607 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		long N = Long.parseLong(br.readLine());
		
//		int[] dp = new int[N+1];
//		dp[1]=0;
//		
//		for (int i = 1; i <= N; i++) {
//			//홀수
//			int index1 = i/2;
//			if(i%2==1) {
//				int index2 = index1+1;
//				dp[i] = dp[index1] + dp[index2] + index1*index2;
//			}else {  //짝수
//				dp[i] = dp[index1] + dp[index1] + index1*index1;
//			}
//		}
//		
//		System.out.println(dp[(int)N]);
		System.out.println((N*(N-1))/2);  //공식을 써야지만 가능 -> 아니면 메모리초과
	}
}
