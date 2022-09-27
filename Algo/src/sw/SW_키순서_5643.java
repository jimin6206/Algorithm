package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_키순서_5643 {
	
	static int T, N, M, result;
	static ArrayList<Integer>[] height;
	static boolean[] visit,visit2;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); //테케 수
		
		//테케만큼 반복
		for (int t = 1; t <= T; t++) {
			result = 0;
			N = Integer.parseInt(br.readLine()); //학생 수
			M = Integer.parseInt(br.readLine()); //키를 비교한 횟수
			
			height = new ArrayList[N+1];  //인접리스트로 구현
			visit = new boolean[N+1];  
			visit2 = new boolean[N+1];
			
			for (int i = 0; i < N+1; i++) {
				height[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				height[a].add(b); //작은 키에 큰 키를 연결 (방향 o)
			}
			//i가 1부터 N까지 반복하며 i의 키가 몇번째인지 알 수 있는 지 검사
			for (int i = 1; i <= N; i++) {
				int cnt=0;  //자신과 비교가능한 키를 카운트
				//i에서 갈수 있는 노드 체크
				Arrays.fill(visit, false);  //visit 배열 초기화
				queue.add(i); //여기서 부터 bfs:큐에 현재 자신을 넣고 자신으로부터 갈 수 있는 노드를 모두 visit = true한다.
				visit[i] = true;
				while(!queue.isEmpty()) {
					int n = queue.poll();
					for (int k : height[n]) {
						if(visit[k]) continue; //이미 visit되어있으면 패쓰
						queue.add(k);
						visit[k] = true;
					}
				}
				//여기까지 끝나면 자신이 갈 수 있는 노드들이 모두 visit된 상태
				//이제 다른 노드로 부터 자신까지 올 수 있는지를 확인해야함 => visit이 false인 노드들만 확인 (하나라도 못가면 자신이 몇번째인지 알 수 없음)
				//visit 안된 노드들만 체크 => j에서 로 갈 수 있는지 , 못가면 x
				for (int j = 1; j <= N; j++) {
					if(visit[j]) continue;  //visit이 false인 노드들만 확인하기 위해
					queue.clear(); //queue 초기화
					queue.add(j); //똑같이 bfs: 여기는 j노드부터 i를 찾아간다.
					Arrays.fill(visit2, false);//visit2는 현재 bfs에서 중복확인을 제거하기 위해 사용
					visit2[j] = true;
					while(!queue.isEmpty()) {
						int n = queue.poll();
						for (int k : height[n]) {
							if(k==i) {  //i까지 가는 경로 가 존재함
								visit[j] = true;
								break;  //i까지 가는 걸 확인했으면 더이상 가지말고  break
							}
							if(visit2[k]) continue;
							queue.add(k);
							visit2[k] = true;
						}
						if(visit[j]) break; //찾았으면 더이상 가지말고 break
					}
				}
				//여기까지 끝나면 i로 부터 갈수 있는 노드들과 다른 노드로부터 i로 올수 있는 값들이 모두 visit= true되어있는 상태
				//visit배열을 검사해서 1~N까지 모두 true이면 자신의 위치를 알 수 있음
				
				for (int j = 1; j <= N; j++) {
					if(visit[j]) {
						cnt++; //visit이 true인 경우 count
					}
				}
				if(cnt==N) { //N개가 모두 카운트되면 result+1
					result++;
				}
			}
			//결과 출력
			System.out.println("#" + t + " " + result);
		}
	}
}
