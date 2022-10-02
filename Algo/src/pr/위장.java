package pr;

import java.util.HashMap;
import java.util.Iterator;

public class 위장 {

	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"} };
		
		int result;
		result = solution(clothes);
		System.out.println(result);
	}
	
	static public int solution(String[][] clothes) {
        int answer = 1;
        
        //HashMap을 이용해 옷의 종류와 개수를 매핑한다.
        HashMap<String,Integer> hashmap = new HashMap<>();
        
        for (String[] cloth : clothes) {
        	hashmap.put(cloth[1], hashmap.getOrDefault(cloth[1], 0) +1);  //옷의 종류  : 개수+1
		}
        
        Iterator<String> keySetIterator = hashmap.keySet().iterator();
        while (keySetIterator.hasNext()) {
            answer *= hashmap.get(keySetIterator.next()) +1; 
        }
        
        return answer-1;
    }

}
