package gsprep.stringPatternProblems;
/*
Problem Statement-
This method should return an integer array with two elements that correctly identifies the location of the longest
uniform substring within the input string. The first element of the array should be the starting index of the longest substring and the second element should be the length.
input: “abbbccda" the longest uniform substring is “bbb” (which starts at index 1 and is 3 characters long.
Signature :
int[] longestUniformSubstring(String input) {
}
Test Cases –
Input : aabbbbbCdAA

Output – [2,5]
*/
public class LongestUniformSubstring {




    public static void main(String[] args) {
        String str  = "abbbccda";
        int [] arr = longestUniformSubstring(str);
        System.out.println(arr[0]+" "+arr[1]);
    }






  static private int[] longestUniformSubstring(String str) {
    int  j =0;
    int i = 0;
    int maxLen = 0;
    int result[] = new int [2];

    while(i<str.length()){

        while(j<str.length() && str.charAt(i)==str.charAt(j)){
            j++;
        }


        if(maxLen<j-i){

            maxLen = j-i;
            System.out.println(maxLen);
            result[0] = i;
            result[1] = j-1;
        }

        i=j;

    }
        return result;
    }

}
