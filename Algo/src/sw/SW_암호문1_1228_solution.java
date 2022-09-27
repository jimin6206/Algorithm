package sw;

//다시하기
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW_암호문1_1228_solution {

	static int N,M;
	static LinkedList<String> list = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//10개의 테케
		for (int t = 1; t <= 10; t++) {
			//초기화
			list.clear();
			
			N = Integer.parseInt(br.readLine());   // 첫째 줄
			StringTokenizer st = new StringTokenizer(br.readLine());  // 둘째 줄
			//N개의 수 입력받기
			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());
			}
			
			M = Integer.parseInt(br.readLine());  // 셋째 줄
			st = new StringTokenizer(br.readLine());  // 넷째 줄
			for (int i = 0; i < M; i++) {
				st.nextToken();   //I 처리
				int x = Integer.parseInt(st.nextToken());  //인덱스
				int y = Integer.parseInt(st.nextToken());  //문자열 수
				
				int size = x+y;  //x의 위치에 y개 만큼 문자열 추가
				
				for (int j = x; j < size; j++) {
					list.add(j, st.nextToken());
				}				
			}
			

			System.out.print("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i)+ " ");
			}
			System.out.println();
			
		}
	}

}
