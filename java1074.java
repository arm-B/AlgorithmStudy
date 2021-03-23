import java.util.*;
public class java1074 {
	
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
		//������ �ߴ� ��ġ�� ���� -> ��� �� ����
		if(y == c && x== r) {
			System.out.println(count);
			System.exit(0);
		}
		
		//(x,y)���� ������/�Ʒ������� n������ �簢���� r�� c�� ��ġ�� �׸�ĭ�� �ƴ� ��� n*n������ �Ѵ�
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
