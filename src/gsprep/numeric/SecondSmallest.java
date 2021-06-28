package gsprep.numeric;

/*
Problem Statement-
Returns second smallest element in array x. If x has fewer than 2 elements returns 0.
Signature:
    int secondSmallest(int[] x)
Test Cases:
    Input:[ -1, 0, 1, -2, 2]
    Output: -1
    Input:[ 0, 1]
    Output: 1
*/

public class SecondSmallest {

    public static void main(String[] args) {
        int arr[] = {-1, -1,0, 1,-2, -2, 2};
         System.out.println( secondSmallest(arr) );
    }

    private static int secondSmallest(int[] arr) {
        int first = Integer.MAX_VALUE;
        int sec = first;

        for (int i = 0; i < arr.length; i++) {

            if(first>arr[i]){
                sec = first;
                first = arr[i];
            }else if(sec>arr[i] && first!=arr[i]){
                sec  = arr[i];
            }


        }
        return sec;
    }


}
