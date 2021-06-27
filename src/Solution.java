import java.util.Stack;

public class Solution {
    public static class Interval {
     int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

    public static void main(String args[]) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        int arr[]  = {9,8,7,6,5,4,3,2,1};

        for(int i:arr){
            st.push(i);
        }
        int value  = Integer.MAX_VALUE;
        while(true){
            while(st.isEmpty()){
                value = Math.min(st.peek(),value);
                temp.push(st.pop());
            }
        }

    }
}
