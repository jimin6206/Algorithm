package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_하나로_P {
   static int T, N;
   static long ans;
   
   static boolean[] visit;
   static double E;
   
   static long[] minEdge;
   static long[][] matrix;

   public static void main(String[] args) throws Exception {
      System.setIn(new FileInputStream("SWEA_1251_하나로_input.txt"));
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      T = Integer.parseInt(br.readLine());

      for (int tc = 1; tc <= T; tc++) {
         N = Integer.parseInt(br.readLine());
         matrix = new long[N][N];
         visit = new boolean[N];
         minEdge = new long[N];
         
         int x[] = new int[N];
         int y[] = new int[N];
         // x -> y
         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(st.nextToken());
         }

         st = new StringTokenizer(br.readLine());
         for (int i = 0; i < N; i++) {
            y[i] = Integer.parseInt(st.nextToken());
         }
         
         //N x N
         for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = distance(x[i], x[j], y[i], y[j]);
			}
         }
         
         E = Double.parseDouble(br.readLine());
         
         ans = 0;
         
         prim();
         
         
         System.out.println("#" + tc + " " + Math.round(ans * E));
      }
   }
   
   static long distance(int x1, int x2, int y1, int y2) {
     return (long) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
   }
   
   static void prim() {
	   // minEdge 최대값
	   Arrays.fill(minEdge, Long.MAX_VALUE);
	   minEdge[0] = 0;  //첫 번째가 최소값으로 예상
	   
	   // 모든 정점 고려 ( N번 반복(선택) )
	   for (int v = 0; v < N; v++) {
		   long minC = Long.MAX_VALUE;
		   int minV = 0;
		   
		   //최소값 - 정점
		   for (int i = 0; i < N; i++) {  //i가 고려하는 정점 index
			   if(!visit[i] && minC >minEdge[i]) {
				   minC = minEdge[i];
				   minV = i;
			   }
		   }
		   
		   //선택
		   visit[minV] = true;
		   ans += minC;
		   //새로운 선택된 minV 으로부터 갈 수 있는 정점을 고려해서 그 비용으로 minEdge 갱신
		   for (int i = 0; i < N; i++) {
			   if(!visit[i] && matrix[minV][i]!= 0 && minEdge[i]> matrix[minV][i]) {
				   minEdge[i] = matrix[minV][i];
			   }
		   }
	   }
   }
}