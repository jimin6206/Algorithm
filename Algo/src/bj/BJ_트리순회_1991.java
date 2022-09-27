package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_트리순회_1991 {

	static int N;  
	static HashMap<String, List<String>> map = new HashMap<>();  //트리 구현
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());  //노드의 개수
		
		//트리 입력받기
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<String> list = new ArrayList<>();
			
			String root = st.nextToken(); //자기 노드와
			list.add(st.nextToken());     //자식노드(list)를 Map으로 담기
			list.add(st.nextToken());
			
			map.put(root, list);  //map.get(root).get(0) : 왼쪽자식노드
			                      //map.get(root).get(1) : 오른쪽자식노드
		}
			
		//전위순회
		preorder("A");
		sb.append("\n");
		
		//중위순회
		inorder("A");
		sb.append("\n");
		
		//후위순회
		postorder("A");
		sb.append("\n");
		
		System.out.println(sb);  //결과출력
	}
	
	//전위순회
	static void preorder(String s) {
		if(s.equals(".")) return;  //자식노드가 없으면 return
		//순서 : 자신-> 왼쪽자식노드 -> 오른쪽자식노드
		sb.append(s);                 //자신노드 		
		preorder(map.get(s).get(0));  //왼쪽자식노드
		preorder(map.get(s).get(1));  //오른쪽자식노드
	}
	
	//중위순회
	static void inorder(String s) {
		if(s.equals(".")) return;
		//순서 : 왼쪽자식노드 -> 자신노드 -> 오른쪽자식노드
		inorder(map.get(s).get(0));  //왼쪽자식노드
		sb.append(s);                //자신노드
		inorder(map.get(s).get(1));  //오른쪽자식노드
	}
	
	//후위순회
	static void postorder(String s) {
		if(s.equals(".")) return;
		//순서 : 왼쪽자식노드 -> 오른쪽자식노드 -> 자신노드
		postorder(map.get(s).get(0));  //왼쪽자식노드		
		postorder(map.get(s).get(1));  //오른쪽자식노드
		sb.append(s);                  //자신노드
	}
}
