package gsprep.array;
/*
Problem Statement:
Your task is ultimately to implement a function that takes in an array and a integer.
You want to return the *LENGTH* of the shortest subarray whose sum is at least the integer,
and -1 if no such sum exists.
Signature:
public static int subArrayExceedsSum(int arr[], int target) {
}
Test Cases:
     Input:[1,2,3,4,] , k=6
     Output :2
     Input:[1,2,3,4,] , k=-1
     Output :12
*/

public class SubArrayExceedingSum {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int  k = 6;
        System.out.println(subArrayExceedsSum(arr, k));
    }

    private static int subArrayExceedsSum(int[] arr, int k) {
        int i=0;
        int sum = 0;
        int j = 0;
        int len = Integer.MAX_VALUE;
        while(i<arr.length){
            sum+=arr[i];

            while(sum>k){
                len =  Math.min(len,(i-j)+1);
                sum-=arr[j++];


            }
            i++;
        }
        return len;
    }


}
