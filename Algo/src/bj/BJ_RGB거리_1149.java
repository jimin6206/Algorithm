package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_RGB거리_1149 {

	static int N;
	static int[][] house;  //각 집마다 RGB 비용
	static long[][] cost;  
	static long result=0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//0:R  1:G  2:B
		house = new int[N][3];
		cost = new long[N][3];
		//house배열에 RGB비용 넣어주기
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			house[i][0] = Integer.parseInt(st.nextToken());
			house[i][1] = Integer.parseInt(st.nextToken());
			house[i][2] = Integer.parseInt(st.nextToken());
		}
		
		//첫번째 집 비용을 cost에 넣어줌
		for (int i = 0; i < 3; i++) {
			cost[0][i] = house[0][i];
		}
		
		//두번째집부터는 이전의 다른색 cost를 비교해서 작은값에 현재 비용을 더해준다. 
		//cost배열에는 현재까지 최소비용의 합이 저장되어있을것
		for (int i = 1; i < N; i++) {
			cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2]) + house[i][0];
			cost[i][1] = Math.min(cost[i-1][0], cost[i-1][2]) + house[i][1];
			cost[i][2] = Math.min(cost[i-1][0], cost[i-1][1]) + house[i][2];
		}
		
		//마지막 집까지 확인했을때의 최소비용은 result에 저장
		result = Math.min(cost[N-1][0], cost[N-1][1]);
		result = Math.min(result, cost[N-1][2]);
		
		//결과출력
		System.out.println(result);
	}
}
