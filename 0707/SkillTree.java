import java.util.*;
class Solution {
  public int solution(String skill, String[] skill_trees) {
    ArrayList<Integer> index  = new ArrayList<>();
    int answer = 0;
    boolean toggle = false;
    
    for(int i = 0; i<skill_trees.length; i++) {
      boolean isOkay = true;
      int firstI = skill_trees[i].indexOf(skill.charAt(0));
      
      if(firstI>=0) {
        toggle = true;
        index.clear();
        index.add(firstI);
        for(int j = 1; j<skill.length(); j++)
          index.add(skill_trees[i].indexOf(skill.charAt(j)));
        
        for(int k = 0; k<index.size()-1;k++)
          if((index.get(k)>index.get(k+1) && index.get(k+1)!=-1) || (index.get(k) == -1 && index.get(k+1)>-1)) {
            isOkay = false;
            break;
          }
        
        if(isOkay)
          answer++;
      }
      
      else {
        for(int j = 1; j<skill.length(); j++)
          if(skill_trees[i].indexOf(skill.charAt(j))>-1) {
            isOkay = false;
            break;
          }
        
        if(isOkay) {
          toggle = true;
          answer++;	
        }
      }
    }
    if(!toggle)
      answer = -1;
    return answer;
  }
}

//첫 고비는 이제 뒤에 몇 개 안 나올 때 index 함수에는 -1로 들어가니까 뒤에가 무조건 작아지므로 isOkay가 false가 되는거
//그래서 &&부터의 조건을 추가해줬다. 현재 -1이면 그 뒤로는 무조건 -1이어야하므로 -1보다 커지면 isOkay는 false
//&& 바로 뒤 조건은 이제 2 3 -1 일 때 3하고 -1하고 비교하면 isOkay가 false가 되니까 일단 멈추고 다음 차례에 -1인 애랑 뒤에 거랑 비교하도록 만드는 역할이다

// 분명 맞게 한 거 같았는데 안 된다는 거임... 그래서 또 테스트 케이스를 뒤져봤다.
// 와... 해당되는 게 하나도 없어도 카운트 가능하다는 걸 생각을 못했음...
// 원래 큰 else문 싹 비워뒀는데 그거 보고 부랴부랴 추가하고 돌렸더니 또 맞았다고 떴다.
// 나는... 바보다....
