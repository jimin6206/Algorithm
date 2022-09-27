package basic;

import java.util.PriorityQueue;

public class BASIC_PriorityQueue {

	public static void main(String[] args) 
	
//	{
//		PriorityQueue<Integer> pqueueInt = new PriorityQueue<>();
//		pqueueInt.add(3);
//		pqueueInt.add(7);
//		pqueueInt.add(4);
//		pqueueInt.add(2);
//		pqueueInt.add(6);
//		pqueueInt.add(9);
//		
////		while(! pqueueInt.isEmpty()) {
////			System.out.println(pqueueInt.poll());
////		}
//		
//		for (int n : pqueueInt) {
//			System.out.println(n);
//		}
//	}
	
//	{
//		PriorityQueue<Integer> pqueueInt = new PriorityQueue<>( (i1,i2) -> i2-i1);
//		pqueueInt.add(3);
//		pqueueInt.add(7);
//		pqueueInt.add(4);
//		pqueueInt.add(2);
//		pqueueInt.add(6);
//		pqueueInt.add(9);
//		
//		while(! pqueueInt.isEmpty()) {
//			System.out.println(pqueueInt.poll());
//		}
//	}
	
	{
		PriorityQueue<Node> pqueue = new PriorityQueue<>();
		pqueue.add(new Node(3,7));
		pqueue.add(new Node(2,5));
		pqueue.add(new Node(5,2));
		pqueue.add(new Node(7,1));
		pqueue.add(new Node(4,6));
		
		while(! pqueue.isEmpty()) {
			System.out.println(pqueue.poll());
		}
	}
	
	static class Node implements Comparable<Node>{
		int y, x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + "]";
		}

		@Override
		public int compareTo(Node o) {
			return o.x - this.x;
		}
	}

}
