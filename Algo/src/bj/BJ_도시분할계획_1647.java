package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_도시분할계획_1647 {
	
	static int N,M, result=0;
	static ArrayList<Node>[] list;
	static boolean[] visit;
	static PriorityQueue<Node> pqueue = new PriorityQueue<>();
	
	static class Node implements Comparable<Node>{
		int n;
		int c;
		
		public Node(int n, int c) {
			this.n = n;
			this.c = c;
		}
		
		@Override
		public int compareTo(Node n1) {
			return this.c - n1.c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		visit = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b,c));
			list[b].add(new Node(a,c));
		}
		
		prim();
		
		System.out.println(result);
	}
	
	static void prim() {
		pqueue.offer(new Node(1, 0));
		
		int dist = 0; 
        int max = 0; 
        
        while(!pqueue.isEmpty()) {
            Node current = pqueue.poll();
            
            if(visit[current.n] == false) visit[current.n] = true;
            else continue;
            
            max = Math.max(max, current.c);
            dist += current.c;
            
            for(int i = 0; i < list[current.n].size(); i++) {
                Node next = list[current.n].get(i);
                if(visit[next.n] == false) pqueue.offer(new Node(next.n, next.c));
            }
        }
        result =  dist - max;
	}
}
