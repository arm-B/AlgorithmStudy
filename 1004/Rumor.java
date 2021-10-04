import java.util.*;
public class Rumor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 7;
		/*int near[][] = {{2, 3, 0},{1, 3, 0}, {1, 2, 4, 0},{3, 5, 0},{4,0},{0},{0}};
		int M = 2;
		int[] numM = {1, 6};*/
		
		int near[][] = {{2, 4, 0},{1, 3, 0}, {2, 5, 0},{1, 5, 6, 0},{3, 4, 6, 7, 0},
				{4, 5, 7, 0},{5, 6, 0}};
		int M = 1;
		int[] numM = {6};
    
		solution(N, near, M, numM);
	}
	
	public static void solution(int N, int[][] near, int M, int[] numM) {
		int[] answer = new int[N+1];
		int[] whenT = new int[N+1];
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i<=N; i++) answer[i] = -1;
		for(int p : numM) {
			q.add(p);
			answer[p]++;	
		}
		
		for(int i =1 ; i < N+1; i++) {
			whenT[i] = near[i-1].length/2;
		}
		
		while(!q.isEmpty()) {
			int p = q.poll();
			
			for(int adj : near[p-1]) {
				if(adj == 0) continue;
				
				whenT[adj] -= 1;
				
				if(answer[adj] == -1 && whenT[adj]<=0) {
					q.offer(adj);
					answer[adj] = answer[p] + 1; 
				}	
			}
		}
		
		for(int i =1 ; i <= N; i++) {
			System.out.printf("%d ", answer[i]);
		}
	}
}
// 죄송합니다... 입력 받는 거 만들기가 너무 귀찮았습니다... 근데 이퍼문제니까ㅎㅎ
