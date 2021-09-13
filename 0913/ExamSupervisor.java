import java.util;
public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int place = sc.nextInt();
    int taker[] = new int[place]; 
    for(int i = 0; i<place; i++)
      taker[i] = sc.nextInt();
    int mainS = sc.nextInt(), subS = sc.nextInt();
    
    long answer = Long.valueOf(place);
    for(int i = 0; i<place; i++) {
      taker[i] -= mainS; 
      answer += Long.valueOf(taker[i]/subS);
      if(taker[i]%subS != 0)
        answer++;
    }
    System.out.println(answer);
    sc.close();
  }
}
// 제공된 테케는 다 되는데 돌리면 틀림
// long으로 바꾸래서 바꿨는데 왜 안 될까,,, 의문
// 그렇게 채점현황을 가득 채운 hdmi1234씨

// OMG 이유 알았음
// mainS가 원래 taker[i]에 있는 놈보다 커버리면 answer에서 -가 나옴 그러니...  맞을리가 있나...
// 1 1 1000000 1 넣고 알았음
// 그래서 taker가 mainS보다 더 클 때만 빼도록 조건 변경
// 그러니 통과했다...^^ 하아아아...

import java.util;
public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int place = sc.nextInt();
    int taker[] = new int[place]; 
    for(int i = 0; i<place; i++)
      taker[i] = sc.nextInt();
    int mainS = sc.nextInt(), subS = sc.nextInt();
    
    long answer = Long.valueOf(place);
    for(int i = 0; i<place; i++) {
      if(mainS<taker[i]) {
        taker[i] -= mainS; 
        answer += Long.valueOf(taker[i]/subS);
        if(taker[i]%subS != 0)
          answer++;
      }
    }
    System.out.println(answer);
    sc.close();
  }
}
