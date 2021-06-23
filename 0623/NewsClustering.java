import java.util.*;
class Solution {
  public int solution(String str1, String str2) {
    ArrayList<String> set1 = new ArrayList<>();
    ArrayList<String> set2 = new ArrayList<>();
    ArrayList<String> union = new ArrayList<>();
    ArrayList<String> intersection = new ArrayList<>();
    int i = 0;
    while(i < str1.length()-1) {
      if(isEng(str1.charAt(i), str1.charAt(i+1)))
        set1.add(str1.substring(i, i+2).toLowerCase());
      i++;
    }
    i = 0;
    System.out.println(str2.length()-1);
    while(i < str2.length()-1) {
      if(isEng(str2.charAt(i), str2.charAt(i+1)))
        set2.add(str2.substring(i, i+2).toLowerCase());
      i++;
    }
    Collections.sort(set1);
    Collections.sort(set2);
    
    for(String s : set1){
      if(set2.remove(s)){
        intersection.add(s);
      }
      union.add(s);
    }
    
    for(String s : set2){
      union.add(s);
    }
		
    double J;
    if(union.size() == 0)
      J = 1;
    else
      J = (double)intersection.size()/union.size();
    int answer = (int)(65536.0 * J);
    return answer;
  }
  static boolean isEng(char first, char second) {
    if(((first<=90 && first>=65) || (first<=122 && first>=97)) &&((second<=90 && second>=65) || (second<=122 && second>=97)))
      return true;
    else
      return false;
	}
}
