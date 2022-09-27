package pr;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

	public static void main(String[] args) {
		int b = 100;
		int w = 100;
		int[] t = {10};
		int result ;
		
		result = solution(b,w,t);
		
		System.out.println(result);

	}
	
	static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;  //시간
        Queue<Integer> queue = new LinkedList<>();
        
        int size = truck_weights.length;
        int i=0;
        int sum_weight = 0;       
        
        sum_weight += truck_weights[0];  
        queue.add(truck_weights[i++]);   //배열의 첫 트럭은 무조건 큐에 넣어줌
        answer++;  //1초 후

        while(i < size){   //트럭이 모두 큐에 올라갈때까지  반복

        	if(sum_weight + truck_weights[i] <= weight) {  //다리위의 무게에 트럭[i]의 무게를 더해도 weight을 안넘으면 
        		sum_weight += truck_weights[i];    //다리위에 올려도됨 -> 무게 추가
        		queue.add(truck_weights[i++]);
        		answer++;  //+1초
        	}
        	else{
        		queue.add(0);  //무게때문에 다음 트럭을 올리지못하면 0을 추가
        		answer++; //+1초
        	}
        	
        	if(queue.size() >= bridge_length) { //큐의 사이즈가 다리의 길이보다 크거나 같아지면
        		sum_weight -= queue.remove();   //다리에서 트럭을 내린다. 무게도 빼준다.
        	}
        	
		}
        answer += bridge_length;  //트럭을 모두 올리고 난 후, 마지막 트럭은 bridge_length초를 지나야 나옴.
        return answer;
    }

}
