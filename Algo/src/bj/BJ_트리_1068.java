package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_트리_1068 {
	
	static int N, result=0;
	static LinkedList<Integer>[] tree;
	static boolean[] check;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //노드의 수
		
		//tree 연결리스트 개수만큼 선언
		tree = new LinkedList[N]; 
		for (int i = 0; i < N; i++) {
			tree[i] = new LinkedList<>();
		}
		check = new boolean[N]; //삭제된 노드들 표시 
		//check는 모두 true로 초기값
		Arrays.fill(check, true);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(n!=-1) {  //n이 -1이면 루트노드
				tree[n].add(i); //그 외는 부모노드에 연결
			}
		}
		//삭제될 노드
		int delete = Integer.parseInt(br.readLine());
		
		queue.add(delete); //큐에 삭제될 노드를 담는다.
		while(!queue.isEmpty()) {  //큐가 빌때까지 반복
			int empty = queue.poll();
			check[empty] = false;  //삭제될 노드의 check를 false로 만들어준다
			
			for (int n : tree[empty]) { //삭제될 노드의 자식노드들도 모두 큐에 담는다.
				queue.add(n);
			}
		}
		//위의 while문이 끝나면 삭제될 노드들이 모두 삭제됨 
		for (int i = 0; i < N; i++) { //노드들 모두 검사
			int cnt=0;
			if(!check[i]) continue;  //false된 노드는 삭제된 노드이므로 continue
			for (int n : tree[i]) { //i노드의 자식노드들을 검사
				if(!check[n]) continue; //자식노드들이 지워진 노드이면 continue
				cnt++; //자식노드가 존재하면 cnt++
			}
			if(cnt==0) { //cnt가 0이면 자식노드가 없으므로 리프노드
				result++; //리프노드의 개수 카운트
			}
		}

		//결과출력
		System.out.println(result);
	}
}
