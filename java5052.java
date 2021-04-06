import java.util.*;

public class java5052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i<t; i++) {
			int n = sc.nextInt();
			String result = "YES";
			String[] number = new String[n];
			
			for(int j=0; j<n;j++) {
				number[j] = sc.next();
			}

			Arrays.sort(number);

			for(int j = 0; j<n-1; j++) {
				if(number[j+1].length()>number[j].length()) 
					if((number[j+1].substring(0, number[j].length())).contains(number[j])){
						result = "NO";
						break;
				}										
			}
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}
}
