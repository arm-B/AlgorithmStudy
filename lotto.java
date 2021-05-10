class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int min = 0, max = 0;
        int[] answer = new int[2];
        
        for (int i = 0; i<lottos.length;i++) {
		if(lottos[i] == 0)		//모르는 번호 최고 등수인 max만 하나 추가
			max++;
		else
			for(int j = 0; j<win_nums.length; j++) {	//그 외의 값인 경우 중복 없으니까 확인 없이
				if(lottos[i]==win_nums[j]) {		//동일한 값이 있으면 min과 max 모두 하나씩 추가
					min++;
					max++;
					break;
				}
			}
	}
	//귀찮은 나머지... swith-case문 안 쓰고 낙첨 제외 7-맞힌 개수로 등수를 구했습니다.
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
