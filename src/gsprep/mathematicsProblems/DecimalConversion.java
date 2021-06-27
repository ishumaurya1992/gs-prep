package gsprep.mathematicsProblems;

import java.util.HashMap;
import java.util.Map;

/*Problem Statement:

Implement the method that provided numerator and denominator will return a string representing fraction's decimal form.

                Some fractions in decimal form have cyclic decimal points.

public static String vulgarToDecimal(Long numerator, Long denominator) {

}

Test Cases:

 vulgarToDecimal(1l, 2l).equals("0.5");

 vulgarToDecimal(1l, 3l).equals("0.(3)");

 vulgarToDecimal(1l, 30l).equals("0.0(3)");

 vulgarToDecimal(1l, 75l).equals("0.01(3)");

  vulgarToDecimal(4l, 7l).equals("0.(571428)"); */
public class DecimalConversion {

    public static void main(String[] args) {
        int num  = 50;
        int den  = 7;
        System.out.println(decimalConversion(num,den));
    }

    private static String decimalConversion(int num, int den) {
        StringBuffer sb = new StringBuffer();
        Map<Integer,Integer> map = new HashMap<>();
        int q = num/den;
        int r = num%den;

        sb.append(q);

        if(r==0){
            return sb.toString();
        }else{
            sb.append(".");
            while(r!=0){
                if(map.containsKey(r)){
                    int pos = map.get(r);
                    sb.insert(pos,"(");
                    sb.insert(sb.length(),")");
                    return sb.toString();
                }else{
                     map.put(r,sb.length());
                     r*=10;
                     q = r/den;
                     sb.append(q);
                     r = r%den;
                }
            }
        }


        return sb.toString();
    }

}
