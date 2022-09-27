package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_상근이의여행_9372 {
	static int T, N, M;
	static boolean[] visit;
	static LinkedList<Integer>[] air;
	static Queue<Integer> queue = new LinkedList<>();
	static int min=0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테케 입력받기
		T = Integer.parseInt(br.readLine());
	
		for (int t = 1; t <= T; t++) {  //테케만큼 반복
			StringTokenizer st = new StringTokenizer(br.readLine());		
			N = Integer.parseInt(st.nextToken());  //정점 수
			M = Integer.parseInt(st.nextToken());  //간선 수
			
			visit = new boolean[N+1];   //방문했는지 확인하는 변수
			air = new LinkedList[N+1];   //연결리스트로 인접노드표현
			
			//연결리스트 만들기(인접노드)
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(air[a] == null) air[a] = new LinkedList<>();
				if(air[b] == null) air[b] = new LinkedList<>();
				air[a].add(b);
				air[b].add(a);
			}
			
			//1번 정점부터 시작
			queue.add(1);
			visit[1] = true;
			min=0;
			
			//큐가 빌때까지 반복
			while(!queue.isEmpty()) {
				int num = queue.poll();  //첫번째 정점 제거 -> 정점과 인접한 정점 추가
				
				for (Integer city : air[num]) {  //인접정점 확인
					if(visit[city]) continue;  //이미 방문한 지역이면 continue
					
					min++;  
					visit[city] = true;  //해당정점 visit =true
					queue.add(city);
				}
				
			}
			
			//결과출력
			System.out.println(min);		
		}
	}
}
