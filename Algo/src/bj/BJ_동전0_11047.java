package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_동전0_11047 {

	static int N,K, cnt=0;
	static int[] coin; //가지고 있는 동전
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //동전의 종류
		K = Integer.parseInt(st.nextToken()); //만들어야할 K원
		int index=0;
		
		coin = new int[N]; //동전의 종류를 N크기만큼 할당
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine()); //배열에 동전의 값을 담는다
			if(coin[i] <= K) {  //K원보다 작거나 같으면 index를 업데이트
				index = i;  //coin이 오름차순이므로 K보다 작거나 같은 최대의 값의 인덱스가 저장됨
			}
		}
		
		while(K != 0) { //K가 0이 될때까지 반복
			cnt += K / coin[index]; //index번재 돈으로 나눈 크기 만큼 cnt에 +
			K = K % coin[index]; //K는 위에 나눈만큼 빼준다 => 즉, 나머지를 저장
			index--; //index를 줄인다
		}
		
		System.out.println(cnt); //결과 출력
	}
}
