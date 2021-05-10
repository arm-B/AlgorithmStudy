class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int min = 0, max = 0;
        int[] answer = new int[2];
        
        for (int i = 0; i<lottos.length;i++) {
			if(lottos[i] == 0)
				max++;
			else
				for(int j = 0; j<win_nums.length; j++) {
					if(lottos[i]==win_nums[j]) {
						min++;
						max++;
						break;
					}
				}
		}
		if(min <= 1)
			answer[1] = 6;
		else
			answer[1] = 7-min;
		
		if(max <= 1)
			answer[0] = 6;
		else
			answer[0] = 7-max;
        
        return answer;
    }
}
