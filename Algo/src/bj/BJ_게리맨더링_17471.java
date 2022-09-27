package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_게리맨더링_17471 {

	static int N, min;
	static int[][] matrix;
	static boolean[] select;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //구역의 수
		matrix = new int[N+1][N+1]; //0 dummy 아니고, 인구수에 저장
		select = new boolean[N+1];
		min = Integer.MAX_VALUE;
		
		//인구수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			matrix[i][0] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); //i 구역의 인접한 다른 구역의 수
			for (int j = 1; j <= n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		subset(1); //1번
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
		
	}
	
	static void check() {
		boolean[] visit = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		
		//A
		for (int i = 1; i <= N; i++) {
			if( select[i] ) {
				visit[i] = true;
				queue.offer(i);
				break;
			}
		}
		
		if(queue.size() == 0) return;  //적어도 한개의 구역을 포함해야 하는데 그렇지 않음.
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			for (int i = 1; i <= N; i++) {
				int adj = matrix[v][i];
				if(adj != 0 && !visit[adj] && select[adj] ) {
					visit[adj] = true;
					queue.offer(adj);
				}
			}
		}
		
		//B : select[i] == false
		for (int i = 1; i <= N; i++) {
			if( !select[i] ) {
				visit[i] = true;
				queue.offer(i);
				break;
			}
		}
				
		while(!queue.isEmpty()) {
			int v = queue.poll();
			for (int i = 1; i <= N; i++) {
				int adj = matrix[v][i];
				if(adj != 0 && !visit[adj] && !select[adj] ) {
					visit[adj] = true;
					queue.offer(adj);
				}
			}
		}
		
		//위 작업은 visit[]을 완성해 가는 작업
		boolean visitAll = true;
		for (int i = 1; i <= N; i++) {
			if( !visit[i] ) {  //연결되지 않은 구역이 남아 있다.
				visitAll = false;
				break;
			}
		}
		
		//A, B 각각 따졌을 때, 모두 연결되어 있다면 visitAll = true
		if( visitAll) { //두 그룹 모두 연결되어 있다.
			int sumA = 0;
			int sumB = 0;
			
			for (int i = 1; i <= N; i++) {
				if(select[i]) {
					sumA += matrix[i][0];
				}else {
					sumB += matrix[i][0];
				}
			}
			
			min = Math.min(min, Math.abs(sumA-sumB));
		}
	}
	
	static void subset(int srcIdx) {
		//기저조건
		if(srcIdx == N+1) {
			//complete code
			check();
			return;
		}
		
		select[srcIdx] = true;
		subset(srcIdx + 1);
		select[srcIdx] = false;
		subset(srcIdx + 1);
	}
}
