import java.util.*;
public class Main {
	
	static int count, r, c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		calcZ((int)Math.pow(2, N), 0, 0);
		
		sc.close();
	}
	
	static void calcZ(int n, int x, int y) {
		//오고자 했던 위치에 도착 -> 출력 후 종료
		if(y == c && x== r) {
			System.out.println(count);
			System.exit(0);
		}
		
		//(x,y)에서 오른쪽/아래쪽으로 n간격의 사각형이 r과 c가 위치한 네모칸이 아닐 경우 n*n연산을 한다
		if(x <=r && r<(x+n) && y<=c && c<(y+n)) {
			int nextSize = n/2;
			calcZ(nextSize, x, y);
			calcZ(nextSize, x, y+nextSize);
			calcZ(nextSize, x+nextSize, y);
			calcZ(nextSize, x+nextSize, y+nextSize);
		}
		else
			count += n*n;
	}

}

// 진짜 스터디 시작하고 나서 완전 초기에 풀었던 거 같은데...
// 본격 코드 보고 내 코드 분석하기 시작
// 서치가 안되는데 제가 이퍼를 풀 수 있을까요 과연 ^^...
// 하하 자가학습 ㅎㅇ
