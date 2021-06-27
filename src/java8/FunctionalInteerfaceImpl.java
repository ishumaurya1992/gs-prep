package java8;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;

public class FunctionalInteerfaceImpl  {
     static int numInstances = 0;
     static int getCount() {
        return numInstances;
    }
    private static void addInstance() {
        numInstances++;
    }
    static String val ;
    FunctionalInteerfaceImpl(){
        System.out.println("hi");
        val = "str";
    }
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Scanner keyboard = new Scanner(new InputStreamReader(
                System.in, Charset.forName("UTF-8")));
        System.out.println(keyboard.next().charAt(0));;



    }
}
