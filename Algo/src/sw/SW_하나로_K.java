package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_하나로_K {
   static int T, N;
   static long ans;

   static int[] parent;
   static int[][] island;
   static long[][] edges;
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
            ;
         }

         st = new StringTokenizer(br.readLine());
         for (int i = 0; i < N; i++) {
            island[i][1] = Integer.parseInt(st.nextToken());
            ;
         }

         E = Double.parseDouble(br.readLine());

         // 간선 리스트 구성
         // 1. 간선의 비용
         // 2. 간선의 규모

         // ex) 4개 -> 6개 4*3/2
         // 1: 2-3-4
         // 2: 3-4
         // 3: 4

         int size = N * (N - 1) / 2;
         edges = new long[size][3];

         int idx = 0;
         for (int v1 = 0; v1 < N - 1; v1++) {
            for (int v2 = v1 + 1; v2 < N; v2++) {
               edges[idx][0] = v1;
               edges[idx][1] = v2;
               edges[idx][2] = distance(island[v1][0], island[v2][0], island[v1][1], island[v2][1]);
               idx++;
            }
         }

         // 정렬
         Arrays.sort(edges, (o1, o2) -> Long.compare(o1[2], o2[2]));
         parent = new int[N];
         makeSet();

         ans = 0;
         int cnt = 0;
         for (int i = 0; i < size; i++) {
            int a = findSet((int) edges[i][0]); // v1
            int b = findSet((int) edges[i][1]); // v2

            if (a == b)
               continue;

            if (a < b)
               parent[b] = a;
            else
               parent[a] = b;

            ans += edges[i][2];
            cnt++;
            if (cnt == N - 1)
               break;
         }
         System.out.println("#" + tc + " " + Math.round(ans * E));
      }
   }

   static long distance(int x1, int x2, int y1, int y2) {
      return (long) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
   }

   static void makeSet() {
      for (int i = 0; i < N; i++) {
         parent[i] = i;
      }
   }

   static int findSet(int x) {
      if (x == parent[x])
         return x;
      else
         return parent[x] = findSet(parent[x]);
   }

   static void union(int x, int y) {
      int py = findSet(x);
      int px = findSet(y);

      if (px < py)
         parent[py] = px;
      else
         parent[px] = py;
   }

}