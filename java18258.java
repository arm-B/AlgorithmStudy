import java.util.*;

public class java18258 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		int N = sc.nextInt();
		
		String order;
		int number;
		int last = -1;
		for(int i = 0; i<N; i++) {
			order = sc.next();
			switch(order) {
				case "push" :
					number = sc.nextInt();
					q.offer(number);
					last = number;
					break;
				case "pop" :
					if(!q.isEmpty()) {
						System.out.println(q.remove());
					}
					else
						System.out.println(-1);
					break;
				case "size" :
					System.out.println(q.size());
					break;
				case "empty" :
					if(q.isEmpty())
						System.out.println(1);
					else
						System.out.println(0);
					break;
				case "front" :
					if(!q.isEmpty()) {
						System.out.println(q.peek());
					}
					else
						System.out.println(-1);
					break;
				case "back" :
					if(!q.isEmpty())
						System.out.println(last);
					else
						System.out.println(-1);
					break;
			
			}		
		}
	}
}
