import java.util.*;
class Solution {
    static int[][] visited;
    public int[] solution(int m, int n, int[][] picture) {
        int maxSizeOfOneArea = 0;
        List<Integer> range = new ArrayList<Integer>();
		visited = new int[m][n];
        
		for(int i = 0; i<m;i++) {
			for(int j = 0; j<n; j++) {
				if(visited[i][j] == 0 && picture[i][j] != 0) {
					int num = 0;
					range.add(findRange(picture, i, j, num));
				}
			}
		}
        for(int i = 0; i<range.size();i++) {
			if(maxSizeOfOneArea < range.get(i))
				maxSizeOfOneArea = range.get(i);
		}

        int[] answer = new int[2];
        answer[0] = range.size();
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static int findRange(int[][] picture, int row, int col, int num) {
		visited[row][col] = 1;
		num++;
		if(row-1>=0 && picture[row-1][col]==picture[row][col] && visited[row-1][col] == 0)
			num = findRange(picture, row-1, col, num);
		if(row+1<picture.length && picture[row+1][col]==picture[row][col] && visited[row+1][col] == 0)
			num = findRange(picture, row+1, col, num);
		if(col-1>=0 && picture[row][col-1]==picture[row][col] && visited[row][col-1] == 0)
			num = findRange(picture, row, col-1, num);
		if(col+1<picture[0].length && picture[row][col+1]==picture[row][col] && visited[row][col+1] == 0)
			num = findRange(picture, row, col+1, num);
		
		return num;
	}
}
