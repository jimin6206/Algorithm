package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_서로소집합_3289 {
	
	static int T,n,m;
	static int[] parent;  //자신이 속해있는 집합의 대표
	static StringBuilder sb;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());  //테케수 입력받기
		
		//테케만큼 반복
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());  //원소 수
			m = Integer.parseInt(st.nextToken());  //연신 수
			
			parent = new int[n+1];
			
			makeSet();  
			
			sb = new StringBuilder("#").append(t).append(" ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if(op==0) { //0이면 x,y 합집합연산
					union(x,y);
				} else if(op == 1) {  //1이면 x,y가 같은집합인지 확인
					if(findSet(x) == findSet(y)) sb.append("1");
					else sb.append("0");
				}
			}
			
			//결과 출력
			System.out.println(sb);
			
		}
	}
	
	//단위집합 생성
	static void makeSet() {
		//자신의 부모노드를 자신의 값으로 세팅
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}
	//a의 집합 찾기 : a의 대표자 찾기
	static int findSet(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);  //path compression
	}
	//a,b 두 집합 합치기
	static void union(int x, int y) {
		int py = findSet(y);
		int px = findSet(x);
		
		if(px < py) parent[py] = px;
		else parent[px] = py;
	}
	
//	//a,b 두 집합 합치기
//	static boolean union(int x, int y) {
//		int py = findSet(y);
//		int px = findSet(x);
//		
//		if(px == py) return false;
//		
//		parent[py] = px;
//		return true;
//	}
}
