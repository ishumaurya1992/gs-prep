package gsprep.stringPatternProblems;
/*Problem Statement –

Finds the first character that does not repeat anywhere in the input string
If all characters are repeated, return 0
Given “apple”, the answer is “a”
Given “racecars”, the answer is “e"
Signature :
char findFirst(String input){
}
Test Cases-
Input: apple
Output: a
Input – xxyyzz
Output - 0

*/

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "xxyyzz";
        System.out.println(firstNonRepeatingCharacter(str1));
        System.out.println(firstNonRepeatingCharacter(str2));
    }

    private static String firstNonRepeatingCharacter(String str) {

        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < str.length() ; i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0)+1);
        }
        char ch  = '0';
        for(int i = 0; i < str.length() ; i++){
            if(map.get(str.charAt(i))==1){
                ch = str.charAt(i);
                break;
            }
        }

        return String.valueOf(ch);
    }
}
