package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_색종이_2563 {
	
	static int[][] map = new int[100][100];  //도화지
	static int N, x, y,count=0;	

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//N만큼 색칠
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//입력 인덱스값 받아오기
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			//받아온 인덱스에서부터 10x10만큼 1로 저장  => 그러면 색종이 붙인곳만 1로 변함(겹쳐도 상관x)
			for (int j = x; j < x+10; j++) {
				for (int j2 = y; j2 < y+10; j2++) {
					map[j][j2] = 1;
				}
			}
		}
		
		//도화지전체에서 1만 count
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] ==1) count++;
			}
		}
		
		//결과출력
		System.out.println(count);
	}
}
