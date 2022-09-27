package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_섬의개수_4963 {
	
	static int W,H;
	static int[][] map;
	static boolean[][] check;
	static Queue<Node> queue = new LinkedList<>();
	static int cnt=0;
	
	//8방 탐색
	static int dy[] = {-1,-1,-1,0,0,1,1,1};
	static int dx[] = {-1,0,1,-1,1,-1,0,1};
	
	//큐에 담을 Node(좌표 값)
	static class Node{
		int y;
		int x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//0 0이 입력될때까지 무한반복
		while(true) {
			cnt=0;   //테케 별로 cnt초기화
			st = new StringTokenizer(br.readLine());
			
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			if(W==0 && H==0) break;   //0 0이 입력되면 while 탈출
			
			//map과 check를 H x W만큼 할당
			map = new int[H][W];  //섬과 바다를 입력받음
			check = new boolean[H][W];  //해당노드를 check했는지 안했는지 확인
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());  
				}
			}
			
			//map 배열을 순서대로 돌면서 섬인지 바다인지 확인
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(!check[i][j] && map[i][j]==1) {  //해당노드가 체크가 안되어있고, 섬이면
						bfs(i,j);   //bfs함수 호출
						cnt++;   //새로운 섬이 발견될때마다 cnt+1
					}else {
						check[i][j] = true;  
					}
						
				}
			}
			//결과출력
			System.out.println(cnt);	
		}	
	}
	
	static void bfs(int y, int x) {
		//호출된 노드를 큐에 추가
		queue.add(new Node(y,x));
		//큐가 빌때까지 반복(연결된 노드들 전부 순회)
		while(!queue.isEmpty()) {
			Node node = queue.remove();  //첫노드를 삭제
			
			for (int i = 0; i < 8; i++) { //8방탐색
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				//범위확인
				if(ny < 0 || nx < 0 || ny>=H ||nx >=W) continue;
				if(!check[ny][nx] && map[ny][nx] == 1) { //연결된 섬이면 큐에 추가
					queue.add(new Node(ny,nx));
					check[ny][nx]= true;  //해당노드를 다시 확인하지않게 check=true
				}
			}
		}
	}
}
