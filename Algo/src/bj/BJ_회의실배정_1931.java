package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_회의실배정_1931 {

	static int N, cnt=0, s=0, e=0;
	static ArrayList<Meeting> room = new ArrayList<>();  //회의실 정보를 리스트로 담기
	
	static class Meeting implements Comparable<Meeting>{ //회의 클래스
		int start; //시작시간
		int end;   //끝나는시간
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) { //끝나는 시간을 기준으로 정렬
			if(this.end == o.end) {
				return this.start - o.start;  //만약 끝나는 시간이 같으면 시작시간을 우선순위로
			}
			return this.end - o.end;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());  //회의개수

		for (int i = 0; i < N; i++) { //N개의 회의 정보를 리스트에 담기
			StringTokenizer st = new StringTokenizer(br.readLine());
			room.add( new Meeting( Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()) ) );
		}
		
		//끝나는 시간을 기준으로 오름차순 정렬
		room.sort(Comparator.naturalOrder()); 
		
		for (int i = 0; i < N; i++) {
			if(e <= room.get(i).start) { //이전 회의가 끝난 시간 -> 다음에 가장 빨리 시작하는 회의 
				s = room.get(i).start;
				e = room.get(i).end;
				cnt++;  //count
			}
		}
		//결과 출력
		System.out.println(cnt);
	}
}
