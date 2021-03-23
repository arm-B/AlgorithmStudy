import java.util.*;
public class java2447 {
	
	static char paper[][];
	
	static void star(int n, int x, int y) {
		if(n==1) {
			paper[y][x]	= '*';
			return;
		}
		star(n/3, x, y);			//왼쪽 위
		star(n/3, x+n/3, y);		//가운데 위
		star(n/3, x+n/3*2, y);		//오른쪽 위
		star(n/3, x, y+n/3);		//왼쪽
		star(n/3, x+n/3*2, y+n/3);	//오른쪽
		star(n/3, x, y+n/3*2);		//왼쪽 아래
		star(n/3, x+n/3, y+n/3*2);	//아래쪽
		star(n/3, x+n/3*2, y+n/3*2);//오른쪽 아래
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		paper = new char[N][N];
		
		//for문으로 프린트 돌리니까 시간 초과 뜬다...
		//서치해서 방법을 알아왔다...즉 잘 모르는 문법이다
		/*for(int i = 0; i< N; i++) {
			for (int j= 0; j<N; j++){
				paper[i][j]	= ' ';
			}
		}
		
		star(N, 0, 0);
		
		for(int i = 0; i<N;i++) {
			for (int j = 0; j<N;j++) {
				System.out.print(paper[i][j]);
			}
			System.out.println();*/
		
		//StringBuilder : String과 문자열을 더할 때 새로운 객체를 생성하는 것이 아니라 기존의 데이터에 더하는방식(append)
		//을 사용하기 때문에 속도도 빠르며 상대적으로 부하가 적다고 한다.
		//Arrays.fill()함수는 배열을 초기화할 때 좋다. for문으로 구동하는 것보다 좋다고...
		StringBuilder sb = new StringBuilder();
		for(int i= 0; i< N; i++)Arrays.fill(paper[i], ' ');
		star(N, 0, 0);
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++)
				sb.append(paper[i][j]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
