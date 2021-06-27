import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Substrings {


    static void getTickPath() {
        Map<String, String> hm = new HashMap<>();
        hm.put("C", "B");
        hm.put("X", "D");
        hm.put("G", "C");
        hm.put("D", "G");

        Map<String, Boolean> src = new HashMap<>();

        hm.forEach((k, v) -> {
            src.put(v, false);
            if (!src.containsKey(k))
                src.put(k, true);

        });
        String start = "";
        for (String str : hm.keySet()) {
            if (src.get(str) == true) {
                start = str;
                break;
            }
        }

        for (int i = 0; i < hm.size(); i++) {
            System.out.print(start + "==>");
            start = hm.get(start);
        }
        System.out.print(start);
        System.out.print(".");


    }

    private static void getDistincWithKElement(String str,int k){
        Map<Character ,Integer> hm =new HashMap<>();
        int maxDistinct = 0;
        int i=0;
       while(i<=k-2){
            hm.put(str.charAt(i),hm.getOrDefault(str.charAt(i),0)+1);
            i++;
        }

        int j=-1;

        while(i<str.length()-1 ){
            i++;

            hm.put(str.charAt(i),hm.getOrDefault(str.charAt(i),0)+1);

            maxDistinct = Math.max(maxDistinct,hm.size());

            j++;
            if(hm.get(str.charAt(j))==1)
                hm.remove(str.charAt(j));
            else
              hm.put(str.charAt(j),hm.get(str.charAt(j))-1);

           // i++;
        }

      System.out.println(maxDistinct);
    }


   private static void  getSubArrayWith0Sum(int arr[]){
        Map<Integer,Integer> hm =new HashMap<>();
        int sum = 0;
        int i=-1;
        int count =0;
        hm.put(i,sum);


            while (i < arr.length - 1) {
                i++;
                sum += arr[i];
                if (hm.containsKey(sum)) {

                      count += hm.get(sum);

                      hm.put(sum,hm.get(sum)+1);

                } else {
                    hm.put(sum,i );
                }

            }

       System.out.println(count);
   }

   private void getMinimumWindow(String str1,String str2){
        Map<Character ,Integer>  small = new HashMap<>();
       Map<Character ,Integer>  large = new HashMap<>();

       for (int i = 0; i <str2.length() ; i++) {
           small.put(str2.charAt(i),small.getOrDefault(str2.charAt(i),0)+1);
       }

       int i=-1;
       int j=-1;
       int dmct  = str2.length();
       int mct = 0;
       String ans = "";
       while(true){
           boolean flag1 = false;
           boolean flag2 = false;

           while (i<str1.length()-1 && mct<dmct){
               flag1 = true;
               i++;
               char ch = str1.charAt(i);
               large.put(ch,large.getOrDefault(ch,0)+1);

              if(small.getOrDefault(ch,0)>=large.getOrDefault(ch,0)){
                  mct++;
              }

           }
           while (j<i && dmct==mct){
               flag2 = true;
               String potans = str1.substring(j+1,i+1);

               if(ans.length()==0 || potans.length()<ans.length()){
                   ans = potans;

               }
               j++;
               char ch =str1.charAt(j);
               if(large.get(ch)==1)
                   large.remove(ch);
               else
                   large.put(ch,large.get(ch)-1);

               if(small.getOrDefault(ch,0)<large.getOrDefault(ch,0)){
                   mct--;
               }
          }

        if(!flag1 && !flag2){
            break;
        }
       }




   }
    static int R = 3;
    static int C = 5;


    static boolean issafe(int i, int j)
    {
        if (i >= 0 && i < R &&
                j >= 0 && j < C)
            return true;

        return false;
    }

    static int rotOranges(int v[][])
    {
        boolean changed = false;
        int no = 2;

        while (true)
        {
            for(int i = 0; i < R; i++)
            {
                for(int j = 0; j < C; j++)
                {


                    if (v[i][j] == no)
                    {
                        if (issafe(i + 1, j) &&
                                v[i + 1][j] == 1)
                        {
                            v[i + 1][j] = v[i][j] + 1;
                            changed = true;
                        }
                        if (issafe(i, j + 1) &&
                                v[i][j + 1] == 1)
                        {
                            v[i][j + 1] = v[i][j] + 1;
                            changed = true;
                        }
                        if (issafe(i - 1, j) &&
                                v[i - 1][j] == 1)
                        {
                            v[i - 1][j] = v[i][j] + 1;
                            changed = true;
                        }
                        if (issafe(i, j - 1) &&
                                v[i][j - 1] == 1)
                        {
                            v[i][j - 1] = v[i][j] + 1;
                            changed = true;
                        }
                    }
                }
            }


            if (!changed)
                break;

            changed = false;
            no++;
        }

        for(int i = 0; i < R; i++)
        {
            for(int j = 0; j < C; j++)
            {


                if (v[i][j] == 1)
                    return -1;
            }
        }


        return no - 2;
    }
    public static void main(String args[]) {
        HashMap<Character,Integer> map = new LinkedHashMap<>();
        String str = "geeksforgeeks";

        for(int i =0;i<str.length();i++){

            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        String values = "";
        for(Map.Entry<Character,Integer> vals:map.entrySet()){
            values+=vals.getKey() +""+vals.getValue();
        }

        System.out.checkError();
    }

    }





