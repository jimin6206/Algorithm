package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_ATM_11399 {

	static int N,sum=0, result=0;
	static int[] P; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		N = Integer.parseInt(br.readLine()); //사람 수
		P = new int[N]; //걸리는 시간을 담은 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());  //걸리는 시간을 배열에 담는다
		}
		
		//대기시간의 합이 최소가 되려면 P가 오름차순이면 된다
		Arrays.sort(P);
 

		for (int i = 0; i < N; i++) {
			sum += P[i]; //각 사람의 대기시간
			
			result += sum;  //대기시간의 총합
		}
		System.out.println(result); //결과 출력
	}
}


