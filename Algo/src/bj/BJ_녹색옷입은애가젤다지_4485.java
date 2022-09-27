package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_녹색옷입은애가젤다지_4485 {
	
	static int N, T = 0;
	static int[][] map;    //동굴의 도둑루피
	static int[][] cost;   //각 칸까지왔을때의 최소 루피를 저장
	static boolean[][] visit;  //방문배열
	static PriorityQueue<Node> queue = new PriorityQueue<Node>( (e1, e2)-> e1.c - e2.c);  //우선순위 큐
	// 상 하 좌 우
	static int[] dy = {1, -1, 0,0};
	static int[] dx = {0, 0, -1,1};
	//각 칸의 좌표값과 비용을 노드클래스로 구현
	static class Node {
		int y;
		int x;
		int c;
		public Node(int y, int x, int c) {
			this.y = y;
			this.x = x;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//N에 0이 입력될때까지 테케 반복
		while(true) {
			T++;  //테케번호
			N = Integer.parseInt(br.readLine());  //N입력받기(배열의 크기)
			
			if(N == 0) break;  //N이 0이면 종료
			
			//배열들을 NxN으로 초기화
			map = new int[N][N];
			cost = new int[N][N];
			visit = new boolean[N][N];
			
			//map입력받기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				Arrays.fill(cost[i], Integer.MAX_VALUE);  //cost를 최대값으로 초기화
			}
			//dijkstra()함수
			dijkstra();
			//결과출력
			System.out.println("Problem " + T + ": " + cost[N-1][N-1]);
		}
	}
	
	static void dijkstra() {
		//0,0좌표 부터 시작
		cost[0][0] = map[0][0];
		queue.offer(new Node(0,0,cost[0][0]));  //큐에 추가 (cost값과 같이)
		//큐가 빌때까지 반복
		while(!queue.isEmpty()) {
			Node node = queue.poll();	  //큐의 첫노드 빼기		
			if(visit[node.y][node.x]) continue;
			visit[node.y][node.x] = true;
			
			//node로 부터 상하좌우로 검사
			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				//범위확인
				if(ny<0 || ny>=N || nx<0 ||nx>=N) continue;
				
				// ny,nx의 cost값과 현재 node를 거쳐서 가는 cost값을 비교
				if(cost[ny][nx] > cost[node.y][node.x] + map[ny][nx]) {
					cost[ny][nx] = cost[node.y][node.x] + map[ny][nx];  //더 작은 값으로 업데이트
					queue.add(new Node(ny,nx,cost[ny][nx]));  //큐에 추가
				}
			}
		}
	}
}
