package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_최소스패닝트리_3124 {
	
	static int T;
	static int V,E;
	static int[] parents;
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			long result = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edgeList = new Edge[E];
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(from,to, weight);
			}
			
			Arrays.sort(edgeList);
			makeSet();
			int cnt = 0;
			for (Edge edge : edgeList) {
				if(union(edge.from, edge.to)) {
					result += edge.weight;
					if(++cnt == V-1) break;
				}
			}
			
			System.out.println("#" + t + " " + result);
			
		}
	}
	
	static void makeSet() {
		parents = new int[V+1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(parents[x] == x) return x;
		else return parents[x] = findSet(parents[x]);
	}
	
	static boolean union(int x, int y) {
		int py = findSet(y);
		int px = findSet(x);
		
		if(py == px) return false;
		
		parents[py] = px;
		return true;	
	}
}
