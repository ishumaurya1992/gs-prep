package gsprep.mathematicsProblems;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/*
* Problem Statement-
Returns square root of the given double
Signature:
}
Test Cases:
Input1: 4
Ouput1:2
Input2:2
Output2: 1.41421   */
public class SquareRoot {

    public static void main(String[] args) {
        System.out.println(squareRoot(2));
       // System.out.println(squareRoot(7));
    }

    private static float squareRoot(int num) {
        int low =1;
        int high = num;
        double ans  = 0.0;
        while(low<=high){

            int mid = (low+high)/2;

            if(mid*mid==num){
                ans = mid;
                 break;
            }
            if(mid*mid>num){
                high = mid-1;
            }else{
                ans = mid;
                low = mid+1;
            }


        }


        double increment = 0.1;

            while (ans * ans <= num) {
                ans += increment;
            }
           ans = ans - increment;



        return (float)ans;
    }


}
