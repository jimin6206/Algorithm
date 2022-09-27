package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_문자열집합_14425 {
	
	static int N,M, cnt=0;
	static HashMap<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     
	     //N,M입력받기
	     N = Integer.parseInt(st.nextToken());  
	     M = Integer.parseInt(st.nextToken());

	     for (int i = 0; i < N; i++) {
	    	 map.put(br.readLine(), i);  //집합 S에 있는 문자열들을 map에 저장
	     }
	     
	     for (int i = 0; i < M; i++) {
	    	 String str = br.readLine();  //M개의 데이터를 받아와서
	    	 if (map.get(str) != null) {  //str 문자열이 map에 있으면 cnt증가
	                cnt++;
	         }
	     }
	     System.out.println(cnt); //결과 출력
	}
}