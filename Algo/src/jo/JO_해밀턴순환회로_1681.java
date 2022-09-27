package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_해밀턴순환회로_1681 {
   static int N, min;
   static int[][] matrix;
   static boolean[] select;

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      N = Integer.parseInt(br.readLine().trim());

      matrix = new int[N + 1][N + 1];
      select = new boolean[N+1];

      StringTokenizer st = null;
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < N; j++) {
            matrix[i + 1][j + 1] = Integer.parseInt(st.nextToken());
         }
      }
      
      min = Integer.MAX_VALUE;
      select[1] = true;
      dfs(1,1,0); // 1번 정점, depth 1, 비용 : 0
      
      System.out.println(min);
      
   }
   
   // 방문할 정점, depth, 누적비용
   static void dfs(int v, int d, int c) {
      
      // 기저 조건
      if(d==N) {
         // 1번으로 되돌아 갈 수 있는지 확인
         if(matrix[v][1]!=0) {
            min = Math.min(min, c+matrix[v][1]);
         }
         return;
      }
      
      // 현재까지 선택되어 온 정점 제외 (select)
      // 갈 수 있어야 함
      // 비용의 가지치기
      for (int i = 1; i <= N; i++) {
         if(select[i]||matrix[v][i] ==0||c+matrix[v][i] >= min ) continue;
         
         select[i] = true;
         dfs(i,d+1,c+matrix[v][i]);
         select[i] = false;
      }
   }
}