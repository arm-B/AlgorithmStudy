import java.util.*;
import java.io.*;
public class java1966 {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer input, iptc;

		for (int i = 0; i<N; i++) {
			input = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(input.nextToken());
			int lct = Integer.parseInt(input.nextToken());
			int count = 0;
			
			iptc = new StringTokenizer(br.readLine(), " ");
			
			LinkedList<int[]> q = new LinkedList<>();
			
			for (int j = 0; j<size; j++)
				q.offer(new int[] {j, Integer.parseInt(iptc.nextToken())});

			while(!q.isEmpty()) {
				int[] front = q.peek();
				boolean sgnf = true; //일단 제일 클 것이라 가정
				
				for(int j=0; j<q.size();j++) {
					if(front[1] < q.get(j)[1]) {
						for(int k=0; k < j ; k++)
							q.offer(q.remove());
						sgnf = false;	//큐 내부를 돌면서 더 큰 놈이 있으면 출력 못하게 막는다
						break;
					}
				}
				
				if(sgnf == true) {
					count++;
					int[] order = q.remove();
					if(order[0] == lct) {
						sb.append(count+"\n");
						break;
					}
				}
				
			}
			
			
			
		}
		System.out.println(sb);
	}
}
