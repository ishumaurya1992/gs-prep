package gsprep.mathematicsProblems;

import java.util.ArrayList;
import java.util.List;

/*Problem Statement:

Return an array containing prime numbers whose product is x
Examples:
primeFactorization( 6 ) == [2,3]
primeFactorization( 5 ) == [5]
                primeFactorization( 12 ) == [2,2,3]
Signature:
             public static ArrayList<Integer> primeFactorization(int x) {
              }
Test Cases- Input: 6
Output:[2,3] */
public class PrimeFactorization {


    public static void main(String[] args) {
        int num = 36;

        List<Integer> factor = primeFactor(num);
        factor.stream().forEach(System.out::println);
    }

    private static List<Integer> primeFactor(int num) {
        List<Integer> list = new ArrayList<>();

        if(num<=1)return list;

        while(num%2==0){
            list.add(2);
            num = num/2;
        }

        for (int i = 3; i <= Math.sqrt(num); i+=2) {

            while(num%i==0){
                list.add(i);
                num = num/i;
            }

        }

        if(num>2){
            list.add(num);
        }

        return list;
    }


}
