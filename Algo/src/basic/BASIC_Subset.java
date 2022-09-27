package basic;


public class BASIC_Subset {

	static int COUNT = 0;
	static int[] src = {1,2,3,4,5};
	static boolean[] select = new boolean[src.length];  //******** 제일 중요!!
	
	public static void main(String[] args) {
		subset(0);
		System.out.println(COUNT);
	}
	
	static void subset(int srcIdx) {
		//기저조건
		if( srcIdx == src.length) {
			// complete code
			printSubset();
			COUNT++;
			return;
		}
		
		//현재 srcIdx 를 선택하고 간다.
		select[srcIdx] = true;
		subset(srcIdx +1);	
		//현재 srcIdx 를 선택안하고 간다.
		select[srcIdx] = false;
		subset(srcIdx +1);
		
	}
	
	static void printSubset() {
		//부분집합에 포함된? 포함되지 않은???
		System.out.print("{ ");
		for (int i = 0; i < select.length; i++) {
			if(select[i]) System.out.print(src[i] + " ");
		}
		System.out.print(" }");
		System.out.println();
	}
}
