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
        String str= "In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements.";
        String w1 = "is";
        String w2 = "a";
        System.out.println(shortestDistance(str,w1,w2));
    }

    private static double shortestDistance(String str, String w1, String w2) {

        String [] strarr = str.split(" ");

            double first = 0;
            double second = 0;
            double cuurSum = 0;
            int i=0;
            double minValue = Integer.MAX_VALUE;
            while(i<strarr.length){
                if(w1.equals(strarr[i])){
                    first = cuurSum+ (strarr[i].length()/2.0);
                }else if(w2.equals(strarr[i])){
                    second = cuurSum+ (strarr[i].length()/2.0);
                }

                if(first>0 && second>0){
                    minValue = Math.min(second-first,minValue);
                }

                cuurSum+=strarr[i].length()+1;
                i++;
            }



            return minValue;
    }

}
