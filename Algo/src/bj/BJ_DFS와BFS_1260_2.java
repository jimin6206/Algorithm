package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_DFS와BFS_1260_2 {

	static int N, M, V;
	static boolean[][] matrix;
	static Queue<Integer> queue = new ArrayDeque<>();
	static StringBuilder ans = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		matrix = new boolean[N+1][N+1]; // 0 dummy
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			matrix[n1][n2] = true;
			matrix[n2][n1] = true;
		}
		matrix[V][0] = true;
		dfs(V);
		
		for (int i = 1; i <= N; i++) {
			matrix[i][0] = false;
		}
		ans.append("\n");
		bfs();
		System.out.println(ans.substring(0,ans.length()-1));

	}
	
	static void dfs(int num) {
		ans.append(num).append(" ");
		
		for (int i = 1; i <= N; i++) {
			if(!matrix[num][i] || matrix[i][0]) continue;
			matrix[i][0] = true;
			dfs(i);
			
		}
	}
	
	static void bfs() {
		matrix[V][0] = true;
		queue.offer(V);
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			ans.append(num).append(" ");			

			for (int i = 1; i <= N; i++) {
				if(!matrix[num][i] || matrix[i][0]) continue;
				matrix[i][0] = true;
				queue.offer(i);
				
			}
		}
	}
}
