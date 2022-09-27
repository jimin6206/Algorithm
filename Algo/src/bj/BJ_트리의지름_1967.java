package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_트리의지름_1967 {

	static ArrayList<Node>[] list;
	static boolean[] visit;
	static int max = 0;
	static int N;
	static int max_idx = 0;
	
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

		list = new ArrayList[N + 1]; //인접리스트 구현
		visit = new boolean[N + 1];
		
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {  //N-1개의 간선들 입력받기

			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			list[a].add(new Node(b, d));   //입접리스트에 저장
			list[b].add(new Node(a, d));
		}

		//루트부터 시작
		visit[1] = true;
		dfs(1, 0); //dfs를 해서 루트로 부터 최고 가중치값을 구함.(가장 먼 노드)=> max_idx

		visit = new boolean[N + 1]; //리셋
		visit[max_idx] = true; //max_idx를 루트로 잡고 dfs => 최고 경로 지정
		dfs(max_idx, 0);
		System.out.println(max);  //최종 결과

	}
	
	static void dfs(int idx, int dist) {
		if (max < dist) {
			max = dist;
			max_idx = idx;
		}

		for (Node n : list[idx]) {
			if (!visit[n.node]) {
				visit[n.node] = true;
				dfs(n.node, dist + n.d);
			}
		}
	}

}
