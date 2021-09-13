//프로그래머스에서는 main함수 및 입출력문이 필요하지 않습니다. 대신 solution함수만 작성하면 됩니다.
//answer타입은 2차배열의 형태로서 List<String> 타입이 제안되었으나 수정하여 사용해도 됩니다.

import java.util.*;

class Main {
  public static List<String> solution(int r, int c, int zr, int zc, String[] words)  {
    List<String> answer = new ArrayList<>();
    
    for(int i =0 ;i<words.length; i++){
      StringBuilder sb = new StringBuilder();
      for(int l = 0; l<zr; l++){
        for(int j = 0; j<words[i].length(); j++)
          for(int k = 0; k<zc; k++)
            sb.append(Character.toString(words[i].charAt(j)));
        answer.add(sb.toString());
        sb.setLength(0);
      }
    }
    return answer;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int r, c, zr, zc;
    
    r=sc.nextInt();
    c=sc.nextInt();
    zr=sc.nextInt();
    zc=sc.nextInt();
    String[] words = new String[r];
    
    for(int i=0; i<r; i++) {
      words[i]=sc.next();
      if(words[i].length()>c)
      {
        System.out.println("입력 범위를 초과하였습니다.\n");
        System.exit(1);
      }
    }
    List<String> answer = solution(r,c,zr,zc,words);
    
    for(int i=0; i<answer.size(); i++)
    {
      System.out.println(answer.get(i));
    }
    
    sc.close();
  }
}
