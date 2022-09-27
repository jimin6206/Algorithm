package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BJ_수강신청_13414 {

	static int K,L,cnt=0;
	static LinkedHashSet<String> set = new LinkedHashSet<>(); //저장순서를 지키기 위해 LinkedHashSet 이용
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());  //수강가능인원
		L = Integer.parseInt(st.nextToken());  //클릭한 학생들
		 
		//L번의 학번을 읽어오기
		for (int i = 0; i < L; i++) {
			String student = br.readLine();  //클릭한 학번을 읽어서
			if(set.contains(student)) {   //학번이 set에 포함되어있으면 (이미 클릭한 학생) 
				set.remove(student);      //해당 학생을 삭제하고
				set.add(student);         //다시 추가 (제일 마지막으로 저장)
			}else {
				set.add(student);  //set에 포함되어있지 않으면 바로 추가
			}
		}
		
		for (String str : set) { //set에 저장된 학번을 순서대로 출력
			if(cnt>=K) break;   //K개만 출력
			System.out.println(str); //결과 출력
			cnt++; //cnt : 출력된 사람 수
		}
	}
}
