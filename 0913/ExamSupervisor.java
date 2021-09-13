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
