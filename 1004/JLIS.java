import java.util.*;
public class JLIS {
  public static int cache[][];
  static int A[], B[];
  static int N, M;
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    
    for(int i = 0; i<tc; i++) {
      N = sc.nextInt(); M = sc.nextInt();
      A = new int[N]; B = new int[M];
      for(int j = 0 ; j<N; j++)
        A[j] = sc.nextInt();
      for(int j = 0 ; j<M; j++)
        B[j] = sc.nextInt();
      
      cache = new int[N+1][M+1];
      for(int j =0 ; j<=N;  j++)
        for(int k =0; k<=M; k++)
          cache[j][k] = -1;
      System.out.println(makeJLIS(-1, -1)-2);
    }
  }
  
  public static int makeJLIS(int nown, int nowm) {
    if(cache[nown+1][nowm+1] != -1)
      return cache[nown+1][nowm+1];
    
    int count = 2;
    long a = nown == -1 ? Long.MIN_VALUE : A[nown];
    long b = nowm == -1 ? Long.MIN_VALUE : B[nowm];
    long max = Math.max(a, b);
    
    for(int nextn = nown+1;  nextn<N; nextn++)
      if(max < A[nextn])
        count = Math.max(count, makeJLIS(nextn, nowm)+1);
    for(int nextm = nowm+1;  nextm<M; nextm++)
      if(max < B[nextm])
        count = Math.max(count, makeJLIS(nown, nextm)+1);
    
    cache[nown+1][nowm+1] = count;
    
    return count;
  }
}
