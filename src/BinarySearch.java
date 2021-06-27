public class BinarySearch {

    int mergeSort(int arr[],int start,int end,int x)
    {
        if(start<=end)
        {
            int mid = (start+end)/2;
            if(arr[mid]==x) return x;

            if(arr[mid]>x)
                return mergeSort(arr,0,mid-1,x);
          return  mergeSort(arr,mid+1,end,x);
        }
        return -1;
    }

   int iterativeSolution(int arr[],int start,int end,int x)
    {
        while(start<end)
        {
            int mid = (start+end)/2;
            if(arr[mid]==x){return x;}

            if(arr[mid]>x){
                start=0;
                end =mid-1;
            }
            else {
                start =mid+1;
                end=end;
            }
        }

        return 0;
    }

    int binarySearch(int low, int high,int tar,int nums[]){
        while(low<=high){
            int mid = (low+high)/2;

            if(nums[mid]==tar){
                System.out.print(nums[mid]);
                return mid;
            }

             if(nums[mid]<tar)
                low = mid+1;
            else
                high=mid-1;

        }
        return -1;
    }
   public static void main(String args[])
   {
       BinarySearch bs= new BinarySearch();
       int arr[]={1,3,5};
       int val = bs.binarySearch( 0,  arr.length-1, 3,arr);
       System.out.print(val);
   }
}
