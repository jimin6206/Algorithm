package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_촌수계산_2644 {
	
	static int n, start, end, cnt=0;
	static int[] parents;
	static int[][] graph;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());  //n은 전체 사람 수
		parents = new int[n+1];       //부모노드를 저장할 배열
		graph = new int[n+1][n+1];   //인접배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());  //시작노드를 루트로 보고
		end = Integer.parseInt(st.nextToken());    //end노드에서 루트까지의 깊이를 계산
		
		//인접배열 구현
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		
		//각각의 부모노드 저장
		bfs();
		
		//촌수를 계산할 사람번호 (루트노드까지 따라 올라갈것)
		int empty = end;
		
		//parents[end]가 0이면 start루트 안에 end가 속해있지않다는 의미, 즉 -1 출력
		if(parents[end] == 0)  cnt = -1;
		else { //속해있다면 parents 배열을 이용해서 루트까지 올라감
			while(empty != start) { //루트노드를 만날때까지 반복
				empty = parents[empty];  //자신의 부모를 emtpy에 저장하며 반복
				cnt++;  //start노드를 만날때까지 얼마나 반복되는가
			}
		}
				
		System.out.println(cnt);  //결과 출력
	}
	
	static void bfs() {		
		//루트를  start 라고 설정
		queue.offer(start);
		parents[start] = start;  
				
		//큐가 빌때까지 반복
		while(!queue.isEmpty()) {
			int num = queue.poll();  //첫번째 노드 
			for (int i=1; i <=n; i++) {  //해당 노드의 자식노드들 반복
				if(graph[num][i] == 1 && parents[i]==0) {
					queue.add(i);  //큐에 추가
					parents[i] = num;  //num이 i의 부모노드
				}
			}
		}
				
	}
}
