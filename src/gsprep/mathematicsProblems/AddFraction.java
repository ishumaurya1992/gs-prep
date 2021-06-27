package gsprep.mathematicsProblems;

/*Problem Statement-
    Given two fractions passed in as int arrays,
     returns the fraction which is result of adding the two input fractions
     Fraction is represented as a two-element array - [ numerator, denominator ]
                     The returned fraction has to be in its simplest form.
Signature:
                      int[] addFractions ( int[] fraction1, int[] fraction2 ){
                       }
Test Cases:

                   INPUT:
                      fraction1 - [2, 3];
                                      fraction2 - [1, 2];
                      OUTPUT: Hint-  {2/3 +1/2}
                       result = [7,6] */

public class AddFraction {

    public static void main(String[] args) {
        int fraction1[] = {2, 3};
        int fraction2[] = {1,2};

        System.out.println(addFractions(fraction1,fraction2));

    }

    private static  String  addFractions(int[] fraction1, int[] fraction2) {

        int num1  = fraction1[0];
        int den1 = fraction1[1];
        int num2 = fraction2[0];
        int den2 = fraction2[1];

        int den3 = (den1*den2)/gcd(den1,den2);

        int num3 = num1*(den3/den1) + num2*(den3/den2);

        int commonFactor  =  gcd(num3,den3);




        return num3/commonFactor +"/"+den3/commonFactor;
    }


    static int gcd(int a,int b){

        if(a==0)return b;

       return gcd(b%a,a);

    }

}
