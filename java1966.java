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
				boolean sgnf = true; //�ϴ� ���� Ŭ ���̶� ����
				
				for(int j=0; j<q.size();j++) {
					if(front[1] < q.get(j)[1]) {
						for(int k=0; k < j ; k++)
							q.offer(q.remove());
						sgnf = false;	//ť ���θ� ���鼭 �� ū ���� ������ ��� ���ϰ� ���´�
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
