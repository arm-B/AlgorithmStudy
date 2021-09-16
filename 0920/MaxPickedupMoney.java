import java.io.*;
import java.util.*;

class Main {
	
	public static int max(int a, int b, int c){
		return a>b?(a>c)?a:c:(b>c)?b:c;
		//a>b, a>c가 참 : a
		//a>b 참 a>c 거짓 : a>b, c>a 이므로 c
		//a>b, a>c가 거짓 : b>a && c>a b와 c의 우열 가려야함 > 이게 뒤쪽의 (b>c)?b:c;
	}
	
// 돈의개수 n과 크기가 n인 수열 M이 주어졌을 때 
// 주울 수 있는 최대 돈을 구하는 함수
	public static int solution(int n, int[] M)
	{
		int[] dp = new int[n+1];
		dp[1] = M[0];
		if(n>1) dp[2] = M[0]+M[1];
		if(n>2) {
			for(int i = 3; i<=n; i++){
				dp[i] = max(dp[i-1], dp[i-2]+M[i-1], dp[i-3]+M[i-2]+M[i-1]);
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] M = new int[n];
		
		for(int i = 0; i < n; i++) {
			M[i] = sc.nextInt();
		}
		int ans = solution(n,M);
		System.out.println(ans);
	}		
}
