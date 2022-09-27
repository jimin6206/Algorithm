package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_완전이진트리_9934 {

	static int K;
	static int num;
	static int[] tree;
	static ArrayList<Integer>[] result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());  //완전이진트리의 깊이
		num = (int)(Math.pow(2, K)-1);  //완전이진트리의 노드개수
		tree = new int[num];  //상근이가 방문한 순서대로 모든 노드 담기
		result = new ArrayList[K];  //결과
		
		for (int i = 0; i < K; i++) {
			result[i] = new ArrayList<>();  //리스트 초기화
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());	
		for (int i = 0; i < num; i++) {				
			tree[i] = Integer.parseInt(st.nextToken());  //상근이가 방문한 순서
		}
		
		inorder(0,num-1,0);  //중위순회
		
		for (int i = 0; i < K; i++) {
			for (int j : result[i]) {
				System.out.print(j + " ");  //결과출력
			}
			System.out.println();  //depth마다 다음줄로
		}
		
	}
	
	//중위순회
	static void inorder(int start, int end, int depth) {
		if(start == end) {
			//더이상 쪼갤수 없으니까 그만
			result[depth].add(tree[start]);
			return;
		}
		
		//계속 반쪼개서 중간값이 트리의 루트 -> 재귀로 표현
		int root = (start+end)/2;
		result[depth].add(tree[root]);
		inorder(start, root-1, depth+1);
		inorder(root+1, end, depth+1);	
	}
}






