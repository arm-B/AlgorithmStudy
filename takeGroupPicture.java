import java.util.*;
class Solution {
    static List<Character> position;
	static char[] kko = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	static int answer;
	static boolean[] visited;
    
    public int solution(int n, String[] data) {
        visited = new boolean[kko.length];
		position = new ArrayList<Character>();
        for(int i = 0; i<kko.length; i++) {
			position.add('0');
		}
		answer = 0;
        countCase(0, n, data);
        return answer;
    }
    
    static boolean isTrue(String[] data) {
		for(int i = 0; i<data.length;++i) {
			char[] want = data[i].toCharArray();
			int start = 0, end = 0;
			
			int gap = Math.abs(position.indexOf(want[0])-position.indexOf(want[2]));
			
			switch(want[3]) {
				case '>':
					if(gap <= want[4]-'0'+1)
						return false;
					break;
				case '=' :
					if(gap != want[4]-'0'+1)
						return false;
					break;
				case '<' :
					if(gap >= want[4]-'0'+1)
						return false;
				break;
			}
		}
		return true;
	}
	static void countCase(int index, int n, String[] data) {
		if(index == 8) {
			if(isTrue(data)) {
				answer++;
			}
			return;
		}
		
		for(int i= 0; i<kko.length;++i) {
			if(!visited[i]) {
				visited[i] = true;
				position.set(index, kko[i]);
				countCase(index+1, n, data);
				visited[i] = false;
			}
		}		
	}
}
