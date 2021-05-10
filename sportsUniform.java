class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n];
        int answer = 0;
        
        for(int i : reserve)
		clothes[i-1]++;
		
	for(int i : lost)
		clothes[i-1]--;
	    
	//처음에 제공된 값에서 시작, 초기화하면서 일단 자기옷 하나씩은 가지고 있게 설정(=0)
	//만약 잃어버렸다면 (lost에 값이 있으면) clothes의 자기 인덱스의 값을 하나 감소
	//test case는 1부터, 배열은 0부터 시작하므로 i-1을 함
	//여분의 옷을 가지고 왔다면 clothes의 자기 인덱스의 값을 하나 증가
		
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
	    
	//옷 빌려주기
	//만약 clothes의 값이 양수이면 자기 옷 외에 여벌이 더 있다는 뜻이므로
	//앞 사람이 없으면 앞 사람 빌려주고, 뒷 사람이 없으면 뒷사람 빌려줌
	//배열의 인덱스를 넘지 않게 i!=0조건과 i<n-1 조건을 추가
		
	for(int i = 0; i<n; i++) {
		if(clothes[i]>=0)
			answer++;
	}
	    
	//clothes의 값이 0 이상이면 빌렸든 가지고 왔든 옷을 갖고 있다는 뜻이므로 answer 하나 증가
        
        return answer;
    }
}
