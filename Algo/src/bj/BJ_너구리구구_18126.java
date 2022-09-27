package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_너구리구구_18126 {

	static int N, result=0;
	static ArrayList<Node>[] list;
	static boolean[] visit;
	
	static class Node {
		int node, d;

		public Node(int node, int d) {
			this.node = node;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visit = new boolean[N+1];
		list = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();  //인접리스트 초기화
		}

		//인접리스트 저장 (input)
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			list[a].add(new Node(b, d));   //입접리스트에 저장
			list[b].add(new Node(a, d));
		}
		
		//1번부터 시작 
//		visit[1] = true;
		dfs(1,0);
		
		System.out.println(result);

	}
	
	//dfs
	static void dfs(int num, int d) {
	
		
		visit[num] = true;
		if(result < d) result = d;  //넘어온 d가 result보다 크면 업데이트
		
		for (Node n : list[num]) {  //넘어온 num으로부터 인접한 노드들 검사
			if(visit[n.node]) continue;
			
			dfs(n.node, d + n.d);
		}
	}
	
	
}
