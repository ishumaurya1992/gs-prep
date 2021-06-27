import java.util.LinkedList;
import java.util.Queue;

public class Stack1 {



    static void sp(String str,String sc){

        if (str.length()==0){
            System.out.println(sc);
            return;
        }


       char ch = str.charAt(0);

      String rest = str.substring(1);
      if(Character.isAlphabetic(ch))
      { String o1 = (""+ch).toUpperCase();
        String o2 = ""+ch;
        sp(rest,sc+o1);
        sp(rest,sc+o2);
      }
      else {
          sp(rest,sc+ch);
      }
    }

   static class Pair{
        int data;
        int value;
        Pair(int data,int value){
            this.data = data;
            this.value = value;
        }
    }


    public static void main(String args[]) {
        Queue<Integer> queu =new LinkedList<>();
        queu.remove();
        System.out.println(Math.sqrt(12));
    }
       
    }
