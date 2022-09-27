package pr;

import java.util.HashSet;

public class 전화번호목록 {

	public static void main(String[] args) {
		String[] p = {"119", "97674223", "1195524421"};
		boolean a = solution(p);
		
		System.out.println(a);

	}
	
	static boolean solution(String[] phone_book) {

        HashSet<String> set = new HashSet<>();
        
        for (String str : phone_book) {
        	set.add(str);  //모든 전화번호를 Hashset에 담는다.(전화번호의 중복은 없음)
		}
        
        //전화번호 목록을 하나씩 검사
        for (int i = 0; i < phone_book.length; i++) {
			for (int j = 0; j < phone_book[i].length(); j++) { //하나의 전화번호를 길이를 0~전화번호길이-1 크기로 반복하며 자른다.
				if(set.contains(phone_book[i].substring(0,j))) return false;  //앞에서부터 자른 string이 set에 존재하는지 확인
			}
		}
        return true;
        
    }

}
