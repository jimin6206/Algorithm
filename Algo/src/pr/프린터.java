package pr;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {

	public static void main(String[] args) {
		int[] pri = {1,1,9,1,1,1};
		int location = 0;
		int result =0;
		result = solution(pri, location);
		System.out.println(result);


	}
	
	static int solution(int[] priorities, int location) {
		
		Queue<int[]> queue = new LinkedList<>();  //큐에 초기인덱스값과 중요도를 같이 저장
		int i=0;                                  //배열의 초기인덱스값
		int[] num = new int[2];                   //큐의 가장 앞에있는 문서를 받을 변수
		boolean max;                              //현재값의 중요도가 가장 큰지 아닌지 확인하는 변수
		int answer = 0;                           //결과값
		
		//입력값을 큐에 저장 (인덱스값과 함께 저장)
		for (int p : priorities) {  
			queue.add(new int[] {i++, p});
		}
		
		//큐의 값이 있으면 무한반복  -> location을 이용해 while 탈출
		while(!queue.isEmpty())
		{
			max = true;
			num = queue.remove();   //제일 앞에았는 값 num에 저장
			
			for (int[] n : queue) {  //큐를 돌면서  num보다 큰값이 있는지 확인
				if(num[1] < n[1]) {
					queue.add(num);  //있으면 num을 제일 뒤에 추가
					max = false;     //현재값의 중요도가 가장 큰게 아니니까 false
					break;           // 하나만 있어도 for문 더 돌 필요없음
				}
			}
			
			if(max == true) {      //다 돌고나서도 max값이 true면 현재 값의 중요도가 젤 큰거임
				answer++;          //인쇄할때마다 answer증가 
				if(num[0] == location) {   //현재 인쇄된 인덱스를 location이랑 비교 후 
					break;                 //같으면 답을 찾았으므로 break;
				}
			}
		}
		
		//결과 return
        return answer;
    }
}
