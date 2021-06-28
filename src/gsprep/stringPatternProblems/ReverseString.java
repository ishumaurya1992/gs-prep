package gsprep.stringPatternProblems;
/*
Problem Statement :

Takes String str and returns a new String

such that the characters are in reversed order.
Example: reverseStr(str) where str is “abcd " returns “dcba".
Signature: public static String reverseStr( String str ){
}
Test Cases:
Input : abcd
Output: dcba

 */
public class ReverseString {

    public static void main(String[] args) {

        System.out.println(reverseStr("/gH?yZx"));
        System.out.println(reverseStr("/gH?#&yZx"));
        System.out.println(reverseStr("/gH?yZ&x"));

    }

    private static String reverseStr(String str) {

        int i=0,j=str.length()-1;
        char[] data = str.toCharArray();
        while(i<j){
            if(Character.isLetterOrDigit(data[i]) && Character.isLetterOrDigit(data[j])){
                char ch = data[i];
                data[i] = data[j];
                data[j] = ch;
                i++;j--;
            }else if(!Character.isLetterOrDigit(data[i])){
                i++;
            }else if (!Character.isLetterOrDigit(data[j])){
                j--;
            }


        }

        return String.valueOf(data);

    }
}
