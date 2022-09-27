package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_연속합_1912 {

	static int N, max_result;
	static int[] arr, dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); 
		
		arr = new int[N];  //원래 배열
		dp = new int[N];   //현재까지의 합중 최대값을 담을 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());  //input배열 
		}
		//dp의 첫번째는 무조건 arr의 첫번째 수
		dp[0] = arr[0];
		max_result = dp[0];	//max_result 초기화
		
		for (int i = 1; i < N; i++) { //1부터 시작
			dp[i] = Math.max(arr[i], dp[i-1] + arr[i]); 
			//dp[i]에 dp[i-1]에 arr[i]를 더한값과 현재값부터 시작해도되므로 arr[i]를 비교 -> 큰값을 저장
			max_result = Math.max(max_result, dp[i]); //최대값
		}

		System.out.println(max_result); //결과 출력
	}
}
