package gsprep.stringPatternProblems;
/*
Problem Statement-
The sentence “The quick brown fox jumps over the lazy dog" contains
every single letter in the alphabet. Such sentences are called pangrams.
write a function findMissingLetters, which takes a String “sentence,
and returns all the letters it is missing (which prevent it from
being a pangram). You should ignore the case of the letters in sentence,
and your return should be all lower case letters, in alphabetical order.
you should also ignore all non US-ASCII characters.

Signature:

String findMissingLetters(String sentence) {

}

Test Cases:
Input: The slow purple oryx meanders past the quiescent canine
Output: bfgjkvz
*/
public class Pangram {



    public static void main(String[] args) {
        String sentence ="The slow purple oryx meanders past the quiescent canine";
        String missingLetter =  findMissingLetters(sentence);
        System.out.println(missingLetter);
    }

    private static String findMissingLetters(String sentence) {
        String sec = sentence.toLowerCase();
        int arr[] = new int[26];
        for (int i = 0; i < sec.length(); i++) {

            if(sec.charAt(i)>='a' && sec.charAt(i)<='z'){
                arr[sec.charAt(i)-'a']++;
            }

        }

        String res= "";

        for (int i = 0; i < arr.length ; i++) {
            if(arr[i]==0){
                res+=(char)(i+'a');
            }
        }

        return res;

    }

}
