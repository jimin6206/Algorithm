package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_최소스패닝트리_3124_P {

   static int T, V, E;
   static long sum;
   static ArrayList<ArrayList<Edge>> vertex; // 0 -> dummy, i index == 1번 정점 vertex(3) == ArrayList<Edge>
   static boolean[] visit;
   
   static PriorityQueue<Edge> pqueue = new PriorityQueue<>( (e1, e2) -> e1.c - e2.c );
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      T = Integer.parseInt(br.readLine());

      for (int tc = 1; tc <= T; tc++) {
         StringTokenizer st = new StringTokenizer(br.readLine());

         V = Integer.parseInt(st.nextToken());
         E = Integer.parseInt(st.nextToken());

         vertex = new ArrayList<ArrayList<Edge>>();
         
         for (int i = 0; i <= V; i++) { // List의 1차 구조( 2차원배열의 1차원 )
            vertex.add(new ArrayList<Edge>());
         }
         
         visit = new boolean[V+1];
         pqueue.clear();
         
         // 입력
         for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            vertex.get(v1).add(new Edge(v2, c));
            vertex.get(v2).add(new Edge(v1, c));
         }

         sum = 0;
         int cnt = 1; // 시작 정점을 선택하고 들어감 cnt == V
         
         visit[1] = true;
         
         // pqueue 시작 정점 => 갈 수 있는 정점들을 pqueue에 담는다. => 하나를 꺼내면 가장 작은 비용의 정점

         pqueue.addAll( vertex.get(1) ); // ex) 1 -> 3, 5, 4, 7
         
         while ( !pqueue.isEmpty() ) {
            Edge edge = pqueue.poll();
            
            if ( visit[edge.v] ) continue;
            
            visit[edge.v] = true;
            sum += edge.c;
            
            cnt++;
            if ( cnt == V ) break;
            
            pqueue.addAll(vertex.get(edge.v));
         }
         
         System.out.println("#" + tc + " " + sum);
      }
   }

   // 어떤 정점에서부터 v로 가는 간선과 그 비용
   static class Edge {
      int v;
      int c; // cost
      
      public Edge(int v, int c) {
         this.v = v;
         this.c = c;
      }
   }

}