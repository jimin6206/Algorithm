package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_햄버거다이어트_5215 {
	
	static int T,N,L;
	static int[][] hamburger;     //재료의 맛점수,칼로리를 2차원배열로 받음
	static boolean[] isSelected;  //부분집합만들때 포함인지 아닌지 여부를 결정
	static int cal=0, sum=0, best=0;

	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//테케수 입력받기
		T = Integer.parseInt(br.readLine());
		
		//테케 수 만큼 반복
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			//배열을 N크기만큼 할당
			hamburger = new int[N][2];
			isSelected = new boolean[N];
			
			//입력처리
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				hamburger[i][0] = Integer.parseInt(st.nextToken());  //맛점수
				hamburger[i][1] = Integer.parseInt(st.nextToken());  //칼로리
			}
			
			//테케별로 best 초기화
			best=0;
			
			//ham 함수를 이용한 계산 -> 재귀함수를 이용해 부분집합을 구함
			ham(0);  
			
			//출력
			System.out.println("#" + t + " " + best);

		}
	}
	
	static void ham(int cnt) {
		
		if(cnt == N) { //부분집합 완성
			cal=0;    //cal,sum 초기화
			sum=0;
			for (int i = 0; i < N; i++) {   //N번만큼 반복하며 
				if(isSelected[i]==true) {   //포함된 인덱스만 cal, sum에 더해준다
					cal += hamburger[i][1];
					sum += hamburger[i][0];
				}
			}
			if(cal<=L) {      //해당 부분집합의 칼로리가 L이하이면
				if(best < sum) {  //sum 중에 best를 업데이트 
					best = sum;
				}
			}
			
		}else {  
			isSelected[cnt] = true;
			ham(cnt+1);   //현재자신이 포함일때의 재귀호출
			isSelected[cnt] = false;
			ham(cnt+1);   //현재자신이 불포함일때의 재귀호출
		}
	}
}
