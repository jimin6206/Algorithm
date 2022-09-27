package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_사탕게임_3085 {

	static int N;  //N입력받기
	static char[][] map;  //사탕형태 입력받기
	static int result =0; //최종결과
	
	//그대로 상 하 좌 우  => 첨에 4방탐색만 했다가 틀렸음 !  => 하 우
	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, -1, 1, 0, 0};	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		//사탕의 상태 입력받기
		for (int i = 0; i < N; i++) {
			String empty = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = empty.charAt(j);
			}
		}
		
		//하나씩 4방탐색 하면서 자신과 다르면 교환 후 자신이 포함된 최고 길이를 업데이트 
		//바꾸지않았을 경우도 생각해주기 ( 5방탐색 )
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				//4방탐색 + 그대로
				for(int d=0; d<5; d++) {  
					int ny = i +dy[d];
					int nx = j +dx[d];
					if(ny < 0 || ny >=N || nx < 0 || nx>=N) continue;  //범위초과면 패스
					if( d>0 && map[i][j] == map[ny][nx]) continue;  //d=0이면 그대로 일 경우 //d>0 면 상하좌우 검사해줘야하는데 이웃하는 곳이 같은 색이면 패스
					
					//두개의 색 스왑
					char empty = map[i][j];  
					map[i][j] = map[ny][nx];
					map[ny][nx] = empty;
					
					//최대길이 검사
					int y_size=1;  //일단 자기색이 있으니까 초기값은 무조건 1
					int x_size=1;
					
					//세로로 최대 몇인지
					int index=1;
					while(ny-index >= 0 && map[ny][nx] == map[ny-index][nx]) { //위로 같은 색이 몇개있는지 계산
						y_size++;
						index++;
					}
					index=1;
					while(ny+index < N && map[ny][nx] == map[ny+index][nx]) {//아래로 같은 색이 몇개 있는 지 계산
						y_size++;
						index++;
					}
					
					//result에 결과 업데이트
					result = Math.max(result, y_size);
					
					//가로로 최대 몇인지
					index=1;
					while(nx+index < N && map[ny][nx] == map[ny][nx+index]) { //오른쪽으로 같은 색이 몇개있는지 계산
						x_size++;
						index++;
					}
					index=1;
					while(nx-index >= 0 && map[ny][nx] == map[ny][nx-index]) {//왼쪽으로 같은 색이 몇개 있는 지 계산
						x_size++;
						index++;
					}
					
					//result에 결과 업데이트
					result = Math.max(result, x_size);
					
					//스왑했던거 다시 돌려놓기
					empty = map[i][j];  
					map[i][j] = map[ny][nx];
					map[ny][nx] = empty;		
				}
			}
		}
		
		//결과 출력
		System.out.println(result);
	}
}
