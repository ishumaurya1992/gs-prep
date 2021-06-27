import java.util.ArrayList;
import java.util.List;

public class PermutationCombinationDP {

    //abc
    static void permutation(String str, String res) {


        //     if (res.length()==0)return;
        if (str.length() == 0) {
            System.out.println(res);
            return;
        }

        boolean arr[] = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            if(arr[ch-'a']==false)
            permutation(left + right, res + ch);
            arr[ch-'a']=true;
        }

    }


    static void combination(String str, String res) {

        if (str.length() == 0) {
            System.out.println(res);
            return;
        }

        char ch = str.charAt(0);
        String rest = str.substring(1);
        combination(rest, res + ch);
        combination(rest, res);


    }

    static int low = 0, maxubStringLength = 0;

    static void palindrome(String str) {


        for (int i = 0; i < str.length(); i++) {
            getPalindrome(i, i, str);
            getPalindrome(i, i + 1, str);

        }
        System.out.println(low + "==>" + maxubStringLength);
        System.out.println("===>" + str.substring(low, maxubStringLength + low));


    }


    static void getPalindrome(int l, int h, String str) {

        while (l >= 0 && h < str.length() && str.charAt(l) == str.charAt(h)) {
            System.out.println(str.substring(l, h + 1));
            l--;
            h++;

        }
        if (maxubStringLength > h - l - 1) {
            maxubStringLength = h - l - 1;
            low = l + 1;
        }
    }

   static int zeroOneNapsackRecursive(int []wt,int []val,int n,int maxWeight,int arr[][]){

        if(n==0 || maxWeight==0){
            return 0;
        }


        if(arr[n][maxWeight]!=0)
            return arr[n][maxWeight];

        if(wt[n-1]>maxWeight)
            return zeroOneNapsackRecursive(wt,val,n-1,maxWeight,arr);

        arr[n][maxWeight] =   Math.max(val[n-1]+ zeroOneNapsackRecursive(wt,val,n-1,maxWeight-wt[n-1],arr),
               zeroOneNapsackRecursive(wt,val,n-1,maxWeight,arr));
            return arr[n][maxWeight];

    }

    static int zeroOneNapSackTopDown(int []wt,int []val,int n,int w ){

        int dp[][] = new int[n+1][w+1];


        for (int i = 1; i <dp.length ; i++) {

            for (int j = 1; j <dp[0].length ; j++) {

                if(j<wt[i-1]){
                    dp[i][j] = dp[i-1][j];

                }else if(j>=wt[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j],val[i-1]+dp[i-1][j-wt[i-1]]);
                }



            }
        }


        return dp[n][w];
    }

   static boolean targertSumSubset(boolean dp[][],int arr[]){

        dp[0][0] = true;
       for (int i = 1; i < dp.length ; i++) {
           dp[i][0] = true;
           for (int j = 0; j <dp[0].length ; j++) {
               if(j<arr[i-1])
                   dp[i][j] = dp[i-1][j];
               else
               {
                   if(dp[i-1][j] || dp[i-1][j-arr[i-1]]){
                       dp[i][j] = true;
                   }
               }
           }
       }

        return dp[dp.length-1][dp[0].length-1];
    }

    static int counttargertSum1(int dp[][],int arr[]){

        dp[0][0] = 1;
        for (int i = 1; i < dp.length ; i++) {
            dp[i][0] = 1;
            for (int j = 0; j <dp[0].length ; j++) {
                if(j<arr[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                {

                    dp[i][j] = dp[i-1][j]+dp[i-1][j-arr[i-1]];


                    }
                }
            }
        return dp[dp.length-1][dp[0].length-1];
        }


    static int unboundKnapsack(int dp[][],int val[],int []w){

        for (int i = 1; i <dp.length ; i++) {

            for (int j = 1; j <dp[0].length ; j++) {
                if(j<w[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-w[i-1]]+val[i-1]);
                }
            }
        }

       return dp[dp.length-1][dp[0].length-1];
    }

    static int rodCutting(int dp[][],int val[]){

        for (int i = 1; i <dp.length ; i++) {

            for (int j = 1; j <dp[0].length ; j++) {
                if(j<i){
                    dp[i][j] = dp[i-1][j];
                }else
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-i]+val[i-1]);
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }


    static int countBinaryString(int num){

        int czero=1;
        int cone=1;

        for (int i = 2; i <=num ; i++) {

            int count = czero+cone;
            czero = cone;
            cone = count;
        }


        return czero+cone ;
    }


    static int countIncoding( String str){

        int dp [] = new int[str.length()];

        dp[0] =1;
        for (int i = 1; i < dp.length; i++) {
            if(str.charAt(i)=='0' && str.charAt(i-1)=='0'){   //0-0
                dp[i] = 0;
            }
            else if(str.charAt(i)!='0' && str.charAt(i-1)=='0'){//1-0

                dp[i] = dp[i-1];
            }
            else if(str.charAt(i)=='0' && str.charAt(i-1)!='0'){//0-1
                    if(str.charAt(i-1)=='1' || str.charAt(i-1)=='2')
                    dp[i] = i>=2?dp[i-2]:1;
                else
                    dp[i] = 0;
            }else{//1-1
                if(Integer.parseInt(str.substring(i-1,i+1))<=26)
                dp[i] = dp[i-1]+(i>=2?dp[i-2]:1);
                else
                    dp[i] = dp[i-1];
            }
        }

        return dp[dp.length-1];

    }

    static int maxAdjacentSum(int arr[]){

        int inc = arr[0];
        int exc = 0;
        for (int i = 1; i <arr.length ; i++) {

            int val = exc+arr[i];
            exc = Math.max(inc,exc);
            inc = val;


        }

        return Math.max(inc,exc);
    }
    static int paintHouseManyColor(int houses[][]){

        int fmin = Integer.MAX_VALUE;
        int smin =Integer.MAX_VALUE;;
        for (int j = 0; j < houses[0].length; j++) {
            if(fmin>=houses[0][j]){
                smin = fmin;
                fmin = houses[0][j];
            }

            else if(smin>=houses[0][j])
                smin = houses[0][j];
        }

        for (int i = 1; i < houses.length; i++) {
            int nfmin = Integer.MAX_VALUE ;
            int nSmin = Integer.MAX_VALUE ;
            for (int j = 0; j <houses[0].length ; j++) {

                if(houses[i-1][j]==fmin)
                    houses[i][j] = houses[i][j]+smin;
                else
                    houses[i][j] = houses[i][j]+fmin;

             if(nfmin>=houses[i][j]){
                    nSmin = nfmin;
                    nfmin = houses[i][j];
             }
             else if(nSmin>=houses[i][j])
                    nSmin = houses[i][j];

            }
            fmin = nfmin;
            smin = nSmin;
        }

        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < houses[0].length; j++) {
            minCost = Math.min(minCost,houses[houses.length-1][j]);
        }

        return minCost;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public static void main(String args[]) {
        List<List<Integer>> list = new ArrayList<>();
        int nums[] = {1,2,3};
        backtrack(list, new ArrayList<>(), nums);
      /* int houses[][] = {{1,5,7,2,1,4},
                         {5,8,4,3,6,1},
                         {3,2,9,7,2,3},
                         {1,2,4,9,1,7}};
    */

     //   System.out.println(   paintHouseManyColor(houses));
        //combination("aab","");

    }
}