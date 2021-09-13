import java.util.*;
public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);	
    while(true) {
      String answer = "no";
      String num = sc.next();
      if(num.equals("0"))
        break;
      
      int length = num.length();
      boolean isPD = true;
      for(int i = 0; i<length/2+1;i++) {
        if(num.charAt(i)!= num.charAt(length-1-i)) {
          isPD = false;
          break;
        }
      }
      if(isPD) answer = "yes";
      System.out.println(answer);
    }
    
    sc.close();
  }
}
