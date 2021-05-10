class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int Lhand = 10;
		int Rhand = 12 ;
        
        for(int i = 0; i<numbers.length; i++) {
			if(numbers[i]==1||numbers[i]==4||numbers[i]==7) {
				answer+="L";
				Lhand = numbers[i];
			}
			else if(numbers[i]==3||numbers[i]==6||numbers[i]==9) {
				answer+="R";
				Rhand = numbers[i];
			}
			else {
				int leftD = getDistance(Lhand, numbers[i]);
				int rightD = getDistance(Rhand, numbers[i]);
				
				if(leftD>rightD) {
					answer+="R";
					Rhand = numbers[i];
				}
				else if(leftD<rightD) {
					answer+="L";
					Lhand = numbers[i];
				}
				else {
					if(hand.equals("right")) {
						answer+="R";
						Rhand = numbers[i];
					}
					else if(hand.equals("left")) {
						answer+="L";
						Lhand = numbers[i];
					}
				}
			}
		}
        
        return answer;
    }
    
    static int getDistance(int now, int next) {
		int distance = 0;
        if(now == 0) now = 11;
		if(next == 0) next = 11;
        
		int nowy = (now-1)/3;
		int nowx = (now-1)%3;
		int nexty = (next-1)/3;
		int nextx = (next-1)%3;
		distance = Math.abs(nowy-nexty)+Math.abs(nowx-nextx);
		return distance;
	}
}
