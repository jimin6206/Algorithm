package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_6497_전력난 {

	static int N, M, result=0, sum=0;
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
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//테케만큼 반복
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if(N==0 && M==0) break;  //0 0 이 입력되면 입력 종료
			
			list = new ArrayList[N];
			visit = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				list[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list[a].add(new Node(b,c));
				list[b].add(new Node(a,c));
				
				sum+=c;
				
			}
			
			prim();
			
			System.out.println(sum - result);
		}
		

	}
	
	static void prim() {
		pqueue.offer(new Node(1, 0));
		
		int dist = 0; 
        int min = Integer.MAX_VALUE; 
        
        while(!pqueue.isEmpty()) {
            Node current = pqueue.poll();
            
            if(visit[current.n] == false) visit[current.n] = true;
            else continue;
            
            min = Math.min(min, current.c);
            dist += current.c;
            
            for(int i = 0; i < list[current.n].size(); i++) {
                Node next = list[current.n].get(i);
                if(visit[next.n] == false) pqueue.offer(new Node(next.n, next.c));
            }
        }
        result =  dist - min;
	}

}
