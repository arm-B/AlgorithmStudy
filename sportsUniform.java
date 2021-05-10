class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n];
        int answer = 0;
        
        for(int i : reserve)
			clothes[i-1]++;
		
		for(int i : lost)
			clothes[i-1]--;
		
		for(int i = 0; i<n;i++) {
			if(clothes[i]>0) {
				if(i != 0 && clothes[i-1]<0) {
					clothes[i]--;
					clothes[i-1]++;
				}
				else if(i < n-1 && clothes[i+1]<0) {
					clothes[i]--;
					clothes[i+1]++;
				}
			}
		}
		
		for(int i = 0; i<n; i++) {
			if(clothes[i]>=0)
				answer++;
		}
        
        return answer;
    }
}
