package gsprep.mathematicsProblems;
/*
* Problem Statement-
Returns true if x is a power-of-10. Otherwise returns false.
Signature:
bool isPowerOf10(int x){
}
Test Cases:
INPUT:
Input1: 3
Output1: false
Input1: 10
Output1: true 
*/
public class IsPowerOfTen {

    public static void main(String[] args) {

        int num = 1;
        int pow =1;
        System.out.println(isPowerOf10(num,pow));
    }

    private static boolean isPowerOf10(int num,int pow) {

        while(num%pow==0){

            num = num/pow;
            if(num==1){
                return true;
            }


        }
        return false;


    }
}
