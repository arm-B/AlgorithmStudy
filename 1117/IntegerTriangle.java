import java.util.*;
class Solution {
  public int solution(int[][] triangle) {
    int len = triangle.length;
    for(int i = 1; i < len; i++){
      triangle[i][0] +=  triangle[i-1][0];
      for(int j = 1; j < i; j++){
        triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
      }
      triangle[i][i] += triangle[i-1][i-1];
    }
    Arrays.sort(triangle[len-1]);
    return triangle[len-1][len-1];
  }
}

// 원래 새로운 배열을 만들어서 하다가, 너무 공간 낭비인 것 같다는 생각이 들었음
// 그래서 양 끝의 값(내려올 길이 하나밖에 없음)만 따로 처리해주고 중간의 값은 고르는 식으로 바꿔줌
// 잘 되네... 많이 풀어본 문제라 괜찮았다.
