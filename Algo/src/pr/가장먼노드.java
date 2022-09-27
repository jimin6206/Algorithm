package pr;

import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {

	public static void main(String[] args) {
		int n = 6;
		int[][] v = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		
		System.out.println(solution(n,v));
	}
	
	static int solution(int n, int[][] edge) {
        int answer = 0;
        LinkedList<Integer>[] graph = new LinkedList[n+1];  //인접리스트로 구현  (인접배열로 구현하면 메모리초과뜸)
        int[] depth = new int[n+1]; //각 정점과 1과의 깊이를 나타냄
        int max=0; //최대깊이
        Queue<Integer> queue = new LinkedList<>();
        
        //간선을 인접리스트로 구현
        for (int[] e : edge) { 	
        	if(graph[e[0]] == null) graph[e[0]] = new LinkedList<>();
        	if(graph[e[1]] == null) graph[e[1]] = new LinkedList<>();
			graph[e[0]].add(e[1]);
			graph[e[1]].add(e[0]);
		}
        //정점 1부터 시작
        queue.add(1);
        //큐가 빌때까지 반복
        while(!queue.isEmpty()) {
        	int num = queue.remove();  //첫번째 정점
        	
        	for (int i : graph[num]) {  //num과 인접한 정점 모두 검사
        		if(depth[i]==0) {    //depth이 0이면 처음 방문한거니까 num의 깊이에서 +1
					depth[i] = depth[num]+1;
					queue.add(i);  //큐에 추가
				}
				else if(depth[i] > depth[num]+1) {  //depth이 0이 아니면 이미 방문했다는 의미
					depth[i] = depth[num]+1;     //depth의 깊이가 현재 num의깊이+1 보다 크면 num을 거쳐가는것이 최단경로임
					queue.add(i);                //이렇게 깊이를 업데이트
				}
			}
        }
        
        //while문이 끝나면 depth배열이 완선되어있다. -> 여기서 최대깊이를 찾고 그 깊이의 정점이 몇개인지 찾으면 됨
        for (int i = 2; i <= n; i++) {  //2~n 까지 반복
        	if(max < depth[i]) {   //최대깊이 찾아서 업데이트
        		max = depth[i];
        		answer=1;          //최대깊이이면 answer을 1로 초기화
        	}else if(max == depth[i]) {  //현재 깊이가 max랑 같으면 answer+1
        		answer++;
        	}
		}
        //결과
        return answer;
    }
}
