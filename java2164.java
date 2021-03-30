import java.io.*;
import java.util.*;
public class java2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		for(int i= 0; i<N; i++) {
			q.offer(i+1);
		}
		while(q.size()>1) {
			q.remove();
			q.offer(q.remove());
		}
		System.out.println(q.peek());
	}
}
