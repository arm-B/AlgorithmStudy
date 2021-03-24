import java.util.*;
public class java2448 {
	
	static char paper[][];
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		paper = new char[N][2*N];
		
		StringBuilder sb = new StringBuilder();
		for(int i= 0; i< N; i++)Arrays.fill(paper[i], ' ');
		star(N, N-1, 0);
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<2*N; j++)
				sb.append(paper[i][j]);
			sb.append("\n");
		}
		System.out.println(sb);

	}
	public static void star(int n, int c, int r) {
		if(n == 3) {
			paper[r][c]='*';
			
			for(int i = c-1; i<c+2;) {
				paper[r+1][i]='*';
				i= i+2;
			}
			
			for(int i = c-2; i<c+3; i++)
				paper[r+2][i]='*';
			
			return;
		} else {
		
		star(n/2, c, r);
		star(n/2, c-n/2, r+n/2);
		star(n/2, c+n/2, r+n/2);
		
		}
	}

}
