import java.io.*;
class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    int isO = 0, answer = 0;
    for(int i =0 ; i<input.length(); i++){      
      char tmp = input.charAt(i);
      if(tmp == 'O')
        isO += 1;
      else
        isO = 0;
      answer += isO;
    }
    System.out.println(answer);
  }	
}
//달달하다 ^~^
