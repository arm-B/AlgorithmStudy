import java.io.*;
//프로그래머스에서는 main함수 및 입출력문이 필요하지 않습니다. 대신 solution함수만 작성하면 됩니다.
public class Main {
	static String solution(String input){
		String answer="";
		if(input.charAt(0) == '1') answer += "1";
		int count = 0;
		char prev = input.charAt(0);
		int base = 64;
		for(int i = 0; i<input.length(); i++){
			char tmp = input.charAt(i);
			if(tmp == '1' && prev != tmp){
				if(i!=0){
					if(count<26)answer += (char)(base+count);
					else answer += 'Z';
				}
				count = 1;
				prev = '1';
			}
			else if (tmp == '1' && prev == tmp)
				count++;
			else if (tmp == '0' && prev != tmp){
				if(i!=0){
					if(count<26)answer += (char)(base+count);
					else answer += 'Z';
				}
				count = 1;
				prev = '0';
			}
			else if (tmp == '0' && prev == tmp)
				count++;
		}
		if(count<26)answer += (char)(base+count);
		else answer += 'Z';
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String answer= solution(input);
		
		System.out.println(answer);
	}
}
