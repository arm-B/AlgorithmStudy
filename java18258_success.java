import java.util.*;
import java.io.*;

public class java18258_success {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer order;
		Integer number;
		int last = -1;
		for(int i = 0; i<N; i++) {
			order = new StringTokenizer(br.readLine(), " ");
			switch(order.nextToken()) {
				case "push" :
					number = Integer.parseInt(order.nextToken());
					q.offer(number);
					last = number;
					break;
				case "pop" :
					if(!q.isEmpty()) {
						sb.append(q.remove()+"\n");
					}
					else
						sb.append(-1+"\n");
					break;
				case "size" :
					sb.append(q.size()+"\n");
					break;
				case "empty" :
					if(q.isEmpty())
						sb.append(1+"\n");
					else
						sb.append(0+"\n");
					break;
				case "front" :
					if(!q.isEmpty()) {
						sb.append(q.peek()+"\n");;
					}
					else
						sb.append(-1+"\n");
					break;
				case "back" :
					if(!q.isEmpty())
						sb.append(last+"\n");
					else
						sb.append(-1+"\n");
					break;
			}
			//하나씩 출력했더니 느리다고 까였다.
			//그래서 전에 별 찍었을 때 쓰던 걸 가져와서 다 붙인다음에 한 번에 출력해줬다.
		}
		System.out.println(sb);
	}
}
