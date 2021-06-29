package gsprep.miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Problem Statement:
Given a list of student test scores, find the best average grade.
 Each student may have more than one test score in the list.
 Complete the bestAverageGrade function in the editor below.
 It has one parameter, scores, which is an array of student test scores.
 Each element in the array is a two-element array of the form [student name, test score]
 e.g. [ "Bobby", "87" ].
 Test scores may be positive or negative integers.
 If you end up with an average grade that is not an integer, you should
 use a floor function to return the largest integer less than or equal to the average.
 Return 0 for an empty input.
 Example:
 Input:
   [ [ "Bobby", "87" ],
     [ "Charles", "100" ],
     [ "Eric", "64" ],
     [ "Charles", "22" ] ].
 Expected output: 87
 Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
 respectively. 87 is the highest.
Signatue:

public static Integer bestAverageGrade(String[][] scores) {
}

Test Cases:
Input :
                        {{"Sarah", "91"},
                        {"Goldie", "92"},
                        {"Elaine", "93"},
                        {"Elaine", "95"},
                        {"Goldie", "94"},
                        {"Sarah", "93"}}
Output: 94
*/
public class BestAvgGrade {
    public static void main(String[] args) {
        String arr[][] = {{"Sarah", "91"},
                {"Goldie", "92"},
                {"Elaine", "93"},
                {"Elaine", "95"},
                {"Goldie", "94"},
                {"Sarah", "93"}};
        System.out.println(bestAverageGrade( arr));

    }

    private static String bestAverageGrade(String[][] arr) {
        Map<String, List<Integer>> map = new HashMap<>();


        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i][0])){
                     List<Integer> ls = map.get(arr[i][0]);
                     ls.add(Integer.valueOf(arr[i][1]));
                     map.put(arr[i][0],ls);
            }else{
                List<Integer> ls = new ArrayList<>();
                ls.add(Integer.valueOf(arr[i][1]));
                map.put(arr[i][0],ls);
            }
        }
        int maxAvg = 0;
        for(Map.Entry<String,List<Integer>> kv :map.entrySet()){
            int size = kv.getValue().size();
            int sum = kv.getValue().stream().mapToInt(i->i).sum();
            maxAvg = Math.max(maxAvg,sum/size);
        }

        return String.valueOf(maxAvg);

    }


}
