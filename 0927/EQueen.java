import java.util.*;
class Main {
  static int answer, N;
  static int colQueen[]; // n번재 행 몇번째 열에 queen이 있는지
  static int xy[][];     // 절대 못 가는조건
  public static int solution(int n, int k, int[] X, int[] Y) {
    colQueen = new int[n+1];
    xy = new int[n][n];
    N = n;
    
    // 못 가는 곳은 1
    for(int i=0; i<k; i++)
      xy[X[i]-1][Y[i]-1] = 1;
    queen(0);
    return answer;
  }
  
  //계속 진행해도 될지 판단
  public static boolean isOkay(int i) {
    int k = 1;
    boolean flag = true;
    while(k<i && flag) {
      //첫번째 조건은 그 일자로 되어있는지 확인
      //두번째 조건은 대각선 만약 i가 5이고 k가 3이야 여기서 colQueen[i]가 3이고 colQueen[k]가 5야 그러면
      //
      //
      //  X  X  X  X  Q
      //  X  X  X  X  X
      //  X  X  Q  X  X
      // 이렇게 될 거 아녀... 이러면 가면 안 돼 그래서 플래그 내림
      if(colQueen[i] == colQueen[k] || Math.abs(colQueen[i]-colQueen[k]) == i-k)
        flag = false;
      k++;
    }
    return flag;
  }
	
  //깊이우선탐색
  public static void queen(int i) {
		int j;
    if(isOkay(i)) {
      if(i == N)
        answer++;
      else {  // 앞 행에 둔 게 조건 만족하는지 확인
        for(j=0; j<N; j++) {
          if(xy[i][j] == 1) continue;
          colQueen[i+1] = j;
          queen(i+1);
        }
      }
    }	
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    int k = sc.nextInt();
    
    int X[] = new int[k];
    for(int i=0; i<k; i++)
      X[i] = sc.nextInt();
    
    int Y[] = new int[k];
    for(int i=0; i<k; i++)
      Y[i] = sc.nextInt();
    
    System.out.println(solution(n, k, X, Y));  
  }
}

// 구르미 들어가자마자 황당해서,,, java로는 main부터 안들어가는데요 근데 고치지 말라고...? 응 말도 안돼
// 애초에 solution 함수 호출하는 것도 없드만.... 그래서 main부터 싹 갈아엎고 시작
// 가장 윗줄부터 돌면서 조건 확인하고 개수 세고 그러는... 함수인 듯함.
// 처음에 나는 다르게 짰었는데... 조건대로 못 가는 길 지정했다가 없애는... 그렇게 했더니 answer가 0에서 움직이질 않아
// 결국 c++ 솔루션 코드를... 자바에 맞게 다시 작성했다... ㅇㅔ휴
