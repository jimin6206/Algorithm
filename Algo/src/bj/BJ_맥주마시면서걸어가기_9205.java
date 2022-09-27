package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_맥주마시면서걸어가기_9205 {

	static int T, n;
	static Node[] store;  // store에 집 편의점 페스티벌 전부 넣기  0:집    n+1: festival
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); 
	static Queue<Integer> queue = new LinkedList<>();
	static boolean[] visit;
	
	static class Node{
		int y;
		int x;
		public Node(int x, int y) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		//테케만큼 반복
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());  //편의점 개수
			store = new Node[n+2];
			visit = new boolean[n+2];
			
			//집 편의점 페스티벌 좌표값 을 전부 저장 (store배열)
			for (int i = 0; i < n+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				store[i] = new Node(x,y);
			}
			
			//graph로 인접리스트 구현 ( 초기화 )
			graph = new ArrayList<>();
			for (int i = 0; i < n+2; i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < n+2; i++) {
				for (int j = i+1; j < n+2; j++) {
					if(distance(store[i], store[j]) <= 1000) {  //거리가 1000이하면 연결 가능
						graph.get(i).add(j);
						graph.get(j).add(i);
					}
				}
			}
			queue.clear();
			boolean result = bfs(graph, n);
			
			if(result) System.out.println("happy");
			else System.out.println("sad");

		}
	}
	
	//맨해튼 거리
	static int distance(Node a, Node b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
	
	//bfs 함수
	static boolean bfs(ArrayList<ArrayList<Integer>> graph, int N) {
		
		queue.add(0);
		visit[0] = true;
		
		//연결된 곳을 전부 탐색
		while(!queue.isEmpty()) {
			int num = queue.poll();
			
			if(num == N+1) {
				return true;  //festival 까지 도달 성공
			}
			
			for (int next : graph.get(num)) {
				if(!visit[next]) {
					visit[next] = true;
					queue.add(next);
				}
			}
		}
		
		return false;  //도달 실패	
	}
}
