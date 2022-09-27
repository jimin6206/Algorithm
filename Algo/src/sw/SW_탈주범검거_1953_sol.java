package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_탈주범검거_1953_sol {

   static int T; // 테스트 케이스의 수
   static int N; // 지도의 세로 크기
   static int M; // 지도의 가로 크기
   static int R; // 맨홀 세로 위치
   static int C; // 맨홀 가로 위치
   static int L; // 탈출 후 소요된 시간
   static int ans;

   static int[][] map;
   static boolean[][] visit;

   static int[][] dy = { {}, { -1, 1, 0, 0 }, { -1, 1, 0, 0 }, { 0, 0, 0, 0 }, { -1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 1, 0, 0 }, { -1, 0, 0, 0 } }; // 1번 - 7번
   static int[][] dx = { {}, { 0, 0, -1, 1 }, { 0, 0, 0, 0 }, { 0, 0, -1, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, -1, 0 }, { 0, 0, -1, 0 } };

   static Queue<Node> queue = new ArrayDeque<>();
   
   public static void main(String[] args) throws IOException {
      System.setIn(new FileInputStream("input.txt"));
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = null;
      
      T = Integer.parseInt(br.readLine());

      for (int t = 1; t <= T; ++t) {
         st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         R = Integer.parseInt(st.nextToken());
         C = Integer.parseInt(st.nextToken());
         L = Integer.parseInt(st.nextToken());

         map = new int[N][M];
         visit = new boolean[N][M];

         for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
               map[i][j] = Integer.parseInt(st.nextToken());
            }
         }

         ans = 1; // 시작 위치부터 1시간
         queue.clear();
         
         visit[R][C] = true;
         queue.add(new Node(R, C, 1));
         bfs();
         
         System.out.println("#" + t + " " + ans);
      }
   }
   
   static boolean connect(int dir, int to) {
      // dir 이 상하좌우로 움직이려고 할 때 받아줄 수 있는 to인지 확인
      
      if ( to == 1 ) return true;
      
      switch (dir) {
      case 0: if ( to == 2 || to == 5 || to == 6 ) return true; break; // 상
      case 1: if ( to == 2 || to == 4 || to == 7 ) return true; break; // 하
      case 2: if ( to == 3 || to == 4 || to == 5 ) return true; break; // 좌
      case 3: if ( to == 3 || to == 6 || to == 7 ) return true; break; // 우
      }
      return false;
   }
   
   private static void bfs() {
      while ( !queue.isEmpty() ) {
         Node node = queue.poll();
         
         if ( node.d == L ) return;
         
         int current = map[node.y][node.x];
         int[] deltaY = dy[current];
         int[] deltaX = dx[current];
         
         for (int d = 0; d < 4; d++) {
            if ( deltaY[d] == 0 && deltaX[d] == 0 ) continue; // 이 부분이 없어도 되긴함. visit에서 체크가 됨
            int ny = node.y + deltaY[d];
            int nx = node.x + deltaX[d];
            
            if ( ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] ) continue;
            
            int next = map[ny][nx];
//            if ( next == 0 || current -> next 로 연결 될 수 없으면) continue;
            if( next == 0 || !connect(d, next)) continue;
            
            visit[ny][nx] = true;
            ans++;
            queue.add(new Node(ny, nx, node.d+1));
         } 
      }
      
   }


   static class Node {
      int y;
      int x;
      int d; // 시간 체크
      
      public Node(int y, int x, int d) {
         this.y = y;
         this.x = x;
         this.d = d;
      }
   }
}