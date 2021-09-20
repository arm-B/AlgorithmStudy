import java.util.*;
public class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int cities = sc.nextInt();
    int dist[] = new int[cities-1];
    int cost[] = new int[cities];
    long totalCost = 0;
    for(int i = 0; i<dist.length; i++) dist[i] = sc.nextInt();
    for(int i = 0; i<cost.length; i++) cost[i] = sc.nextInt();
    
    //그냥 지나가다가 싼 데 있으면 거기서 다 충전혀...
    
    long minCost = cost[0];
    for(int i = 0; i<cities-1; i++) {
      if(cost[i] < minCost)
        minCost = cost[i];
      
      totalCost += minCost*dist[i];
    }
  }
}

// 아니 분명 맞게 했다고 생각했는데 자꾸 2가 돼야하는데 4가 되어 있는 거야(예제)
// 그래서 이건 뭔가 문제 있다 하고 cost 설정 앞 뒤로 프린트해서 봤더니
// minCost가 10<</?? 뭔근본없는
// 그래서 코드 다시 읽어봤더니 마지막 문장 totalCost += minCost*=dist[i]; 라 써놓음
// 이야.............................
