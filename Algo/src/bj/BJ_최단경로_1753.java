package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_최단경로_1753 {
	static int V, E, K;
	static ArrayList<ArrayList<Edge>> vertex = new ArrayList<ArrayList<Edge>>();
	static boolean[] visit;
	static int[] cost;  //비용
	static PriorityQueue<Edge> pqueue = new PriorityQueue<Edge>( (e1, e2)-> e1.c - e2.c);
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		visit = new boolean[V+1];
		cost = new int[V+1];   //prim에는 없다.
		
		for (int i = 0; i <= V; i++) {
			vertex.add(new ArrayList<Edge>());
			cost[i] = INF;
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			//유향
			vertex.get(v1).add(new Edge(v2,w));		
		}
		
		dijkstra();
		
		for (int i = 1; i <= V; i++) {
			System.out.println(cost[i] == INF ? "INF" : cost[i]);
		}
	}
	
	static void dijkstra() {
		//시작 k
		cost[K] = 0;
		pqueue.offer(new Edge(K,0));
		
		while(!pqueue.isEmpty()) {
			Edge e = pqueue.poll();	  //꺼낸 것  e
			
			if(visit[e.v]) continue;
			visit[e.v] = true; 
			
			//ne 의 비용 체크
			for (Edge ne : vertex.get(e.v)) {
				if(!visit[ne.v] && ne.c + cost[e.v] < cost[ne.v]) {
					cost[ne.v] =  ne.c + cost[e.v];
					pqueue.offer(new Edge(ne.v, cost[ne.v]));
				}
			}
		}
	}
	
	static class Edge {
		int v;
		int c;
		public Edge(int v, int c) {
			super();
			this.v = v;
			this.c = c;
		}
	}

}
