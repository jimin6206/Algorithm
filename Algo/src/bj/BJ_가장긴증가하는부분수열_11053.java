package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_가장긴증가하는부분수열_11053 {

	static int N, max_A=0, max_value=1;
	static int[] A, result;	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());  // 수열의 크기 입력받기
		
		A = new int[N];   //A는 입력으로 들어오는 수열
		result = new int[N];  //최대 증가하는 부분 수열을 담을 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());  //입력 수열
		}
		
		result[0]=1;  //처음 수열은 자기자신밖에 없으므로 무조건 1
		
		//두번째 수부터 N까지 각 자리까지의 증가하는 부분 수열 개수를 넣을 것 !
		for (int i = 1; i < N; i++) {
			max_A=0;  
			for (int j = i-1; j >=0; j--) {  //자신 인덱스부터 0까지 거꾸로 검사
				if(A[i] > A[j]) {  //자신보다 작은 수만 검사
					max_A = Math.max(max_A, result[j]);//자신보다 작은수 들중에서 result가 가장 큰 수를 업데이트
				}
			}
			result[i] = max_A + 1;  //i번째 결과는 위에서 찾은 result가 가장 큰 수 에 1을 더한다.
			max_value = Math.max(max_value, result[i]);  //result 배열중에서 가장 큰 수 찾기
		}
		
		System.out.println(max_value);  //결과 출력
	}
}
