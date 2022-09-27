package bj;

import java.io.*;
import java.util.*;

public class BJ_16953_AB {
	
	static long A,B;
	static int cnt=1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//A와 B입력받기
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		//풀이방법 : B에서부터  [ 2로 나누거나(짝수면) / 젤 오른쪽수 1을 떼거나(1의자리수가 1이면) ]  이 두가지를 반복해가며 A와 일치하면 stop 
		while(true) {
			if(B==A) {  //일치하면 stop
				break;
			}else if(B < A) { //B가 A보다 작아지면 -1 출력 (만들수 없음) B가 A가 되는 과정은 무조건 작아지는 과정이므로 A보다 작아진 순간 A가 될 수 없다.
				cnt=-1; //-1출력
				break;
			}
			
			if(B%2==0) { //짝수인 경우 2로 나눈다
				B = B/2;
				cnt++;  //count
			}else {  
				if(B%10==1) { //홀수인 경우는 일의자리가 1인 수만 취급
					B = B/10;  //10으로 나눠버리면 1의자리 떨어짐
					cnt++; //count
				}else {  //그 외의 홀수는 A가 될 수 없음 (2로 나눌수도 없고, 1을 뗄수도 없으므로)
					cnt=-1;  //-1출력
					break;
				}
			}
		}
		//결과 출력
		System.out.println(cnt);
	}
}
