package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_단어암기_18119 {

	static int N,M;
	static long[] word;
	static long remember = (1<<26)-1; //처음엔 알파벳 모두 기억
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());  //단어의 개수
		M = Integer.parseInt(st.nextToken());  //쿼리의 개수
		
		word = new long[N]; //단어를 배열로 표현 (단어는 비트로 표현)   ex) abc = > ...000111
		
		for (int i = 0; i < N; i++) { //N개의 단어 입력받기
			String str = br.readLine();  //문자열을 입력받고
			for (int j = 0; j < str.length(); j++) {  //문자열의 길이만큼
				int ch = str.charAt(j) - 'a';   //해당알파벳을 숫자로 변환
				word[i] |= (1<<ch);   //word배열에 알파벳자리를 1로 바꿔줌
			}
		}
		
		//M개의 쿼리 수행
		for (int i = 0; i < M; i++) {
			int cnt=0;  //완전히 알고있는 단어의 개수 카운트
			st = new StringTokenizer(br.readLine());
			int o = Integer.parseInt(st.nextToken()); //1 or 2
			int x = st.nextToken().charAt(0) - 'a';  //알파벳을 숫자로 변환해서 입력받기
			
			switch(o) { 
				case 1:  //1이면 x 알파벳을 잊어야하므로 
					remember &= ~(1<<x);  //remember에서 x자리를 0으로 만들어준다
					break;
				case 2:  //2이면 x 알파벳을 기억해야하므로
					remember |= (1<<x);  //remember에서 x자리를 1로 만들어준다.
					break;
			}
			//단어의 개수만큼 반복
			for (int j = 0; j < N; j++) {
				if((word[j] & remember) == word[j]) { //단어의 1인 비트가 remember의 1인 비트와 완전히 일치하면
					cnt++;  //cnt 증가
				}
			}
			//결과 출력
			System.out.println(cnt);
		}
	}
}
