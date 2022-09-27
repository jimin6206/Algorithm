package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_햄버거분배_19941 {

	static int N, K, index_h=-1, index_p=-1, cnt=0;
	static char[] input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		input = new char[N];
		String str = br.readLine();

		for (int i = 0; i < N; i++) {
			input[i] = str.charAt(i);  //햄버거와 사람을 담은 배열
		}
		
		//배열중에서 제일 앞에 있는 햄버거의 인덱스
		for (int i = 0; i < N; i++) {
			if(input[i] == 'H') {
				index_h = i;
				break;
			}
		}
		//배열중에서 제일 앞에 있는 사람의 인덱스
		for (int i = 0; i < N; i++) {
			if(input[i] == 'P') {
				index_p = i;
				break;
			}
		}
		
		while(true) {
			if(index_p==-1 || index_h==-1) break; //둘 중 하나가 -1이면 햄버거 또는 사람이 하나도 없다는 의미 => 즉, cnt=0이다.
			if(index_p >= N) break; //인덱스가 범위를 벗어나면 stop
			if(index_h >= N) break;
			
			if(Math.abs(index_h - index_p) <= K) {  //햄버거와 사람의 인덱스 차이가 K이하면 먹을 수 있음
				cnt++;  //카운트증가
				while(++index_h < N) {  //index_h는 다음 햄버거의 위치를 가르켜야함
					if(input[index_h] == 'H') { //인덱스를 증가시키면서 'H'와 일치하면 stop
						break;
					}
				}
				while(++index_p < N) {   //index_p는 다음 사람의 위치를 가르켜야함
					if(input[index_p] == 'P') {   //인덱스를 증가시키면서 'P'와 일치하면 stop
						break;
					}
				}
			}else {  //먹지 못하는 경우 더 작은 인덱스만 증가시킨다 
				if(index_h < index_p) {  //햄버거가 더 앞에있는 경우 다음 햄버거를 가르킴
					while(++index_h < N) {
						if(input[index_h] == 'H') {
							break;
						}
					}
				}else { //사람이 더 앞에 있는 경우 다음 사람을 가르킴
					while(++index_p < N) {
						if(input[index_p] == 'P') {
							break;
						}
					}
				}
			}
		}
		//결과 출력
		System.out.println(cnt);
	}
}
