import java.util.*;
import java.io.*;
public class PI {
  static int INF = 987654;
  static String N;
  static int cache[];
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    
    for(int i = 0 ; i<tc; i++) {
      N = br.readLine();
      cache = new int[N.length()];
      
      for(int j = 0 ; j<N.length(); j++)
        cache[j] = -1;
      
      System.out.println(memorize(0));
    }
  }
  
  public static int classify(int a, int b) {
    String  M = N.substring(a, b+1);
    String check1 = "";
    for(int i = 0; i<M.length(); i++)
      check1 += M.charAt(0);
    if(check1.equals(M))
      return 1;
    
    boolean progressive = true; for(int i=0; i<M.length()-1; i++) { 
      if(M.charAt(i+1) - M.charAt(i) != M.charAt(1) - M.charAt(0)) { 
        progressive = false; 
        break; 
      } 
    }
    
    if(progressive && Math.abs(M.charAt(1) - (int)M.charAt(0)) == 1) 
      return 2;
    
    boolean alternating = true;
    for(int i = 0; i<M.length(); i++)
      if(M.charAt(i) != M.charAt(i%2))
        alternating = false;
    
    if(alternating)
      return 4;
    
    if(progressive)
      return 5;
    
    return 10;
    
  }
	
  public static int memorize(int begin) {
    if(begin == N.length())
      return 0;
    
    if(cache[begin] != -1)
      return cache[begin];
    
    int ret = INF;
    for(int i = 3; i<=5; i++) {
      if(begin + i <= N.length())
        ret = Math.min(ret, memorize(begin + i) + classify(begin, begin + i - 1));
    }
    return cache[begin] = ret;
  }
  
}
