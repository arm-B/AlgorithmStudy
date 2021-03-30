import java.util.*;
import java.io.*;

public class java10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> dq = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer order;
		Integer number;
		for(int i = 0; i<N; i++) {
			order = new StringTokenizer(br.readLine(), " ");
			switch(order.nextToken()) {
				case "push_front" :
					number = Integer.parseInt(order.nextToken());
					dq.addFirst(number);
					break;
				case "push_back" :
					number = Integer.parseInt(order.nextToken());
					dq.addLast(number);
					break;
				case "pop_front" :
					if(!dq.isEmpty())
						sb.append(dq.removeFirst()+"\n");
					else
						sb.append(-1+"\n");
					break;
				case "pop_back" :
					if(!dq.isEmpty())
						sb.append(dq.removeLast()+"\n");
					else
						sb.append(-1+"\n");
					break;
				case "size" :
					sb.append(dq.size()+"\n");
					break;
				case "empty" :
					if(dq.isEmpty())
						sb.append(1+"\n");
					else
						sb.append(0+"\n");
					break;
				case "front" :
					if(!dq.isEmpty())
						sb.append(dq.peekFirst()+"\n");
					else
						sb.append(-1+"\n");
					break;
				case "back" :
					if(!dq.isEmpty())
						sb.append(dq.peekLast()+"\n");
					else
						sb.append(-1+"\n");
					break;
			}
			//큐2 문제에서 자료형만 바꿔서 구현
		}
		System.out.println(sb);
	}
}
