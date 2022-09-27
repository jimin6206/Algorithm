package bj;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_설탕배달_2839_DP {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int result;
		
		int[] dp = new int[N+1]; //N+1개의 배열생성
		Arrays.fill(dp, 5000);   //모두 최댓값으로 초기화
		if(N>=3) dp[3]=1;  //3kg를 만드는데 필요한 봉지 수
		if(N>=5) dp[5]=1;  //5kg를 만드는데 필요한 봉지 수
		
		for (int i = 6; i <= N; i++) { 
			dp[i] = Math.min(dp[i-3] + 1, dp[i-5]+1);  //i-3kg에서 필요한 봉지수 + 3kg 1봉지  OR
			          									//i-5kg에서 필요한 봉지수 + 5kg 1봉지 중 더 적은 봉지수
		}
		
		if(dp[N] >= 5000) result = -1;
		else result = dp[N];
		System.out.println(result);
		sc.close();
	}
}
