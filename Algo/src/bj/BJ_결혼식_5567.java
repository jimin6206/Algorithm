package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ_결혼식_5567 {

	static int n,m,cnt=0;
	static LinkedList<Integer>[] map;
	static Queue<Integer> queue = new LinkedList<>();
	static boolean[] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());   //동기 수
		m = Integer.parseInt(br.readLine());   //인접 관계 수
		
		map = new LinkedList[n+1];
		check = new boolean[n+1];
		
		for (int i = 1; i <= n; i++) {
			map[i] = new LinkedList<>();
		}
		
		//연결리스트 만들기(인접노드)
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a].add(b);
			map[b].add(a);
		}	
	
		//1의 친구를 모두 큐에 담기
		for (int i : map[1]) {
			queue.add(i);
		}
		
		//큐에 담긴 친구의 친구까지만 검사
		while(!queue.isEmpty()) {
			int empty = queue.poll();  //1의 친구 empty
			check[empty] = true;  
			
			for (int i : map[empty]) {  //empty의 친구
				check[i] = true;
			}
		}
		
		//check배열에 true인 사람들은 결혼식 참석 => cnt
		for (int i = 2; i <= n; i++) {
			if(check[i] == true) {
				cnt++;
			}
		}
		
		System.out.println(cnt);  //결과
	}
}
