package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_Ladder1_1210 {

	static int T=10;
	static int[][] map = new int[100][100];  //map 2차원배열
	static int X_x, X_y=99;  //목적지 좌표 (X 좌표)
	static int c_x, c_y;     //현재좌표 (X좌표부터 거꾸로 타고 올라감)
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//테케
		for (int t = 1; t <= T; t++) {
			br.readLine();
			
			//map 입력받기 (100x100)
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i==99 && map[i][j] == 2) {  //목적지 좌표
						X_x = j;
					}
				}
			}
			
			//현재 좌표값은 X 바로위부터 시작
			c_x = X_x;
			c_y = X_y - 1;
			
			//현재 좌표값이 0이 될때까지 반복 (99부터 거꾸로 올라옴)
			while(c_y > 0) {
				
				//왼쪽에 1이있으면
				if((c_x-1 >= 0) && (c_x-1 <= 99) && (map[c_y][c_x-1] == 1)) {
					//왼쪽에 1이 있는 만큼 왼쪽으로 이동
					while((c_x-1 >= 0) && (map[c_y][c_x-1] == 1)) {
						c_x--;
					}
					c_y--;  //옆으로 다 이동했으면 위로 한칸
				}else if((c_x+1 >= 0) && (c_x+1 <= 99) && (map[c_y][c_x+1] == 1)) {  //오른쪽에 1이있으면
					//오른쪽에 1이 있는 만큼 오른쪽으로 이동
					while((c_x+1 <= 99) && (map[c_y][c_x+1] ==1)) {
						c_x++;
					}
					c_y--;  //옆으로 다 이동했으면 위로 한칸
				}else { 
					c_y--;   //양쪽에 1이 없으면 계속 위로
				}
			}
			
			//결과 출력
			System.out.println("#"+ t + " " + c_x);
		}
	}
}
