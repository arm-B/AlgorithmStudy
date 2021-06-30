class Solution {
  public int[] solution(int rows, int columns, int[][] queries) {
    int tmp, min, num = 1, index = 0;
    int Rmatrix[][] = new int[rows][columns];
    int answer[] = new int[queries.length];
    
    for(int i = 0; i<rows; i++) {
      for(int j = 0; j<columns; j++) {
        Rmatrix[i][j] = num++;
      }
    }
    
    for(int i = 0; i<queries.length; i++) {
      int top = queries[i][0]-1;
      int left = queries[i][1]-1;
      int bottom = queries[i][2]-1;
      int right = queries[i][3]-1;
      
      tmp = Rmatrix[top][left];
      min = tmp;
      for(int j=top; j<bottom;j++) {
        Rmatrix[j][left] = Rmatrix[j+1][left];
        if(min > Rmatrix[j][left]) min = Rmatrix[j][left];
      }
      for(int j=left; j<right;j++) {
        Rmatrix[bottom][j] = Rmatrix[bottom][j+1];
        if(min > Rmatrix[bottom][j]) min = Rmatrix[bottom][j];
      }
      for(int j=bottom; j>top; j--) {
        Rmatrix[j][right] = Rmatrix[j-1][right];
        if(min > Rmatrix[j][right]) min = Rmatrix[j][right];
      }
      for(int j=right; j>left; j--) {
        Rmatrix[top][j] = Rmatrix[top][j-1];
        if(min > Rmatrix[top][j]) min= Rmatrix[top][j];
      }
      
      Rmatrix[top][left+1] = tmp;
      answer[index++] = min;
    }
    return answer;
  }
}
