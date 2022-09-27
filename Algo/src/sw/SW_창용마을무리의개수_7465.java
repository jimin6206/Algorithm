package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_창용마을무리의개수_7465 {

	static int T, N, M, cnt=0;
	static int[][] graph;
	static boolean[] visit;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		T = Integer.parseInt(br.readLine());  //테케 수 입력받기
		
		//테케만큼 반복
		for (int t = 1; t <= T; t++) {
			cnt=0;   //cnt 초기화
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  //사람의 수
			M = Integer.parseInt(st.nextToken());  //간선의 수
			
			graph = new int[N+1][N+1];  //인접배열
			visit = new boolean[N+1];   //방문배열
			
			//입접배열 만들기
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph[x][y] = 1;
				graph[y][x] = 1;
			}
			
			//1번부터 N번까지 무리 확인
			for (int i = 1; i <= N; i++) {
				if(!visit[i]) {  //방문하지않은 노드이면  -> bfs(i)
					cnt++;    //bfs함수를 몇번 호출하는지 count -> 무리 개수
					bfs(i);   //bfs(i) 함수를 사용하면 i 노드랑 연결된 노드들은 모두 visit이 true가 됨
				}
			}	
			//결과 출력
			System.out.println("#" + t + " " + cnt);
		}
	}
	
	static void bfs(int n) {
		queue.add(n);  //처음노드를 큐에 넣고
		visit[n] = true;  //visit을 true
		
		//큐가 빌때까지 반복
		while(!queue.isEmpty()) {
			int num = queue.remove();  //num = 큐의 첫번째노드
			
			for (int i = 1; i <= N; i++) {
				if(graph[num][i]==1 && !visit[i] ) { //num과 연결되어있는 사람들 모두 큐에 담기
					queue.add(i);
					visit[i] = true;    //visit을 true -> 한번 방문한 사람은 재방문X
				}
			}
		}
	}
}
