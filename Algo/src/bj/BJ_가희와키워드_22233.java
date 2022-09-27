package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_가희와키워드_22233 {

	static int N, M;
	static HashSet<String> set = new HashSet<>();  //HashSet 에 키워드를 저장
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());  //키워드 개수
		M = Integer.parseInt(st.nextToken());  //블로그에 쓴 글의 개수
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());  //키워드를 set에 전부 저장
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), ","); //한줄씩 "," 롤 기준으로 끊는다.
			
			while(st.hasMoreTokens()) { //st에 token이 있으면 반복
				set.remove(st.nextToken()); //set에서  삭제
			}
			
			System.out.println(set.size());  //남은 set의 키워드 개수
		}

	}

}
