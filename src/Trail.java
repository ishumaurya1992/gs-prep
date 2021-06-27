import java.util.Stack;

public class Trail {
    static int count = 0;

    static void floodFill(int[][] arr, int row, int col, String res, boolean flood[][]) {
        count++;
        if (row < 0 || col < 0 || row >= arr.length || col >= arr[0].length || arr[row][col] == 1) {
            return;
        }
        if (row == arr.length - 1 && col == arr[0].length - 1) {
            System.out.println(res);
            return;
        }
        arr[row][col] = 1;
        floodFill(arr, row - 1, col, res + "t", flood);
        floodFill(arr, row + 1, col, res + "d", flood);
        floodFill(arr, row, col + 1, res + "r", flood);
        floodFill(arr, row, col - 1, res + "l", flood);
        arr[row][col] = 0;

    }


    static void polishNotation(String arr[]) {
        Stack<Integer> num = new Stack<>();


        for (int i = 0; i < arr.length; i++) {

            String val = arr[i];
            if (val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/")) {
                if (val.equals("*")) {
                    int val1 = num.pop();
                    int val2 = num.pop();
                    num.push(val2 * val1);

                } else if (val.equals("+")) {
                    int val1 = num.pop();
                    int val2 = num.pop();
                    num.push(val2 + val1);
                } else if (val.equals("-")) {
                    int val1 = num.pop();
                    int val2 = num.pop();
                    num.push(val2 - val1);
                } else if (val.equals("/")) {
                    int val1 = num.pop();
                    int val2 = num.pop();
                    num.push(val2 / val1);
                }

            } else {
                num.push(Integer.parseInt(arr[i]));


            }


        }

        while (!num.isEmpty()) {
            System.out.println(num.pop());
        }


    }

    static int cal(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for (int i : stack) {
            re += i;
        }
        return re;




    }
    static void swap(int j,int i,char[] arr){
        while(j<i){
            char temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            j++;
            i--;
        }
    }
   static class Pair{
        String data;
        int count;
        Pair(String data,int count){
            this.data = data;
            this.count = count;
        }
    }
    public static void main(String args[]) {
        String preorder = "9,#,92,#,#";
        String nodes [] =  preorder.split(",");;
        Stack<Pair> st =new Stack<>();

        for(int i=0;i<nodes.length;i++){

            if(!st.isEmpty()){
                if(nodes[i].equals("#")){
                    ++st.peek().count;
                    //System.out.print(st.peek().data+" ="+st.peek().count);
                    while(!st.isEmpty() && st.peek().count==2)st.pop();
                }else{
                    //   if(st.peek().count==1){
                    st.peek().count++;
                    st.push(new Pair(nodes[i],0));
                    // }
                }
            }
            else{
                st.push(new Pair(nodes[i],0));
            }

        }

        System.out.println(st.empty());




    }



    }

