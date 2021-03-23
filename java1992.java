import java.io.*;
public class java1992 {
	
	static int img[][];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		//廃 切梢 快嬢 石嬢醤敗
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
		
		quadtree(n/2, x, y);		//図楕 是
		quadtree(n/2, x, y+n/2);	//神献楕 是
		quadtree(n/2, x+n/2, y);	//図楕 焼掘
		quadtree(n/2, x+n/2, y+n/2);//神献楕 焼掘
		
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
	//せせせせ せせ せせせせ for庚拭辞 n++背兜壱 訊 照鞠走 戚君壱 赤醸嬢
	//噌鍵亜詐艦陥... 焼戚姥醤...

}
