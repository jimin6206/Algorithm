package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_시간표짜기_14569 {

	static int N, M;
	static long[] subject;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //과목 수
		subject = new long[N]; //과목수만큼 배열 할당
		//N개의 과목 정보 받아오기
		for (int i = 0; i < N; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken()); //각 과목의 수업시간 수
			
			for (int j = 0; j < k; j++) {
				int t = Integer.parseInt(st.nextToken());
				subject[i] |= ((long)1<<t);  //해당과목에 교시를 업데이트한다 (t자리를 1로 만들기)
			}
		}
		
		M = Integer.parseInt(br.readLine()); //학생 수
		for (int i = 0; i < M; i++) {
			int cnt=0;  //학생이 들을수 있는 후보과목 개수(초기화)
			long student = 0;  //학생의 시간표중에 빈 시간을 1로 표시
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()); //비어있는 교시의 개수
			
			for (int j = 0; j < p; j++) {
				int q = Integer.parseInt(st.nextToken()); 
				student |= ((long)1<<q); //학생의 시간표를 업데이트 (q자리를 1로 만들기)			
			}
			
			//과목수만큼 반복
			for (int j = 0; j < N; j++) {
				if((student & subject[j])== subject[j]) { //과목이 1인자리에 student도 1이면  & 연산하면 subject[j]와같은 값이 나오게  됨
					cnt++;  //들을 수 있는 과목이니까 cnt+1
				}
			}
			
			System.out.println(cnt);  //결과 출력
		}
	}

}
