import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class HistoGramAndTapping
{

    static void  histogram(int nums[])
    {
       int lb[] = new int[nums.length];
       int rb[] = new int[nums.length];



       //nge
        Stack<Integer> lge =new Stack<>();
        lge.push(0);
        lb[0] =-1;


        for (int i = 1; i <nums.length ; i++) {
            while(!lge.isEmpty() && nums[lge.peek()]<=nums[i]){
                lge.pop();
            }
            if(lge.isEmpty()){
               lb[i]  = -1;
            }else{
                lb[i] = lge.peek();
            }
            lge.push(i);

        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(i+"==>"+lb[i]+" ,");
        }
        System.out.println();
        Stack<Integer> rge =new Stack<>();
        rb[nums.length-1] = nums.length;
        rge.push(nums.length-1);
        for (int i = nums.length-2; i >=0  ; i--) {
            while(!rge.isEmpty() && nums[rge.peek()]<=nums[i]){
                rge.pop();
            }
            if(rge.isEmpty()){
                rb[i] = nums.length;
            }else
            {
                rb[i]  = rge.peek();
            }
            rge.push(i);
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(i+"==>"+rb[i]+" ,");
        }


        int sum=0;

        for (int i = 0; i < rb.length; i++) {
            int width = rb[i]-lb[i]-1;
            sum=Math.max(sum,(width*nums[i]));
        }


     }

//3,0,0,2,0
     static void tappingRain(int arr[]){

        int []lm = new int[arr.length];

         lm[0]  = arr[0];
         int preMax = arr[0];
         for (int i = 1; i < arr.length ; i++) {
             if(arr[i]>preMax){
                 lm[i] = arr[i];
                 preMax = arr[i];
             }else{
                 lm[i]  = preMax;
             }

         }


         int []rm = new int[arr.length];
         rm[arr.length-1] = arr[arr.length-1];
         int rmMax=arr[arr.length-1];;
//3,0,0,2,0
         for (int i = arr.length-2; i >=0 ; i--) {
             if(arr[i]>rmMax){
                 rm[i] = arr[i];
                 rmMax = arr[i];
             }else{
                 rm[i]  = rmMax;
             }
         }

         for (int i = 0; i <arr.length ; i++) {
             System.out.print(lm[i]+" ,");

         }
         System.out.println();
         for (int i = 0; i <arr.length ; i++) {
             System.out.print(rm[i]+" ,");

         }

         int sum=0;
         for (int i = 0; i <arr.length ; i++) {
             sum +=Math.min(rm[i],lm[i])-arr[i];
         }
         System.out.println(sum);



     }

  //  { 100, 180, 260, 310, 40, 535, 695 };
    static void sellAndBuyStock(int[] arr){

        int sd = 0;
        int bd = 0;

         for (int i = 1; i <arr.length ; i++) {

             if(arr[i]>=arr[i-1]){
                 sd++;
             }else{
                    int profit=0;
                     profit=arr[sd]-arr[bd];
                 System.out.println(bd+"==>"+sd+"==>"+profit);
               sd = bd = i;
             }

         }
         int profi = 0;
        profi=arr[sd]-arr[bd];
        System.out.println(bd+"==>"+sd+"==>"+profi);
     }


    public static void main(String[] args)
    {
        //int arr[] ={0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        List<int[]> ls  =new ArrayList<>();
        int target =0;
        //tappingRain(arr);
        int arr[]={ 12, 4, 7, 9, 2, 23, 25, 41,
                30, 40, 28, 42, 30, 44, 48,
                43, 50};
        Arrays.sort(arr);
       // sellAndBuyStock(arr);
int min=Integer.MAX_VALUE;
        for (int i = 0; i+6 <arr.length ; i++) {
          min = Math.min(min,arr[i+6]-arr[i]);
        }

        System.out.println(min);
    }
}


