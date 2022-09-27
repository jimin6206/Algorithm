package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_안전영역_2468 {
	static int N;
	static int[][] map;
	static boolean[][] safe;
	static boolean[][] check;
	static int max_height=0, cnt,ans=0;
	static Queue<Node> queue = new LinkedList<>();
	
	static class Node {
		int y;
		int x;
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	//상 하 좌 우
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());  //N입력받기
		
		//배열크기 할당
		map = new int[N][N];        //지역의 높이정보
		safe = new boolean[N][N];   //안전지대인지 아닌지
		check = new boolean[N][N];  //check한 곳인지 아닌지
		
		//N x N 입력받기
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());  //map 입력받기
				max_height = Math.max(map[i][j], max_height);  //지역중 최고높이 
			}
		}
		
		//비의 높이를 [0 ~ 지역중 최고높이] 로 설정
		for (int i = 0; i < max_height; i++) {
			cnt=0;  //cnt는 비높이가 바뀔때마다 리셋 (cnt : 안전한 영역 수)
			
			//safe영역 구하기
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if(map[j][j2] > i) safe[j][j2] = true;
					else safe[j][j2] = false;
					check[j][j2] = false;  //check도 리셋
				}
			}
			
			//N x N 번 반복하면서 safe배열을 순회
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if(!check[j][j2] && safe[j][j2])  //safe영역이면 
					{
						bfs(j, j2);  //bfs 호출 -> 연결된 안전지역을 하나로 묶어줄거임
						check[j][j2] = true; //자신 check 
						cnt++;  //이렇게되면 bfs안에서 연결된 곳은 전부 true시켜줘서 결국 떨어진 safe에서만 bfs를 다시 호출하게 되고, 
								//그때의 cnt를 증가시키면 안전한 영역의 수가 count된다.
					}
				}
			}
			
			ans = Math.max(cnt, ans); //비의 높이에 따라 구해지는 cnt 중 가장 큰 수를 ans에 저장
		}
		
		System.out.println(ans); //최종 결과 출력
	}
	
	//bfs함수
	static void bfs(int y, int x) {
		queue.add(new Node(y,x));  //처음 safe가 true인 영역의 좌표값 추가
		//큐가 빌때까지 반복
		while(!queue.isEmpty()) {
			Node node = queue.remove();  //처음노드를 삭제
			
			for (int d = 0; d < 4; d++) {  //4방 탐색
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				
				//좌표 범위 확인
				if(ny<0 || nx <0 ||ny >= N || nx >=N) continue;
				if(check[ny][nx] || !safe[ny][nx]) continue;
				//이전에 체크 되지않았고, 상하좌우에 safe역역이 있으면 queue에 추가
				queue.add(new Node(ny,nx));
				check[ny][nx] = true;  //다시 탐색되지않도록 check= true
			}
		}
	}
}
