package gsprep.miscellaneous;
/*
Problem Statement:
     You are given an integer array of size N.
     Every element of the array is greater than or equal to 0.
     Starting from arr[startIndex], follow each element to the index it points to.
     Continue to do this until you find a cycle.
     Return the length of the cycle. If no cycle is found return -1
     Examples:

Signature:
Int countLengthofcycle(arr, startIndex){
}
Test Cases:
Input :
arr: [1,0]
startIndex: 0
Output :2
Input :
arr: [1,2,0]
startIndex: 0
Output :3
*/
public class CountLengthOfCycle {


    public static void main(String[] args) {
        System.out.println(countLengthofcycle(new int[]{1,0},0));
        System.out.println(countLengthofcycle(new int[]{1,2,0},0));
    }

    private static int countLengthofcycle(int[] arr, int start) {
        int count  = 1;
        while(arr[start]>0){
            if(start>= arr.length)return -1;
            int val  = arr[start];
            if(val<0){
                return -1;
            }
            arr[start]*=-1;
            start = val;
            count++;
        }
        return count;


    }
}
