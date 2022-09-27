package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_DFS와BFS_1260 {

	static int N, M, V;
	static boolean[][] matrix;
	static boolean[] visit;
	static Queue<Integer> queue = new ArrayDeque<>();
	static StringBuilder ans = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  //정점의 개수
		M = Integer.parseInt(st.nextToken());  //간선의 개수
		V = Integer.parseInt(st.nextToken());  //탐색을 시작할 정점의 번호
		
		matrix = new boolean[N+1][N+1]; // 0 dummy
		visit = new boolean[N+1];  //방문했는지 확인 배열
		
		//인접행렬 만들기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			matrix[n1][n2] = true;
			matrix[n2][n1] = true;
		}
		//dfs
		visit[V] = true;
		dfs(V);
		
		//visit배열 초기화
		Arrays.fill(visit, false);

		//bfs
		ans.append("\n");
		bfs();
		System.out.println(ans.substring(0,ans.length()-1));

	}
	
	static void dfs(int num) {
		ans.append(num).append(" ");  //해당번호 추가
		
		for (int i = 1; i <= N; i++) {  //인접행렬 확인
			if(!matrix[num][i] || visit[i]) continue;
			visit[i] = true;  //인접한 번호면 true
			dfs(i);  //재귀함수로 구현
			
		}
	}
	
	static void bfs() {
		visit[V] = true;
		queue.offer(V);  //큐를 이용
		
		while(!queue.isEmpty()) {  //큐가 빌때까지 반복
			int num = queue.poll();
			ans.append(num).append(" "); //큐의 첫번째노드빼서 추기	

			for (int i = 1; i <= N; i++) {  //입접행렬 확인
				if(!matrix[num][i] || visit[i]) continue;
				visit[i] = true;
				queue.offer(i);  //큐에 추가
				
			}
		}
	}
}
