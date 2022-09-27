package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_미세먼지안녕_17144 {

	static int R, C, T, result=0;
	static int[][] map, map2;

	static int[] airPos = new int[2];  //공기청정기 위치
	
	//상 하 좌 우
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		int a=0;
		
		//입력변수들 입력받기
		R = Integer.parseInt(st.nextToken());  //map의 세로크기
		C = Integer.parseInt(st.nextToken());  //map의 가로 크기
		T = Integer.parseInt(st.nextToken());  //T초 후
		
		//map 크기 선언
		map = new int[R][C];
		map2 = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st =  new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); //map 입력받기
				
				if(map[i][j] == -1 ) {  //공기청정기 위치 미리 받아놓기(2개)
					airPos[a++] = i;
				}
			}
		}
		
		
		//T초 반복
		for (int i = 0; i < T; i++) {
			//미세먼지 학산
			func1();			
			
			//공기청정기 작동
			func2();
		}
		
		//T 초 후 map의 미세먼지 수 세기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {				
				if(map[i][j]==-1) continue;			
				result += map[i][j];
			}
		}
		System.out.println(result); //결과 출력
	}
	
	//미세먼지 확산
	static void func1() {
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				//map[i][j] 에 대해 하나씩 검사
				if(map[i][j]== -1) continue; //공기청정기면 패쓰
				
				int A = map[i][j];  //현재자리의 미세먼지 양
				int cnt = 0;       //상화좌우 확산가능한 수
				//4방 탐색
				for (int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					//범위확인 & 공기청정기 자리면 확산 x
					if(ny<0 || nx<0 || ny>=R || nx>=C || map[ny][nx] == -1) continue;
					map2[ny][nx] += (A/5);  //map2라는 새로운 배열에 값들 저장 -> 계속 업데이트 해줘야해서
					cnt++;	//확산수				
				}
				
				map2[i][j] += A - ((A/5)*cnt); //현재자리에 남아야하는 미세먼지 수 계산
			}
		}
		//map2에 공기청정기 자리 업데이트
		map2[airPos[0]][0] = -1;
		map2[airPos[1]][0] = -1;
		
		//확산이 모두 끝났으면 map으로 값 복사 
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = map2[i][j];
			}
		}
		//map2 는 초기화 
		for (int i = 0; i < R; i++) {
			Arrays.fill(map2[i], 0);
		}
		
	}
	
	//공기청정기 작동
	static void func2() {
		//공기청정기 위쪽
		//위 -> 아래
		for (int i = airPos[0]-1; i > 0; i--) {
			map[i][0] = map[i-1][0];
		}
		//오른쪽 -> 왼쪽
		for (int i = 0; i < C-1; i++) {
			map[0][i] = map[0][i+1];
		}
		//아래-> 위
		for (int i = 0; i < airPos[0]; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		//왼쪽->오른쪽
		for (int i = C-1; i > 1; i--) {
			map[airPos[0]][i] = map[airPos[0]][i-1];
		}
		
		map[airPos[0]][1] = 0;
		
		//공기청정기 아래쪽
		//아래-> 위
		for (int i = airPos[1]+1; i < R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		//오른쪽 -> 왼쪽
		for (int i = 0; i < C-1; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
		//위 -> 아래
		for (int i = R-1; i > airPos[1]; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		//왼쪽->오른쪽
		for (int i = C-1; i > 1; i--) {
			map[airPos[1]][i] = map[airPos[1]][i-1];
		}
		
		map[airPos[1]][1] = 0;
		
	}
}
