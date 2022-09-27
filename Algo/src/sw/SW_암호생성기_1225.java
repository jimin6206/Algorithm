package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_암호생성기_1225 {
	
	static int N;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int current;
		
		for (int t = 1; t <= 10; t++) { 
			N= Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//8개 정수 입력받기
			for (int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			int k=1;
			
			while(true) {
				
				if(k>5) {
					k=1;
				}
				
				current = queue.remove();
				
				if(current-k <= 0) {
					queue.add(0);
					break;
				}
				queue.add(current - k);
				k++;
				
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(queue.remove() +" ");
			}
			System.out.println();
			
		}

	}
}
