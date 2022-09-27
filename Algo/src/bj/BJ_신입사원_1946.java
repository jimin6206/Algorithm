package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_신입사원_1946 {

	static int T, N, cnt=0;
	static int[] emp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); //테케 수
		
		//테케만큼 반복
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			emp = new int[N]; //지원자 수만큼 할당
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				emp[Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
			}//순위를 배열에 넣을때 서류심사 순으로 배열에 저장한다.
		
			
			cnt=1;
			int empty = emp[0]; //서류심사 1등은 무조건 통과 

			for (int i = 1; i < N; i++) {  //1번부터  N-1 번검사
				if(empty > emp[i]) { //통과한 사람의 면접등수를 비교해가며 통과한 면접 등수보다 높으면 통과
					empty = emp[i]; //통과 등수를 업데이트
					cnt++; //통과한 사람 수 증가
				}
			}
			//결과 출력
			System.out.println(cnt);
		}
	}
}
