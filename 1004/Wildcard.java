import java.util.*;
public class WILDCARD {
  static int cache[][];
  static String W, S;
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    for(int i = 0; i<tc; i++) {
      W = sc.next();
      int n = sc.nextInt();
      for(int j = 0 ; j<n; j++) {
        S = sc.next();
        cache = new int [W.length()+1][S.length()+1];
        for(int l = 0; l<W.length(); l++)
          for(int k = 0; k<S.length(); k++)
            cache[l][k] = -1;
        if(matchMemoized(0, 0) == 1)
          System.out.println(S);
      }
    }
  }
  
  public static int matchMemoized(int w, int s) {
    int ret = cache[w][s];
    if(ret != -1) 
      return ret;
    while(s<S.length() && w<W.length() && (W.charAt(w) == '?' || W.charAt(w) == S.charAt(s))) {
      return cache[w][s] = matchMemoized(w+1, s+1);
    }
    
    if(w == W.length())
      return cache[w][s] = (s == S.length() ? 1: 0);
    
    if(W.charAt(w) == '*') { 
      if(matchMemoized(w+1,s) == 1 || (s < S.length() && matchMemoized(w, s+1) == 1)) { 
        return cache[w][s] = 1; 
      } 
    }
    
    return cache[w][s] = 0;
  }
}
