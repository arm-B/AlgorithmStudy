class Solution {
    public int solution(String s) {
        int answer = s.length();
		
	for(int i = 1; i<=s.length()/2; i++) {
		String compressed = compressString(s, i);
		answer = Math.min(answer, compressed.length());
	}
        return answer;
    }
    static String compressString(String s, int gap) {
	int count = 1;
	StringBuilder sb = new StringBuilder();
	String check = "";
	for(int i = 0; i<s.length(); i += gap) {
		if(s.length()-i >= gap)
			check = s.substring(i, i+gap);
		else
			check = s.substring(i);
			
		if(i+gap+gap<=s.length() && check.equals(s.substring(i+gap, i+gap+gap))) {
			count += 1;
		}
		else {
			if(count > 1) sb.append(count);
			sb.append(check);
			check = "";
			count = 1;
		}
	}
        return sb.toString();
    }
}
