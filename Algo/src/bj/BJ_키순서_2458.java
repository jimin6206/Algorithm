package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_키순서_2458 {
	
	static int N, M, result=0;
	static ArrayList<Integer>[] height;
	static boolean[] visit,visit2;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		height = new ArrayList[N+1];
		visit = new boolean[N+1];
		visit2 = new boolean[N+1];
		
		for (int i = 0; i <= N; i++) {
			height[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			height[a].add(b);			
		}
		
		for (int i = 1; i <= N; i++) {
			int cnt=0;
			//i에서 갈수 있는 노드 체크
			for (int j = 0; j <= N; j++) {
				visit[j] = false;
			}
			Arrays.fill(visit, false);
			queue.add(i);
			visit[i] = true;
			while(!queue.isEmpty()) {
				int n = queue.poll();
				for (int k : height[n]) {
					if(visit[k]) continue;
					queue.add(k);
					visit[k] = true;
				}
			}
			
			//visit 안된 노드들만 체크 => j에서 로 갈 수 있는지 , 못가면 x
			for (int j = 1; j <= N; j++) {
				if(visit[j]) continue;
				queue.clear();
				queue.add(j);
				Arrays.fill(visit2, false);
				visit2[j] = true;
				while(!queue.isEmpty()) {
					int n = queue.poll();
					for (int k : height[n]) {
						if(k==i) {  //i까지 가는 경로 가 존재함
							visit[j] = true;
							break;
						}
						if(visit2[k]) continue;
						queue.add(k);
						visit2[k] = true;
					}
					if(visit[j]) break;
				}
			}
			
			for (int j = 1; j <= N; j++) {
				if(visit[j]) {
					cnt++;
				}
			}
			if(cnt==N) {
				result++;
			}
		}
		
		System.out.println(result);
	}

}
