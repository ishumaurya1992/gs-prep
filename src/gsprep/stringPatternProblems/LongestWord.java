package gsprep.stringPatternProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Problem Statement-
 Given a string of letters and a dictionary, the function longestWord should
 find the longest word or words in the dictionary that can be made from the letters
 Input: letters = "oet", dictionary = {"to","toe","toes"}
 Output: {"toe"}
 Only lowercase letters will occur in the dictionary and the letters
 The length of letters will be between 1 and 10 characters
                 The solution should work well for a dictionary of over 100,000 words
Signature- Set<String> longestWord(String letters, Dictionary dictionary) {
                    }
Test Cases-
Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"});
   Input- toe
   Output- toe
Input – oetdg
Output- "doe", "toe", "dog", "god"
 */
public class LongestWord {


    public static void main(String[] args) {
        System.out.println(longestWord("oetdg",new ArrayList<>(Arrays.asList(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"}))).toString());
    }

    private static Set<String> longestWord(String s, ArrayList<String> strings) {

        int letter[] = new int[26];
        Set<String> result = new HashSet<>();
        int len = 0;
        for (int i = 0; i < s.length(); i++)letter[s.charAt(i)-'a']++;


        for (int i = 0; i < strings.size(); i++) {
            boolean found = true;
            for (int j=0;j<strings.get(i).length();j++){
                if(letter[strings.get(i).charAt(j)-'a']==0){

                    found = false;
                    break;
                }else{

                    continue;
                }
            }
            if(found){

                if( len<strings.get(i).length()){
                    len = strings.get(i).length();
                    result = new HashSet<>();
                    result.add(strings.get(i));
                }else if(len == strings.get(i).length()){
                    result.add(strings.get(i));
                }
            }


        }

        return   result;
    }


}
