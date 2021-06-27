import java.util.List;
import java.util.Stack;

public class LeetCodeArray {




    static boolean pairs(int nums[], int k) {
         int min=Integer.MAX_VALUE;
      if (nums.length<1)return false;
        for (int i = 0; i < nums.length-1;i++) {
              int j=i+1;

            if(nums[i]==1 && j<nums.length)
            {
                while (j<nums.length && nums[j]!=1 )
                {
                    j++;
                }
                if(j<nums.length&&nums[i]==1 && nums[j]==1)
                {
                    min = Math.min((j+1)-(i+1)-1,min);
                    i = j-1;
                }else
                    min=1;
            }


        }

        System.out.println(min);

if(min==k)return true;
else
   return false;



    }

   static boolean checkGreater(int i,int j,int arr[])
    {
        if(arr[j]>arr[i])
            return true;
        else
            return false;
    }

   static void  swap(int i,int j,int arr[]){

        int temp= arr[j];
         arr[j] = arr[i];
         arr[i]  = temp;

    }

    static  int [] bubbleSort(int []arr)
    {
        //9,1,4,5,1,3,2

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length-i; j++) {

                if(checkGreater(j,j-1,arr)){
                    swap(j,j-1,arr);
                }

            }
        }


        return arr;

    }


static  int [] selectionSort(int []arr)
    {
        //9,1,4,5,1,3,2
        for (int i = 0; i < arr.length; i++) {
            int min =i;
            for (int j = i+1; j < arr.length-i; j++) {

                if(checkGreater(j,min,arr)){
                    min = j;
                }
            }
            swap(i,min,arr);
        }


        return arr;

    }


  static  int count=0;
    static  int[]  mergeTwoSortedArray(int arr1[],int arr2[]){

        int []mergedArray = new int[arr1.length+arr2.length];

        int i=0;
        int j=0;
        int k=0;

        while (arr1.length>i&&arr2.length>j)
        {
            if(arr1[i]<arr2[j])
            {
                mergedArray[k]  =arr1[i];
                i++;
                k++;
            }
            else
            {
                mergedArray[k]=arr2[j];
                j++;
                k++;
                count++;
            }
        }

        while(arr1.length>i)
        {
            mergedArray[k] = arr1[i];
            i++;
            k++;
            count++;
        }
        while (arr2.length>j)
        {
            mergedArray[k] = arr2[j];
            j++;
            k++;
            count++;
        }

       // System.out.println(count);
        return mergedArray;

    }

    static  int [] insertionSort(int []arr)
    {
        //9,1,4,5,1,3,2
        for (int i = 1; i < arr.length; i++) {

            for (int j = i-1;j >=0; j--) {
                if(checkGreater(j+1,j ,arr)){
                    swap(j+1,j,arr);
                }
                else
                    break;

            }

        }


        return arr;

    }



    static  int  []mergeSort(int low,int high,int arr[])
    {
        if(low==high)
        {
            int re[] = new int [1];
            re[0] = arr[low];
            return re;
        }


        int mid  = (low+high)/2;

      int arrleft[] =   mergeSort(low,mid,arr);

      int arrRight[] = mergeSort(mid+1,high,arr);

      int []sortedArrya = mergeTwoSortedArray(arrleft,arrRight);

      return sortedArrya;
    }


    static int[] partationArray(int arr[],int target){

        int i=0;
        int j=0;

        while(arr.length>i) {
            if(arr[i]>target)
            {
                i++;
            }
            else
            {
                swap(i,j,arr);
                i++;
                j++;
            }

        }


        return arr;
    }

    private static int[] sortZeroOneTwo(int arr[]){

        int i=0;
        int j=0;
        int k=arr.length-1;

        while(i<=k)
        {
            if(arr[i]==1){
                i++;
            }
          else  if(arr[i]==2)
            {
                swap(i,k,arr);
                k--;
            }
            else
            {
                swap(i,j,arr);
                j++;
                i++;
            }

        }


        return arr;
    }

    private static int climbStairMemo(int stair,int []arr)
    {
        if(stair==0 )
        {

            return 1;
        }
        if(stair<0)return 0;

        if(arr[stair]>0)
        {
            return arr[stair];
        }

                System.out.println( );


       int one =climbStairMemo(stair-1,arr);

       int two =  climbStairMemo(stair-2,arr);

       int three =  climbStairMemo(stair-3,arr);

       int total = one+two+three;
        arr[stair] =total;


        return total;
    }

     static int climbStairMemoTab(int num){
        int arr[] = new int[num+1];
        arr[0] = 1;
        int totPath = 0;

         for (int i = 1; i <arr.length ; i++) {

            // for (int j = i-1; j >=0 ; j--) {
                     if(i==1)
                     {
                         totPath = 1;
                     }
                     else if(i==2)
                     {
                         totPath  = 2;
                     }
                     else
                         totPath = arr[i-1]+arr[i-2]+arr[i-3];

                     arr[i] =totPath;

             }
        // }


        return totPath;
     }

      public static void mazePath(int [][] maze) {
          int m = maze.length;
          int n = maze[0].length;

          int dp[][] = new int[m][n];

          int iniPath = 0;
          for (int i = maze.length - 1; i >= 0; i--) {

              for (int j = maze[i].length - 1; j >= 0; j--) {
                  if (i == maze.length - 1) {
                      iniPath = maze[i][j] + iniPath;
                      dp[i][j] = iniPath;
                  } else {
                      if (j == maze[i].length - 1) {
                          dp[i][j] = dp[i + 1][j] + maze[i][j];
                      } else {
                          dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + maze[i][j];
                      }
                  }

              }

          }

      }

      public static void goldDig(int [][] maze) {
          int m = maze.length;
          int n = maze[0].length;

          int dp[][] = new int[m][n];
          for (int j = maze[0].length - 1; j >= 0; j--) {
              for (int i = maze.length-1; i >=0 ; i--) {
                  if(j==maze[0].length-1)
                  {
                      dp[i][j] = maze[i][j];
                  }
                else  if(i==maze.length-1){

                    dp[i][j] = maze[i][j]+ Math.max(dp[i][j+1],dp[i-1][j+1]);
                  }
                  else if(i==0)
                  {
                      dp[i][j] = maze[i][j]+Math.max(dp[i+1][j+1],dp[i][j+1]);
                  }
                  else
                  {

                      dp[i][j] =maze[i][j]+ Math.max(Math.max(dp[i][j+1],dp[i-1][j+1]),dp[i+1][j+1]);
                  }

    }
          }

          System.out.println(dp[0][0]);
      }


     private static void targetSumSubset(int arr[],int tar)
      {
         boolean dp[][] = new boolean[arr.length+1][tar+1];

         dp[0][0] = true;
          for (int i = 1; i < dp.length; i++) {
              for (int j = 0; j < dp[0].length; j++) {

                  if(j==0){
                      dp[i][j] = true;
                  }

                  else if(arr[i-1]>j){
                     dp[i][j] = dp[i-1][j];
                  }//included


                 else if(arr[i-1]<=j){
                     if(j-arr[i-1]==0)
                     {
                         dp[i][j] = true;
                     }
                     else
                     {
                         if(dp[i-1][j])
                         {
                             dp[i][j] = true;

                         }
                         else
                         {
                             if(dp[i-1][j-arr[i-1]])
                                dp[i][j] = true;
                         }
                     }
                  }

                 else{

                  }

              }
          }
          System.out.println(dp[5][10]);

      }




    private static void  coinChangePermu(int arr[],int tar)
      {
          int coin[] =new int[tar+1];
           coin[0] = 1;

          for (int i = 0; i <coin.length ; i++) {

              for (int j = arr[i]; j <arr.length ; j++) {

                          coin[i] = coin[i] +coin[i-arr[j]];
                      }

          }
          System.out.println(coin[7]);


      }

      private static void  coinChangeCombination(int arr[],int tar)
      {
          int coin[] =new int[tar+1];
           coin[0] = 1;

          for (int i = 0; i <arr.length ; i++) {

              for (int j = arr[i]; j <coin.length ; j++) {

                         coin[j] = coin[j] +coin[j-arr[i]];
                     }




          }
          System.out.println(coin[7]);


      }


      private static void NapSack(int []arr,int sum[],int tar){

        int dp[][] = new int[arr.length+1][tar+1];

          for (int i = 1; i <dp.length ; i++) {

              for (int j = 0; j <dp[0].length ; j++) {

                  if(arr[i-1]>j){
                      dp[i][j] =dp[i-1][j];
                  }
                  else if(arr[i-1]<=j){

                      int v1 = dp[i-1][j];
                      int v2 = sum[i-1]+    dp[i-1][j-arr[i-1]];
                      int v3 = Math.max(v1,v2);
                      dp[i][j] = v3;
                  }

              }
          }
          System.out.println(dp[5][7]);

      }


       private static void  unboundNapSack(int arr[],int sum[],int tar){

        int dp[] = new int[tar+1];
           for (int i = 0; i <arr.length ; i++) {
               for (int j = 1; j <dp.length ; j++) {

                   if(j>=arr[i]){
                      dp[j] = Math.max(dp[j],dp[j-arr[i]]+sum[i]);
                   }


               }
           }
           System.out.println(dp[dp.length-1]);

    }

    private static void constiveZeroOne(int val)
    {
        int zero  =1;
        int one = 1;
        for (int i = 2; i <=val ; i++) {
           int  onee = zero+one;
           int  zeroo = one;

           zero = zeroo;
           one = onee;
        }
        System.out.println(one+zero);
    }
    //4,5,2,25
    public static void  getNextGreaterEle(int []  arr){
        int nge[] =new int[arr.length];
        Stack<Integer> st =new Stack<>();
        st.push(arr.length-1);
        for (int i = arr.length-2; i >=0 ; i--) {
            //arr[i]>arr[st.peek()]//pop
            while(!st.isEmpty()&& arr[i]<arr[st.peek()]) {
                nge[st.pop()] = i;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            nge[st.pop()]=-1;
        }
        for (int i = 0; i <nge.length ; i++) {
            System.out.println(nge[i]);
        }
    }

    public static void wordBreak(List<String> dict, String str,String ans)
    {

        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for (int i = 0; i <str.length() ; i++) {

            if(dict.contains(str.substring(0,i+1))){
                 wordBreak(dict,str.substring(i+1),ans+str.substring(0,i+1));
            }

        }

    }

    static void partationPalindrome(String pal,String ans,List<String> list){


        if(pal.length()==0)
        {
            for (String s: list) {
                System.out.print(s+"-->");

            }
            System.out.println();

            return;
        }
        for (int i = 0; i <pal.length() ; i++) {

            if(isPalindrome(0,i,pal)){

                String res = pal.substring(0,i+1);
                String ques = pal.substring(i+1);
                list.add(res);
                partationPalindrome(ques,ans +"--"+res,list);
                list.remove(list.size()-1);

            }

        }

    }

    static  boolean  isPalindrome(int l,int h,String str){

        while(l<h){
            if(str.charAt(l)==str.charAt(h)){
                l++;
                h--;
            }
            else
                return false;

        }

        return true;
    }

    public  static  void main(String args[])
    {
     // int arr1[] = {0,9,7,3,2,1};
      int arr2[] = {5,9,10,12};
      int arrpart[] = {0,2,4,0,4,8,0,9};

     // int arr[] =  sortZeroOneTwo( arrpart);
    //  int arr[] =  partationArray( arrpart,0);
     // int arr[] =  partationArray( arrpart,5);
     // int arr[] =  partationArray( arrpart,5);

        //  int arr[] =new int[11];
       // System.out.println(climbStairMemoTab(5));
        int maze[][]={{0 ,1 ,4 ,2, 8 ,2},
                      {4 ,3 ,6 ,5 ,0 ,4},
                      {1 ,2 ,4 ,1 ,4 ,6},
                      {2 ,0 ,7 ,3 ,2 ,2},
                      {3 ,1 ,5 ,9 ,2 ,4},
                      {2, 7, 0, 8 ,5 ,1}};

       // goldDig(maze);

        int arr1[] = {2 ,5 ,1 ,3 ,4};
        int sum[]={15 ,14 ,10 ,45 ,30};
        int nle[]={1, 20, 6, 4, 5 ,1};
       int arr[] =  mergeSort(0,nle.length-1,nle);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
       // System.out.println(count);

        int i=0;
        int j=0;
       // System.out.println(i++ +"==>"+ ++j);

    }




}
