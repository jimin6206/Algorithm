package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_치킨배달_15686_2 {
	
	static int N, M, min;
	static List<int[]>house, src, tgt;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		house = new ArrayList<int[]>();  //집들
		src = new ArrayList<int[]>();    //치킨집 전체(src)
		tgt = new ArrayList<int[]>();    //M 개의 치킨 집(tgt) (조합의 결과)
		
		StringTokenizer st = new StringTokenizer(br.readLine());	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a==1) house.add(new int[] {i,j});
				else if(a==2) src.add(new int[] {i,j});
			}
		}
		
		
		min = Integer.MAX_VALUE;
		
		comb(0,0);
		
		System.out.println(min);
	}
	
	//for
	static void comb(int srcIdx, int tgtIdx) {
		//기저조건
		if(tgtIdx == M) {
			//complete code
			int sum = 0;  //치킨 거리의 총합
			
			for (int i = 0; i < house.size(); i++) {  //각각의 집에 대해서 최소값
				
				int dist = Integer.MAX_VALUE;  //치킨거리
				
				for (int j = 0; j < M; j++) {
					// i 집 - 치킨집 거리
					dist = Math.min(
						dist, 
						Math.abs(house.get(i)[0] - tgt.get(j)[0]) + Math.abs(house.get(i)[1] - tgt.get(j)[1])
					);
				}
				sum += dist;
			}
			
			//sum : 현재 조합(치킨 집)에서 치킨 거리의 합
			min = Math.min(min, sum);
			
			return;
		}
		
		if(srcIdx == src.size()) return;
		
		tgt.add(src.get(srcIdx));
		comb(srcIdx+1, tgtIdx+1);
		tgt.remove(src.get(srcIdx)); // 배열과 다르다!
		comb(srcIdx+1, tgtIdx);
	}
}
