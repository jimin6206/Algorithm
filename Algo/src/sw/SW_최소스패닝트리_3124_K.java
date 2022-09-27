package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_최소스패닝트리_3124_K {

   static int T, V, E;
   static long sum;
   
   static int[] parent;
   static Edge[] edges; // 간선 리스트

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      

      T = Integer.parseInt(br.readLine());

      for (int tc = 1; tc <= T; tc++) {
         StringTokenizer st = new StringTokenizer(br.readLine());

         V = Integer.parseInt(st.nextToken());
         E = Integer.parseInt(st.nextToken());
         
         parent = new int[V+1];
         edges = new Edge[E];

         // 입력
         for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(v1, v2, c);
         }

         sum = 0;
         Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);
         makeSet();

         int cnt = 0;
         
         for (int i = 0; i < E; i++) {
            Edge edge = edges[i];
            
            if ( union(edge.v1, edge.v2) ) {
               sum += edge.c;
               cnt++;
            }
            
            if ( cnt == V-1 ) break;
            // 사이클 체크
            // 선택
            // 선택한 간선 수 = V-1개 확인 - 종료
         }

         System.out.println("#" + tc + " " + sum);
      }

   }
   
   
   static void makeSet() {
      for (int i = 1; i <= V; i++) {
         parent[i] = i;
      }
   }

   static int findSet(int x) {
      if (x == parent[x]) return x;
      else return parent[x] = findSet(parent[x]);
   }

   static boolean union(int x, int y) {
      int py = findSet(x);
      int px = findSet(y);

      if ( py == px ) return false;
      
      if ( px < py ) parent[py] = px; 
      else parent[px] = py;
      
      return true;
      }
   
   static class Edge {
      int v1;
      int v2;
      int c; // cost

      public Edge(int v1, int v2, int c) {
         super();
         this.v1 = v1;
         this.v2 = v2;
         this.c = c;
      }
   }

}