package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1로만들기_1463 {
	
	static int N;
	static int[] dp =  new int[1000001]; //N의 최대값만큼 할당
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());  //N입력받기
		
		dp[1]=0;  //1은 이미 1이므로 연산횟수 0
		dp[2]=1;  //2를 2로 나누면 1이므로 연산횟수1
		dp[3]=1;  //3을 3으로 나우면 1이므로 연산횟수1
		
		//4부터는 앞의 dp배열로 구할 수 있다.
		for (int i = 4; i <= N; i++) {
			int min=Integer.MAX_VALUE;  //min의 초기값을 매우 큰수로 놓는다.
			if(i%3==0) {  //3의 배수이면 우선 min을 dp[i/3]에서 연산횟수 1 추가
				min = dp[i/3] + 1;
				if(i%2==0) {  //3의 배수이면서 2의 배수이면 두개를 비교해서 작은값 저장
					min = Math.min(min, dp[i/2]+1);
				}
			}else if(i%2==0) {  //3의배수가 아니고 2의 배수이면 min에 dp[i/2]에서 연산횟수 1추가
				min = dp[i/2]+1;
			}
			
			//1을 빼는 연산도 있기때문에 dp[i-1]에서 연산횟수를 1더한 거랑 마지막 비교
			dp[i] = Math.min(min, dp[i-1]+1);	
		}

		//결과 출력
		System.out.println(dp[N]);
	}
}
