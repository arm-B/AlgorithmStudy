class Solution {
  public int solution(int[] arr) {
    int i;
    for(i = 0; i<arr.length-1; i++){
      // 두 수 곱한 거를 최대공약수로 나누면 최소공배수
      arr[i+1] = arr[i] * arr[i+1] / gcd(arr[i], arr[i+1]);
    }
    return arr[i];
  }
  
  static int gcd(int a, int b){
    while(b != 0){
      int r = a % b;
      //gcd(a,b) = gcd(b,r)
      a = b;
      b = r;
    }
    return a;
  }
}
