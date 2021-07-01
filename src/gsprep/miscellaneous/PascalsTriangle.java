package gsprep.miscellaneous;
/*
Problem Statement:
Pascals Triangle exhibits the following behaviour:
The first and last numbers of each row in the triangle are 1
Each number in the triangle is the sum of the two numbers above it.
 Example:
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
1 6 15 20 15 6 1

 Please Complete the ‘pascal’ function below so that given a
 col and a row it will return the value in that position.
 Example, pascal(1,2) should return 2

Signature:

public static int pascal(int col, int row){
}
Test Cases:
Input : 0,0
Output:1
Input : 1,2
Output:2
Input : 4,8
Output:70 */
public class PascalsTriangle {

    public static void main(String[] args) {
        System.out.println(pascal( 0,  0));
        System.out.println(pascal( 1,  2));
        System.out.println(pascal( 4,  8));
    }

    private static int  pascal(int col, int row) {
        int arr[][] = new int [row+1][row+1];
        arr[0][0]=1;
        for (int i = 1; i <arr.length ; i++) {
            for (int j = 0; j < arr.length ; j++) {
                if(j==0 || (j==i)){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = arr[i-1][j]+arr[i-1][j-1];
                }
            }
        }


        return arr[row][col];

    }
}
