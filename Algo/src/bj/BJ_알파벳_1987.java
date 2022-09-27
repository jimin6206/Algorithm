package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_알파벳_1987 {

	static int R,C,count=0,max_value=0;
	static char[][] map;
	static boolean[] check = new boolean[26];  //알파벳 사용한 것 체크
	
	//상 하 좌 우
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//입력받기
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());		
		map = new char[R][];		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		dfs(0,0,0);  //dfs함수 호출
		
		System.out.println(max_value);
	}
	
	//i : y좌표, j : x좌표, m : 이동횟수
	static void dfs(int i, int j, int m) {		
		
		//이미 방문한 알파벳일 경우 현재까지의 m을 max_value와 비교
		if(check[map[i][j]-'A']) {
			max_value = Math.max(max_value, m);
			return;
			
		} else {  //방문한 알파벳이 아닐경우
			check[map[i][j]-'A'] = true;   //해당알파벳 배열에 true
			for (int d = 0; d < 4; d++) {  //4방탐색
				int ny = i + dy[d];
				int nx = j + dx[d];
				if(ny < 0 || nx < 0 || ny >= R || nx >= C ) continue; //범위확인
								
				dfs(ny,nx,m+1);  //해당좌표로 dfs 호출 (m+1)
			}	
			//4방 탐색을 다하고  해당 알파벳배열을 다시 false로 초기화
			check[map[i][j]-'A'] = false;
		}
	}
}
