package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_하나로_P_PQ {
   static int T, N;
   static long ans;
   static int[][] island;
   
   static ArrayList<ArrayList<Edge>> vertex;
   static PriorityQueue<Edge> pqueue = new PriorityQueue<>( (e1,e2)-> Long.compare(e1.c, e2.c));
   static boolean[] visit;
   static double E;

   public static void main(String[] args) throws Exception {
      System.setIn(new FileInputStream("SWEA_1251_하나로_input.txt"));
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      T = Integer.parseInt(br.readLine());

      for (int tc = 1; tc <= T; tc++) {
         N = Integer.parseInt(br.readLine());
         island = new int[N][2]; // 0: x, 1: y

         // x -> y
         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int i = 0; i < N; i++) {
            island[i][0] = Integer.parseInt(st.nextToken());
         }

         st = new StringTokenizer(br.readLine());
         for (int i = 0; i < N; i++) {
            island[i][1] = Integer.parseInt(st.nextToken());
         }

         E = Double.parseDouble(br.readLine());
         
         vertex = new ArrayList<ArrayList<Edge>>();
         for (int i = 0; i < N; i++) {
			vertex.add(new ArrayList<Edge>());
		}
         
        for (int v1 = 0; v1 < N-1; v1++) {
			for (int v2 = v1+1; v2 < N; v2++) {
				//v1 -> Edge 객체
				long dis = distance(island[v1][0], island[v2][0], island[v1][1], island[v2][1]);
				Edge edge1 = new Edge(v2, dis);
				vertex.get(v1).add(edge1);
				
				Edge edge2 = new Edge(v1, dis);
				vertex.get(v2).add(edge2);
			}
		}
        
        //초기화
        visit = new boolean[N];
        pqueue.clear();
        
        ans = 0;
        int cnt = 1;
        visit[0] = true;
        
        pqueue.addAll(vertex.get(0));
        while(! pqueue.isEmpty()) {
        	Edge edge = pqueue.poll();
        	if(visit[edge.v]) continue;
        	
        	//선택
        	visit[edge.v] = true;
        	ans += edge.c;
        	cnt++;
        	if(cnt == N) break;
        	
        	//일단 다 넣는다
//        	pqueue.addAll(vertex.get(edge.v));
        	
        	//선택적으로 넣는다.
        	for (Edge e : vertex.get(edge.v)) {
				if(visit[e.v]) continue;
				pqueue.add(e);
			}
        }
         System.out.println("#" + tc + " " + Math.round(ans * E));
      }
   }
   
   static long distance(int x1, int x2, int y1, int y2) {
     return (long) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
   }
   
   // 어떤 정점에서부터 v로 가는 간선과 그 비용
   static class Edge {
      int v;
      long c; // cost
      
      public Edge(int v, long c) {
         this.v = v;
         this.c = c;
      }
   }

}