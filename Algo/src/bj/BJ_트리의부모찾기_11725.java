package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_트리의부모찾기_11725 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());  //노드 수 입력
		Queue<Integer> queue = new LinkedList<>();  
		
		//인접배열로 구현하면 메모리초과 ㅠㅠ
		LinkedList<Integer>[] graph = new LinkedList[N+1]; //인접리스트로 구현
		int[] parent = new int[N+1]; //각 노드의 부모노드를 저장
		
		//인접리스트 만들기 (N-1 만큼 반복)
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(graph[a] == null) graph[a] = new LinkedList<>();
			if(graph[b] == null) graph[b] = new LinkedList<>();
			graph[a].add(b);
			graph[b].add(a);
		}
		
		//루트를 1이라고 가정
		queue.offer(1);
		parent[1] = 1;  // 0 만들지않으려고 임의로 1 저장
		
		//큐가 빌때까지 반복
		while(!queue.isEmpty()) {
			int num = queue.poll();  //첫번째 노드 
			for (int i : graph[num]) {  //해당 노드의 자식노드들 반복
				if(parent[i] == 0) {    //parent가 0이 아니면 이미 방문한 노드
					queue.offer(i);     //자식 노드 추가
					parent[i] = num;    //parent[자식노드] 에 현재노드(부모노드) 저장
				}
			}
		}
		
		//while문이 끝나면 parent배열에 자신의 부모노드들이 모두 저장되어있을 것!
		//출력
		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}
}
