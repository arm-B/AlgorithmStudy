import java.util.*;
public class Ladder {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] finalArray = new int[n];
    
    for(int i = 0; i<n; i++){
      finalArray[i] = sc.nextInt();
    }
    
    long bridge = 0;
    for(int i = 0; i<n; i++){
      for(int j = i-1; j>=0; j--){
        if(finalArray[j]>finalArray[i])
          bridge+=1;
      }
    }
    System.out.println(bridge); 
    
  }
}

// 어디서 풀어야햐....
// 백준 갔다가 인풋 다른 거 보고 백스텝
