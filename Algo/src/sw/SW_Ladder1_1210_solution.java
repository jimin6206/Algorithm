package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_Ladder1_1210_solution {

	static int T=1;
	static int[][] ladder = new int[100][100];  //map 2차원배열
	static int sy,sx,ans;
	//왼 오 위
	static int[] dy = {0, 0, -1};
	static int[] dx = {-1,1,  0}; 
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//테케
		for (int t = 1; t <= T; t++) {
			br.readLine();
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = st.nextToken().charAt(0) - '0';				
				}
			}
			// 시작좌표
			sy = 99;
			for (int i = 0; i < 100; i++) {
				if(ladder[99][i] == 2) sx = i;
				
			}
			
			// 탐색
			int dir = 2; //위(delta)
			

			while(true) {
				
				//위로 가는 상태
				if(dir == 2) {
					for (int d = 0; d < 3; d++) {
						int ny = sy + dy[d];
						int nx = sx + dx[d];
						
						//먼저 왼쪽이나 오른쪽이나 가능하면 방향전환하고 break;
						if(ny >=0 && nx>=0 && nx<100 && ladder[ny][nx] ==1) {
							sy = ny;
							sx = nx;
							dir = d;   //방향 전환 (혹은 그대로)
							break;
						}
					}
				}else if(dir==1 || dir==2) {
					//위로 갈 수 있는 지 확인
					int ny = sy+dy[2];
					int nx = sx+dx[2];
					
					//위로 갈 수 있다.
					if(ny>=0 &&ladder[ny][nx]==1) {
						sy = ny;
						sx = nx;
						dir = 2;
					}else {
						sy = sy+dy[dir];
						sx = sx+dx[dir];
					}
				}
				
				if( sy==0) {
					ans = sx;
					break;
					
				}
				
			}
			
			//결과 출력
			System.out.println("#" + t + " " +ans);
		}
	}
}
