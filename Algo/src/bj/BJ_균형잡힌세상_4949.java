package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_균형잡힌세상_4949 {
	
	public static void main(String[] args) throws Exception{
		
		String str;
		boolean no;
		Stack<Character> stack = new Stack<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(!(str = br.readLine()).equals(".") ) {  //.이 입력될때까지 반복
			stack.clear();  //새로운 문장마다 stack을 clear
			no = false;
			
			//.이 나오면 한문장 완성이므로 '.' 만날때까지 str에 저장
			while(str.charAt(str.length()-1) !='.') {
				str = str + br.readLine();
			}
			//한문장씩 처리
			for (int i = 0; i < str.length(); i++) {
				
				char cc = str.charAt(i); //한 문자씩 cc에 저장
				
				if(cc == '(' || cc == '[') {  //'(','[' 부호가 나오면 stack에 push
					stack.push(cc);
				}
				else if(cc == ')'){  //')' 부호가 나오면 stack.peek()에서 '('이  나온경우 짝이 맞는것
					if( !stack.empty() && stack.peek() == '(') {
						stack.pop();
					}else {  //조건에 만족하지 못한 경우 짝이 맞지않으므로 break;
						no = true;
						break;
					}
				}
				else if(cc == ']') {  //']' 부호가 나오면 stack.peek()에서 '['이  나온경우 짝이 맞는것
					if(!stack.empty() && stack.peek() == '[') {
						stack.pop();
					}else {  //조건에 만족하지 못한 경우 짝이 맞지않으므로 break;
						no = true;
						break;
					}
				}
			}
			if(no) { //위에서 이미 짝이 맞지않다고 판단된 경우 -> no
				System.out.println("no");
			}
			else if(stack.empty()) { //stack이 비었으면 모든 짝이 맞는것이므로 -> yes
				System.out.println("yes");
			}else {  
				System.out.println("no");  //stack에 남아있으면 짝이 안 맞는 것 -> no
			}
			
		}
	}
}
