import java.util.*;
public class java2447 {
	
	static char paper[][];
	
	static void star(int n, int x, int y) {
		if(n==1) {
			paper[y][x]	= '*';
			return;
		}
		star(n/3, x, y);			//���� ��
		star(n/3, x+n/3, y);		//��� ��
		star(n/3, x+n/3*2, y);		//������ ��
		star(n/3, x, y+n/3);		//����
		star(n/3, x+n/3*2, y+n/3);	//������
		star(n/3, x, y+n/3*2);		//���� �Ʒ�
		star(n/3, x+n/3, y+n/3*2);	//�Ʒ���
		star(n/3, x+n/3*2, y+n/3*2);//������ �Ʒ�
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		paper = new char[N][N];
		
		//for������ ����Ʈ �����ϱ� �ð� �ʰ� ���...
		//��ġ�ؼ� ����� �˾ƿԴ�...�� �� �𸣴� �����̴�
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
		
		//StringBuilder : String�� ���ڿ��� ���� �� ���ο� ��ü�� �����ϴ� ���� �ƴ϶� ������ �����Ϳ� ���ϴ¹��(append)
		//�� ����ϱ� ������ �ӵ��� ������ ��������� ���ϰ� ���ٰ� �Ѵ�.
		//Arrays.fill()�Լ��� �迭�� �ʱ�ȭ�� �� ����. for������ �����ϴ� �ͺ��� ���ٰ�...
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
