class Solution {
    public int solution(int[] nums) {
        int N = 10000;                          //최대 폰켓몬 수
        int mymon[] = new int [N/2];            //데려갈 폰켓몬을 담는 배열
        int answer = 0;                         //중복없이 챙긴 폰켓몬 수
        for (int i = 0; i<nums.length;i++) {    //입력 배열만큼 돌면서 이미 한계(=nums.length/2)만큼 모았다면 그만, 아니라면 중복이 아닌지 확인하고 배열에 추가
			if(answer==nums.length/2)
				break;
			boolean isin = false;                     //중복 확인은 불리언 변수를 사용하여 mymon을 한 번 돌면서 현재 nums[i]의 값과 같은 게 있다면 isin을 true로 변경
			for(int j = 0; j<answer; j++) {
				if(mymon[j] == nums[i])
					isin = true;
			}
			if(!isin)                                 //isin이 false이면 mymon 배열에 추가
				mymon[answer++] = nums[i];
		}
        return answer;
    }
}
