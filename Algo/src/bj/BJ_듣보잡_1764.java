package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ_듣보잡_1764 {
	
	static TreeSet<String> treeSet1 = new TreeSet<>();
	static TreeSet<String> treeSet2 = new TreeSet<>();
	
	public static void main(String[] args) throws Exception{

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt=0;
		int N = Integer.parseInt(st.nextToken()); //듣도 못한 사람 수
		int M = Integer.parseInt(st.nextToken()); //보도 못한 사람 수
		
		//TreeSet은 정렬되어서 저장됨
		//듣도 못한 사람 입력 받기
		for (int i = 0; i < N; i++) {
			treeSet1.add(br.readLine());
		}

		//보도 못한 사람 입력 받기
		for (int i = 0; i < M; i++) {
			treeSet2.add(br.readLine());
		}
		
		//듣도 보도 못한 사람  찾기
		for (String str : treeSet2) {  //보도 못한 사람들을 하나씩 꺼내오기
			if(treeSet1.contains(str)) { //듣도못한 사람들에 있으면 
				cnt++;  //cnt 증가
				sb.append(str).append("\n");  //사람 이름 출력			
			}
		}
		
		//결과 출력
		System.out.println(cnt);
		System.out.println(sb);

	}
}
