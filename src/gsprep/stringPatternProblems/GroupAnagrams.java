package gsprep.stringPatternProblems;

/*
Problem Statement:
Given a list of words, group them by anagrams
Input: List of
 Output: A Set of Sets of anagrams: {{‘cat'}, {‘dog', ‘god'}}
Signature : Set<Set<String>> group(List<String> words){
                     }
Test Cases –
Input : ["cat", "dog", "god"]
Output: [[“cat”],[“dog”,”god”]]

*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GroupAnagrams {

    public static void main(String[] args) {
        String []str={"cat", "dog", "god"};
        Set<Set<String>> anargams = anargamGroup( str);
    }

    private static Set<Set<String>> anargamGroup(String[] words) {
        Set<Set<String>> set = new HashSet<>();
        Map<String,Set<String>> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
             int arr[] = new int [26];
            for (int j = 0; j < words[i].length(); j++) {
                arr[words[i].charAt(j)-'a']++;
            }
            String value = String.valueOf(arr);

            if(map.containsKey(value)){
                map.get(value).add(words[i]);
            }else{
                Set<String> getset = new HashSet<>();
                getset.add(words[i]);
                map.put(value,getset);
            }


        }

        map.forEach((k,v)->{
            set.add(v);
        });

        return set;
    }


}
