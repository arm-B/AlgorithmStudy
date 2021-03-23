import java.io.*;
public class java1992 {
	
	static int img[][];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		//한 자씩 끊어 읽어야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		img = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for(int j = 0; j < N; j++) {
				img[i][j] = str.charAt(j) - '0';
			}
		}
		
		quadtree(N, 0, 0);
		System.out.println(sb);
	}
	
	static void quadtree(int n, int x, int y) {
		
		if(canApchuk(n, x, y)) {
			sb.append(img[x][y]);
			return;
		}
		
		sb.append('(');
		
		quadtree(n/2, x, y);		//왼쪽 위
		quadtree(n/2, x, y+n/2);	//오른쪽 위
		quadtree(n/2, x+n/2, y);	//왼쪽 아래
		quadtree(n/2, x+n/2, y+n/2);//오른쪽 아래
		
		sb.append(')');
	}
	
	static boolean canApchuk(int n, int x, int y) {
		int value = img[x][y];
		
		for(int i = x; i<x+n;i++)
			for(int j= y; j<y+n; j++)
				if(img[i][j]!=value)
					return false;
		return true;
		
	}
	//ㅋㅋㅋㅋ ㅋㅋ ㅋㅋㅋㅋ for문에서 n++해놓고 왜 안되지 이러고 있었어
	//졸린가봅니다... 아이구야...

}
