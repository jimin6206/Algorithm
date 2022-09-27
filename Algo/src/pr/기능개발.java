package pr;

import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {

	public static void main(String[] args) {
		int[] p = {93,30,55};
		int[] s = {1,30,5};
		
		int[] result;
		
		result = solution(p,s);
		
		for (int i : result) {
			System.out.println(i + " ");
		}
		
	}
	
	static int[] solution(int[] progresses, int[] speeds) {
		
		int size = progresses.length;  //사이즈 미리 계산
        int[] answer;  
        int[] result = new int[size];
        int count=0;
        int num=0;
        int c=0;
        
        //큐 생성
        Queue<Integer> queue = new LinkedList<>();
        
        //배열의 사이즈만큼 반복
        for (int i = 0; i < size; i++) {
        	//두개의 배열을 이용해서 남은 작업일 계산 (큐에 순서대로 추가)
        	if((100 - progresses[i]) % speeds[i] != 0) {
        		queue.add((100 - progresses[i]) / speeds[i] + 1) ;
        	}else {
        		queue.add((100 - progresses[i]) / speeds[i]) ;
        	}
		}
        
        //큐가 빌때까지 반복
        while(!queue.isEmpty()) {
        	count=1;  //한번에 몇개의 일이 나오는지 카운트
        	num = queue.remove();  //제일 첫번째 큐
        	
        	//큐가 더 남아있는지 확인 & 다음꺼와 비교해서 작간이 더 짧으면(이미 완료된 작업) count+1 시켜주고 해당큐까지 같이 삭제
        	while(!queue.isEmpty() && num >= queue.peek()) {
        		count++;
        		queue.remove();
        	}
        	
        	//result배열에 한꺼번에 나온 작업의 양 저장(count)
        	result[c++] = count;

        }
        
        //result배열에 인덱스 c까지만 값이 들어갔으므로 c만큼 할당
        answer = new int[c];
        for (int i = 0; i < c ; i++) {
			answer[i] = result[i];  //c만큼 배열복사
		}
 
        //결과
        return answer;
    }
}
