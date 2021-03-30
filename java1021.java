import java.util.*;
import java.io.*;

public class java1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> dq = new LinkedList<>();
		StringTokenizer first = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(first.nextToken());
		int M = Integer.parseInt(first.nextToken());
		
		for (int i = 0; i<N; i++) {
			dq.offer(i+1);
		}
		StringTokenizer second = new StringTokenizer(br.readLine());
		int count = 0;
		for(int i = 0; i<M; i++) {
			int order = Integer.parseInt(second.nextToken());
			if(dq.peekFirst()==order) {
				dq.removeFirst();
				continue;
			}
			else {
				if((dq.size()-dq.indexOf(order))>dq.indexOf(order)) {
					while(dq.peekFirst()!=order) {
						count++;
						dq.addLast(dq.removeFirst());
					}
					dq.removeFirst();
				}
				else {
					while(dq.peekFirst()!=order) {
						count++;
						dq.addFirst(dq.removeLast());
					}
					dq.removeFirst();
				}				
			}
		}
		System.out.println(count);
	}
}
