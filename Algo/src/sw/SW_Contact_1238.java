package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_Contact_1238 {

	static int T=10;   //테케 10개 (?)
	static int[][] graph;  //인접행렬
	static int[] visit;    //방문한 정점인지 확인 행렬 (몇번째로 방문했는지 담기 위해 int배열)
	static Queue<Integer> queue = new LinkedList<>();
	static int ans=0, ans_num=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		for (int t = 1; t <= T; t++) {  //테케만큼 반복
		
			//테케마다 초기화
			graph = new int[101][101];
			visit = new int[101];
			ans=0;
			ans_num=0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());  //시작정점
			
			//입력부분
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < length/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				//인접행렬 만들기
				graph[from][to] = 1;
			}
			
			//bfs함수
			bfs(start);
			
			//결과 출력
			System.out.println("#" + t + " " + ans_num);
		}
	}
	
	static void bfs(int start) {
		queue.add(start);  //시작정점부터 queue에 담기
		visit[start] = 1;  //시작정점은 첫번째로 방문했으므로 visit에 1
		
		//큐에 빌때까지 반복
		while(!queue.isEmpty()) {
			int num = queue.remove();  //큐에서 첫번째 정점을 꺼낸다.
			int cnt = visit[num];      //해당 정점이 몇번째로 방문했는지 확인
			
			for (int i = 1; i <= 100; i++) {  //인접행렬 탐색
				if(graph[num][i]==1 && visit[i] == 0) {  //해당정점과 인접정점이며, 
					queue.add(i);						//visit이 0이여야함 (0이상의 수는 이미 방문했다는 의미)
					visit[i] = cnt+1;     //인접 정점은 queue에 추가, 현재 정점은 num정점의 자식인 셈이므로 visit울 num보다 1크게 저장
				}
			}
		}

		//반복이 모두 끝나면 인접된 정점은 모두 탐색하고 왔다는 의미
		//visit배열에는 각각의 정점이 몇번째로 방문했는지의 정보가 저장되어있음
		//제일 마지막으로 방문했다는 것은 visit숫자가 제일 큰 정점을 찾는 것! 비교해서 해당 정점 업데이트
		for (int i = 1; i <= 100; i++) {
			if(ans <= visit[i]) {
				ans = visit[i];
				ans_num = i;
			}
		}
	}
}
