package gsprep.miscellaneous;

/*
Problem Statement:

Given a string and size of the tuples, extracts all unique tuples(substrings) of the given size.
Signature:
HashSet<String> uniqueTuples( String input, int len ){
}
Test Cases:

Input : abbccde, 2
Output :
       ["ab"
        "bb",
        "bc",
        "cc",
        "cd",
        "de"]
*/

import java.util.HashSet;
import java.util.Set;

public class UniqueTuple {

    public static void main(String[] args) {
        System.out.println(uniqueTuples(  "abbccde",  2 ).toString());
    }

    private static Set<String> uniqueTuples(String str, int size) {
        Set<String> result = new HashSet<>();

        for (int j = 0; j < str.length()-1; j++) {
            result.add(str.substring(j,j+size));
        }

        return result;
    }

}
