package gsprep.stringPatternProblems;

/*
Problem Statement –
Given two words returns the shortest distance between their two midpoints in number of characters,  words can appear multiple times in any order and should be case insensitive.
Signature :
public static double shortestDistance(String document, String word1, String word2) {
               }
Test Cases:

String Document – “In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements”.
shortestDistance( document, "is", "a" ) == 2.5
*/


import gsprep.DataStructureImpl.MyHashMap;
import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

import java.util.HashMap;
import java.util.Map;

public class DistanceBetweenStrings {

    public static void main(String[] args) {
        String str= "geeks for geeks contribute practice";
        String w1 = "geeks";
        String w2 = "practice";
        System.out.println(shortestDistance(str,w1,w2));
    }

    private static int shortestDistance(String str, String w1, String w2) {

        String [] strarr = str.split(" ");



        return 0;

    }

}
