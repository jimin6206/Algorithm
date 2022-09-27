package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_연결요소의개수_11724 {
	static int N,M,cnt=0;
	static int[][] graph;    //정점들의 간선 표현
	static boolean[] check;  //정점들 모두 검사했는지 check
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());  //정점의 개수 입력받기
		M = Integer.parseInt(st.nextToken());  //간선의 개수 입력받기
		graph = new int[N+1][N+1];  //N x N배열 (0인덱스는 신경안쓸거임)
		check = new boolean[N+1];   //N개의 정점 표현
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			graph[n1][n2] = 1;  //연결된 정점들끼리 1로 표현
			graph[n2][n1] = 1;
		}
		//N개의 정점들 중 check 안된 정점들만 bfs호출
		for (int i = 1; i <= N; i++) {
			if(check[i]) continue;
			cnt++;
			bfs(i);		 //bfs() 호출하면 연결된 정점들을 모두 check시켜주기 때문에 bfs()호출할때마다 cnt+1
		}	
		System.out.println(cnt);  //결과출력
	}
	
	static void bfs(int i) {
		queue.add(i); //정점 추가
		check[i] = true; //추가된 정점 체크
		while(!queue.isEmpty()) {  //큐가 빌때까지 반복
			int num = queue.remove();  //큐의 첫번째 정점 삭제
			for (int j = 1; j <= N; j++) {
				if(graph[num][j] == 1 && !check[j])  {  //해당 정점과 연결된 정점들 큐에 추가
					queue.add(j);
					check[j] = true;  //큐에 들어가는 정점들은 체크 => 같은 정점 추가방지
				}
			}
		}
	}
}
