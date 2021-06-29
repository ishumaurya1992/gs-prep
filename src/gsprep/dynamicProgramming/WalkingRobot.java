package gsprep.dynamicProgramming;
/*
Problem Statement:
Implement the ‘walk" method. This method takes in a string, path,
where each character in the string corresponds to a potential movement
of the robot. The robot can move up, down, left, and right represented
by the characters ‘U', 'D', "L', and 'R' respectively. All other
characters may be ignored. Assume the robot's initial position
is at (0,0). The output of this method is the robot's final x and y
                coordinates relative to the initial position
Signature:
                public static Integer[] walk(String path) {
               }
Test Cases:

Input: “”(Blank)
Output: [0,0]

Input: “L”
Output: [-1,0]

Input: “UUU”
Output: [0,3]

Input: “ULDR”
Output: [0,0]
*/
public class WalkingRobot {
    public static void main(String[] args) {
        Integer[] output1 = walk("");
        System.out.println(output1[0]+" "+output1[1]);
        Integer[] output2 = walk("L");
        System.out.println(output2[0]+" "+output2[1]);
        Integer[] output3 = walk("UUU");
        System.out.println(output3[0]+" "+output3[1]);
        Integer[] output4 = walk("ULDR");
        System.out.println(output4[0]+" "+output4[1]);
    }

    private static Integer[] walk(String str) {
        Integer[] ans = new Integer[2];
        ans[0] = 0;
        ans[1] = 0;
        for (int i = 0; i <str.length() ; i++) {
                char di = str.charAt(i);
                if(di=='U'){
                    ans[1]++;
                }else if(di=='D'){
                      ans[1]--;
                }else if(di=='L'){
                    ans[0]--;
                }else if(di=='R'){
                    ans[0]++;
                }

        }

        return ans;
    }
}
