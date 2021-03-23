import java.util.*;

public class java6603 {
	
  //static으로 선언하여 클래스 이름 없이도 사용할 수 있게끔
  //입력받은 로또 번호들을 저장하는 배열
	static int[] num = {0};
  //입력받을 개수
	static int k;
  //방문여부를 결정
	static boolean[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			k = sc.nextInt();
			//k값이 0이면 종료
			if(k == 0)
				break;
			
			//초기화
			num = new int[k];
			result = new boolean[k];
			
			//로또 번호 입력 받기
			for (int i= 0; i<k; i++) {
				num[i] = sc.nextInt();
			}
			
			//시작 위치와 첫 깊이 제공, 하나의 출력이 끝나면 한 줄 띄우기
			DFS(0, 0);
			System.out.println();
		}
		sc.close();
	}
	
	public static void DFS(int start, int depth) {
		//깊이가 6일 경우 result[i]가 참인 num[i]들만 출력
		if(depth == 6) {
			for (int i = 0; i< k; i++)
				if(result[i]) {
					System.out.print(num[i]+" ");
				}
			System.out.println();
		}
		
    //직접 짠 코드는 아니고 구글링으로 검색해봤다... 짠 것은 수 입력받기가 다 ...^^
    //수업시간에 배운 재귀 나올 줄 알았는데 dfs 사용한다고 해서??? 상태로 한시간동안 헤매다 급하게 구글로...
    //코드를 봐도 이해가 안 가서 직접 써봤다.... 역시 모를 땐 노가다가 최고
    
		//dfs는 가장 근접한 값만을 스택에 담음 -> 수를 하나씩 키워가며 다음 수를 찾음
		//다음 뎁스로 이어갈 경로가 없으면 뒤로간다. 뒤로 간 노드에서 갈 경로가 있을 때까지
		//즉 아예 갈 곳이 없으면 뒤로 가고 아니면 앞으로(여기선 수가 커지겠지)
		//i와 depth가 두 개 이상 차이나면 제대로 된 값이 안 나오기 시작.. 그냥 헛돈다
		for(int i = start; i<k; i++) {
			result[i] = true;
			DFS(i+1, depth+1);
			result[i] = false;
		}
	}
}
