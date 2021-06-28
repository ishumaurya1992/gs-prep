package gsprep.stringPatternProblems;

/*
Problem Statement-
For a string input the function returns output encoded as follows:
"a" -> "a1"
"aa" -> "a2"
"aabbb" -> "a2b3"
"aabbbaa" -> "a2b3a2"

Signature :

String rle(String input) {

}
Test Case:
Input : aaabbbaad

Output: a3b3a2d1
*/

public class RunLengthEncoding {

    public static void main(String[] args) {
        String word =  "aaabbbaad";
        String str  = rle(word);
        System.out.println(str);
    }

    private static String rle(String word) {

        int i=0;
        StringBuilder sb =new StringBuilder();
        while(i<word.length()){

            int count = 1;
            int j =i+1;
            while(j<word.length() && word.charAt(i)==word.charAt(j)){
                count++;
                j++;
            }
            sb.append(word.charAt(i));
            sb.append(count);

            i=j;



        }

        return sb.toString();
    }

}
