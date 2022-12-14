package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_외판원순회_2098 {

	static int N;
	static int[][] matrix;
	static int[][] memoi;
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		matrix = new int[N][N];
		memoi = new int[N][ (1 << N) - 1 ];
		// N == 4
		// 10000 => 1111
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(memoi[i], INF);
		}
		
		System.out.println(dfs(0,1));
	}
	
	//city : 현재 방문하는 도시
	//mask : 방문한 도시 기록
	//리턴 : 현재 방문한 도시 이후(남아있는) 도시를 방문했을 때의 최소비용 ( 돌아가는 것 포함 ) 리턴
	static int dfs(int city, int mask) {
		//기저조건
		if(mask == (1<<N) - 1) {
			if(matrix[city][0] == 0 ) return INF;
			return matrix[city][0];
		}
		//이미 계산된 최소 비용
		if(memoi[city][mask] != INF) return memoi[city][mask];
		
		for (int i = 0; i < N; i++) {
			//이미 방문한 도시, 비용 체크
			if( (mask & (1<<i)) != 0 || matrix[city][i] == 0 ) continue; 	
			memoi[city][mask] = Math.min(memoi[city][mask], matrix[city][i] + dfs(i, mask | (1<<i)));
		}
		return memoi[city][mask]; //현재 남은 도시를 방문하고 돌아가는 모든 비용의 최소값이 계산되어진다.
	}
}
