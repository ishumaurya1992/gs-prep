import java.util.ArrayList;

public class Recursion {

  static   ArrayList<String> printDesc(String num){

       if(num.length()==0){
           ArrayList<String> list = new ArrayList<>();
           list.add(" ");
           return list;

       }

       char ch = num.charAt(0);

       String s = num.substring(1);

      ArrayList<String>rres= printDesc(s);
      ArrayList<String> mres = new ArrayList<>();

        for (String ss:rres) {

            mres.add(ss);
        }

        for (String a: rres) {

            mres.add(ch+a);
        }
          return mres;
    }


     static ArrayList<String> mazePath(int sr,int sc,int dr,int dc){

      if(dr==sr && dc==sc){
          ArrayList<String> list = new ArrayList<>();
          list.add("");
          return list;
      }
      ArrayList<String> hp = new ArrayList<>();
      ArrayList<String> cp =new ArrayList<>();

      if(sc<dc)
      hp = mazePath(sr,sc+1,dr,dc);

      if(sr<dc)
      cp = mazePath(sr+1,sc,dr,dc);

      ArrayList<String> ls =new ArrayList<>();

         for (String v:cp) {
             ls.add("v"+v);

         }
          for (String h:hp) {
             ls.add("h"+h);

         }

      return ls;

     }


   static   int []mergeSort(int arr[],int low,int high){
      if(low==high){
          int newArry[] = new int[1];
          newArry[0] = arr[low];
          return newArry;
      }
      int mid  = (low+high)/2;

      int left[] = mergeSort(arr,low,mid);
      int right []= mergeSort(arr,mid+1,high);

      return mergeArray(left,right);
     }
      static   int count = 0;
     static  int[]mergeArray(int left[],int right[]){

      int []arr = new int[left.length+right.length];
      int i=0;
      int j=0;
      int k=0;

      while(i<left.length && j<right.length){
          if(left[i]<right[j]){

              arr[k]  = left[i];
              i++;
              k++;
          }else{
              count++;
              arr[k]  = right[j];
              j++;
              k++;
          }
      }

      while(i<left.length){
        //  count++;
          arr[k] = left[i];
          i++;
          k++;
      }


         while(j<right.length){
             count++;
             arr[k] = right[j];
             k++;j++;
         }
         return arr;
     }

    public static void main(String args[])
    {
        int arr[] = {8, 4, 2, 1};
        int arry[]= mergeSort(arr,0,arr.length-1);
        for (int a: arry) {
            System.out.println(a);

        }
        System.out.println("count:=="+count);
    }

}
