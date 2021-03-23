import java.io.*;
import java.util.*;
public class java1780 {
	
	static int paper[][];
	static int result[] = new int[3];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		result[0] = result[1] = result[2] = 0;
		
		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++)
				paper[i][j] = Integer.parseInt(st.nextToken());
		}
		
		number(N, 0, 0);
		
		System.out.println(result[0]);
		System.out.println(result[1]);
		System.out.println(result[2]);

	}
	public static void number(int n, int x, int y) {
		
		if(isSame(n, x, y)) {
			result[paper[x][y]+1]++;
			return;
		}
		else {
			int newSize = n/3;
			for(int i = 0; i<3; i++) {
				for(int j= 0; j<3; j++)
					number(newSize, x+newSize*i, y+newSize*j);
			}
		}	
	
	}
	public static boolean isSame(int n, int x, int y) {
		int value = paper[x][y];
		for(int i = x; i<x+n;i++)
			for(int j= y; j<y+n; j++)
				if(paper[i][j]!=value)
					return false;
		return true;
	}
	// ㅋ ㅋㅋ ㅋㅋㅋㅋ하... 이번엔 for문 시작 위치 잘못 줬어

}
