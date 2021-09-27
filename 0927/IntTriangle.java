import java.io.*;
import java.util.*;

public class Main {
  static long solution(int N, long[][] money) {
    
    // 해당 부분을 작성해주세요.
    
    long mine[][] = new long[N][N];
    mine[0][0] = money[0][0];
    
    for(int i = 1; i<N; i++){
      for(int j = 0; j<money[i].length; j++){
        if(j == 0)
          mine[i][j] = mine[i-1][j] + money[i][j];
        else if(j!=i){
          mine[i][j] = Math.max(mine[i-1][j] + money[i][j], mine[i-1][j-1] + money[i][j]);
        }
        else{
          mine[i][j] = mine[i-1][j-1] + money[i][j];
        }
      }
    }
    //Arrays.sort(mine[N-1]);
    long tmp = mine[N-1][0];
    for(int i = 0; i<N; i++){
      if(mine[N-1][i]> tmp)
        tmp = mine[N-1][i];
    }
    return tmp;
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    long[][] money = new long[N][];
    for (int i = 0 ; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      money[i] = new long[i+1];
      for (int j = 0; j <= i; j++)
        money[i][j] = Long.parseLong(st.nextToken());
    }
    System.out.println(solution(N, money));
  }
}

// 음... 테케는 다 통과하는데 돌리면 틀림 왜일까
// 암만봐도 똑같은 거 같은데... 혹시 이유를 안다면 알려주세요 지금 답답함
// c++ 답안이랑 내 거랑 다를 게 뭐야... 혹시 새 배열 만들어서 그런가 해서 직접 수정하는 걸로도 해봤는데 안 된대
// 써글
