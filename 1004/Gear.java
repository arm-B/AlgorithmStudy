import java.io.*;
public class Main {
  static int gears[][] = new int[4][8];
  static int[] isValid;
  
  public static void main(String[] args) throws IOException{
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for(int i = 0;i<4;i++) {
      String input = br.readLine();
      for(int j = 0; j < 8; j++) {
        gears[i][j] = input.charAt(j)-'0';
      }
    }
    
    int k = Integer.parseInt(br.readLine());
    
    for(int i = 0; i<k; i++) {
      String[] input = br.readLine().split(" ");
      isValid = new int[4];
      
      int gearNum = Integer.parseInt(input[0]);
      int dir = Integer.parseInt(input[1]);
      
      check(gearNum-1, dir);
      rotate(isValid);
    }
    System.out.println(calc());
	}
  
  public static int calc() {
    int sum = 0;
    for(int i = 0; i<4; i++) {
      if(gears[i][0] == 1)
        sum += Math.pow(2, i);
    }
    
    return sum;
  }
  
  public static void check(int gearNum, int dir) {
    isValid[gearNum] = dir;
    
    int prev = gearNum - 1;
    int next = gearNum + 1;
    
    if (prev >= 0 && isValid[prev] == 0)
      if (gears[prev][2] != gears[gearNum][6])
        check(prev, dir * -1);
    
    if (next <= 3 && isValid[next] == 0)
      if (gears[next][6] != gears[gearNum][2])
        check(next, dir * -1);
  }
  
  public static void rotate(int[] isValid) {
    for(int i = 0; i<4; i++) {
      if(isValid[i] == 1) {
        int tmp = gears[i][7];
        for(int j = 7 ; j > 0; j--)
          gears[i][j] = gears[i][j-1];
        gears[i][0] = tmp;
      }
      
      else if(isValid[i] == -1) {
        int tmp = gears[i][0];
        for(int j = 0; j<7; j++)
          gears[i][j] = gears[i][j+1];
        gears[i][7] = tmp;
      }
    }
  }
}
