package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_바이러스_2606 {

	static int V,N,cnt=0;
	static int[][] map;
	static boolean[] visit;
	static Queue<Integer> queue = new LinkedList<>(); 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		V = Integer.parseInt(br.readLine());  //컴퓨터의 수
		N = Integer.parseInt(br.readLine());  //간선의 수
		map = new int[V+1][V+1];  //인접배열
		visit = new boolean[V+1];  //방문배열

		//인접배열 만들기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			map[n1][n2] = 1;
			map[n2][n1] = 1;
		}
		
		bfs(); //bfs함수 호출
		System.out.println(cnt);
		
	}
	
	static void bfs() {
		queue.add(1);  //1번컴퓨터부터 시작
		visit[1] = true;

		//큐가 빌때까지 반복
		while(!queue.isEmpty()) {
			int num = queue.remove();  //큐의 첫번째 컴퓨터 꺼냄
			
			//연결된 컴퓨터가 있는 지 확인
			for (int i = 2; i <= V; i++) {
				if(map[num][i] == 0 || visit[i]) continue;
				queue.add(i);   //연결되어있고, 방문한적이 없다면 큐에 추가
				visit[i] = true;  
				cnt++;  //연결된 노드가 확인될때마다 cnt를 증가 (최종답)	
			}
		}
	}
}
