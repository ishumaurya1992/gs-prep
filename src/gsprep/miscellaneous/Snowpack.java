package gsprep.miscellaneous;
/*
Problem Statement:

Given an array of non-negative integers representing the elevations
  from the vertical cross section of a range of hills, determine how
  many units of snow could be captured between the hills.
  See the example array and elevation map below.

                                ___

            ___                |   |        ___

           |   |        ___    |   |___    |   |

 *        ___|   |    ___|   |   |   |   |   |   |

    ___|___|___|___|___|___|___|___|___|___|___|___

   { 0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0 }

                                ___

            ___                |   |        ___

           |   | *   *  _*_  * |   |_*_  * |   |

 *        ___|   | *  _*_|   | * |   |   | * |   |

    ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
   { 0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0 }
 Solution: In this example 13 units of snow (*) could be captured.
Signature: public static Integer computeSnowpack(Integer[] arr) {
}
Test Cases:

Input : {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0}
Output: 13

Input : {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
Output:10
 */
public class Snowpack {

    public static void main(String[] args) {

        System.out.println(computeSnowpack(new Integer[]{0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0}));
        System.out.println(computeSnowpack(new Integer[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}));
    }

    private static Integer computeSnowpack(Integer[] arr) {
        int res = 0;
        int leftMax[] = new int[arr.length];
        leftMax[0]  = arr[0];
        for (int i = 1; i < arr.length ; i++) {
            leftMax[i] = Math.max(leftMax[i-1],arr[i]);
        }
        int rightMax[] = new int[arr.length];
        rightMax[arr.length-1] = arr[arr.length-1];
        for (int i = arr.length-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1],arr[i]);

        }
        for (int i = 0; i < arr.length; i++) {
            res+= Math.min(leftMax[i],rightMax[i])-arr[i];
        }
        return res;
    }
}
