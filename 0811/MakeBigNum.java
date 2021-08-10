class Solution {
  static int answer;
  public String solution(String number, int k) {
    StringBuilder sb = new StringBuilder();
    answer = -1;
    findMax(number.length()-k, number, sb, 0, 0);
    return Integer.toString(answer);
  }
  
  static void findMax(int xk, String number, StringBuilder sb, int start, int count) {
    if(count == xk) {
      if(Integer.parseInt(sb.toString()) > answer)
        answer = Integer.parseInt(sb.toString());
    }
    
    for(int i = start; i<number.length(); i++) {
      sb.append(number.charAt(i));
      findMax(xk, number, sb, i+1, count+1);
      sb.deleteCharAt(sb.length()-1); 
    }
  }
}

// 테케 다 돌아가서 오 되겠다 하고 제출했는데 1, 11, 12 빼고 다 런타임 에러났다ㅋㅋㅋㅠ 이걸 어쩌지

class Solution {
  static int answer;
  public String solution(String number, int k) {
    StringBuilder sb = new StringBuilder();
    answer = -1;
    findMax(number.length()-k, number, sb, 0, 0);
    return Integer.toString(answer);
  }
  static void findMax(int xk, String number, StringBuilder sb, int start, int count) {
    if(count == xk) {
      if(Integer.parseInt(sb.toString()) > answer)
        answer = Integer.parseInt(sb.toString());
    }
    char nMax = 0;
    for(int i = start; i<number.length(); i++) {
      if(number.charAt(i) >= nMax) {
        sb.append(number.charAt(i));
        findMax(xk, number, sb, i+1, count+1);
        sb.deleteCharAt(sb.length()-1);
        nMax = number.charAt(i);
      }
    }
  }
}

// 달라지는 건 없었다
// 다른 사람이 푼 걸 보니까 하나 붙인 다음부터는 거기서부터 시작해서 큰 수를 찾더라
// 위에 건 하나하나 다 비교하니까 시간이 오래 걸릴 수밖에...
// https://velog.io/@cchloe2311/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%81%B0-%EC%88%98-%EB%A7%8C%EB%93%A4%EA%B8%B0
// 이 블로그를 참고했다 (아니 베꼈다)

class Solution {
  public String solution(String number, int k) {
    StringBuilder answer = new StringBuilder();
    int pos = 0;
    
    for(int i = number.length()-k-1; i>=0; i--) {
      char max = '0';
      for(int j = pos; j < number.length()-i; j++) {
        if(number.charAt(j)>max) {
          max = number.charAt(j);
          pos = j+1;
        }
        if(max == '9') break;
      }
      answer.append(max);
    }
    return answer.toString();
  }
}

// 허탈
