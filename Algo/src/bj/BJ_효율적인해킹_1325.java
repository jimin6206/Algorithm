package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_효율적인해킹_1325 {
	static int N,M,cnt=0,max_value=0;
	static LinkedList<Integer>[] map;
	static int[] max;
	static boolean[] check;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());   //동기 수
		M = Integer.parseInt(st.nextToken());   //인접 관계 수
		
		map = new LinkedList[N+1];
		max = new int[N+1];
		check = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			map[i] = new LinkedList<>();
		}
		
		//연결리스트 만들기(인접노드)
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[b].add(a);
		}	
		
		for (int i = 1; i <= N; i++) {
			cnt=0;
			Arrays.fill(check, false);
			bfs(i);
			max_value = Math.max(max[i], max_value);
		}
		
		for (int i = 1; i <= N; i++) {
			if(max[i] == max_value) {
				System.out.print(i + " ");
			}
		}
		

	}
	static void bfs(int i) {
		queue.add(i);
		check[i] = true;
		
		while(!queue.isEmpty()) {
			int empty = queue.poll();
			
			for (int j : map[empty]) {
				if(!check[j]) {
					queue.add(j);
					check[j] = true;
				}
			}
		}
		
		for (int j = 1; j <= N; j++) {
			if(check[j]) cnt++;
		}
		
		max[i] = cnt;
	}

}
