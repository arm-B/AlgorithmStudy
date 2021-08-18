import java.util.*;
class Solution {
  public String solution(String m, String[] musicinfos) {
    ArrayList<String> inputmelody = StoC(m, m.length());	
    int length = inputmelody.size();
    
    String answer = "(None)";
    for(int i = 0; i<musicinfos.length; i++) {
      String[] info = musicinfos[i].split(",");
      String[] start = info[0].split(":");
      String[] end = info[1].split(":");
      int playTime = Integer.parseInt(end[0])*60 + Integer.parseInt(end[1]) - Integer.parseInt(start[0])*60 - Integer.parseInt(start[1]);
      ArrayList<String> melody = StoC(info[3], playTime);
      
      for(int j = 0; j<playTime-length; j++) {
        if(melody.get(j).equals(inputmelody.get(0))) {	
          if(isSame(melody, inputmelody, j)) {
            answer = info[2];
          }
        }
      }
    }
    return answer;
  }
  
  static ArrayList<String> StoC (String s, int n){
    ArrayList<String> list = new ArrayList<>();
    
    for(int i = 0; i<n; i++) {
      if(s.charAt(i%s.length()) != '#')
        list.add(Character.toString(s.charAt(i%s.length())));
      else
        list.set(list.size()-1, list.get(list.size()-1)+"#");
    }
    return list;
  }
  
  static boolean isSame(ArrayList<String> melody, ArrayList<String> inputmelody, int start) {
    for(int i = 0; i<inputmelody.size(); i++) {
      if(!melody.get(start+i).equals(inputmelody.get(i)))
        return false;
    }
    return true;
  }
}

// 결과 3개 맞음 대단한 돌대가리임 런타임에러가 너무 난다... 그래서 그냥 바꿔봄

import java.util.*;
class Solution {
  public String solution(String m, String[] musicinfos) {
    String answer = "(None)";
		
    for(int i = 0; i<musicinfos.length; i++) {
      String[] info = musicinfos[i].split(",");
      String[] start = info[0].split(":");
      String[] end = info[1].split(":");
      int playTime = Integer.parseInt(end[0])*60 + Integer.parseInt(end[1]) - Integer.parseInt(start[0])*60 - Integer.parseInt(start[1]);
      
      ArrayList<String> melody = makePL(info[3], playTime);
      StringBuilder mld = new StringBuilder();
      for(String a : melody) mld.append(a);
      if(mld.toString().contains(m))
        answer = info[2];
    }
    return answer;
  }
  
  static ArrayList<String> makePL (String s, int n){
    ArrayList<String> list = new ArrayList<>();
    int i = 0, cnt = 0;
    while(cnt<n) {
      if(s.charAt(i%s.length()) != '#') {
        list.add(Character.toString(s.charAt(i%s.length())));
        cnt++;
      }
      else
        list.set(list.size()-1, list.get(list.size()-1)+"#");
      i++;
    }
    return list;
  }
}

// 이건 80점짜리 답... 8, 20, 25, 26, 27, 28이 틀렸다... 무슨 경우를 생각 못했을까
// omg 여러개일 경우 재생시간이 제일 긴게 답 이걸 생각 못했네 아이고 아이고
// ...? 이 조건 추가하니까 갑자기 5번이랑 30번 틀리기 시작 뭐하자는... 5, 8, 26, 30 ㅇㅁㅇ...?
// 8번 틀리는 건 다음게 #인지를 확인하면 된다길래 해봤고 8번은 맞았다... 갑자기 틀린 5, 30 환장하겠고 26은 도대체 뭘까...
// 뭘 생각 못 했을까... 왜 제일 긴 거 추가하는 조건만 넣으면 왜 5랑 30이 틀릴까


// 어쩌다가 위에서 그냥 contain있는 방법 말고 하나씩 비교하는 걸로 바꾸면서 코드가 되게 많이 바뀌었는데 이때 4, 6, 8, 11, 12랑... 20번 위쪽에서 6개 정도 틀림
// 이건 substring으로 따올 때 인덱스 오류나는 거라 append("X")하는 걸로 4개 해결

// 30번 풀려면 시간에서 뫄뫄~ 00:00인 거 고려해주래서 처음에 end[0]이 00이면 24인 거에서 바꿔주는 걸 넣었었는데 4,11 틀림
// 질문하기 들어가니까 이거 빼면 맞는다는 거임... 그래서 빼봤더니 정답
// 그러면 도대체 30번은 따로 처리도 안 했는데 왜 맞은 거...?? 맞히고서도 의문만 겁나 남는 문제...
// 카카오 안 갈게요...

import java.util.*;
class Solution {
  public String solution(String m, String[] musicinfos) {
    String answer = "(None)";
    
    int max = -1;
    for(int i = 0; i<musicinfos.length; i++) {
      String[] info = musicinfos[i].split(",");
      String[] start = info[0].split(":");
      String[] end = info[1].split(":");
      int playTime = Integer.parseInt(end[0])*60 + Integer.parseInt(end[1]) - Integer.parseInt(start[0])*60 - Integer.parseInt(start[1]);
      
      ArrayList<String> melody = makePL(info[3], playTime);
      StringBuilder mld = new StringBuilder();
      for(String a : melody) mld.append(a);
      mld.append("X");
      for(int j = 0; j<mld.length()-m.length(); j++) {
        if(mld.substring(j, j+m.length()).equals(m) && mld.charAt(j+m.length()) != '#' && playTime > max) {
          answer = info[2];
          max = playTime;
          break;
        }
      }
    } 
    return answer;
  }
  
  static ArrayList<String> makePL (String s, int n){
    ArrayList<String> list = new ArrayList<>();
    int i = 0, cnt = 0;
    while(cnt<n) {
      if(s.charAt(i%s.length()) != '#') {
        list.add(Character.toString(s.charAt(i%s.length())));
        cnt++;
      }
      else
        list.set(list.size()-1, list.get(list.size()-1)+"#");
      i++;
    }
    if(s.charAt(i%s.length()) == '#')
      list.set(list.size()-1, list.get(list.size()-1)+"#");
    
    return list;
  }
}

//구구절절문때문에 돌아버리겠다 진짜
