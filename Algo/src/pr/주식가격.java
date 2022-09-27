package pr;

import java.util.LinkedList;
import java.util.Queue;

public class 주식가격 {

	public static void main(String[] args) {
		int[] p = {1,2,3,2,3};
		int[] result;
		
		result = solution(p);
		
		for (int i : result) {
			System.out.print(i + " ");
		}
		

	}
	static int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];
        int num;
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < size; i++) {
			queue.add(prices[i]);  //모든 주식가격을 큐에 담는다
		}
        
        for (int i = 0; i < size; i++) {			
        	num = queue.remove();  //큐의 첫번째 가격을 삭제.
        	
        	for (int n : queue) {  //남아있는 큐를 돌면서 자신의 값과 비교
				if(num <= n) answer[i]++;  //떨어지지않았으면 i자리에 +1
				else {
					answer[i]++;  //떨어졌으면 1초뒤에 떨어진 거라서 +1 해준 뒤 break
					break;
				}
			}
        }
        
        return answer;  //결과 출력
    }

}
