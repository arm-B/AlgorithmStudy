class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
	//signs의 값따라 true면 더해주고 false면 빼주기
	//음... 너무 간단한가
	for(int i = 0; i<absolutes.length;i++) {
		if(signs[i])
			answer += absolutes[i];
		else
			answer -= absolutes[i];
	}
        return answer;
    }
}
