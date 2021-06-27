

class Solution111 {
  static   int getBitonic(int []arr,int tar){
        int low  = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = (low+high)/2;

            if(mid-1>=0 && mid+1<arr.length && arr[mid-1]<arr[mid] && arr[mid+1]<arr[mid]){
                return mid;
            }

            if(mid+1<arr.length && arr[mid]<arr[mid+1]){
                low  = mid+1;
            }else {
                high = mid-1;
            }



        }
      return -1;
    }
       static int searchAsc(int arr[],int i,int j,int tar){
            int low = i;
            int high =j;
            while(low<=high){
                int mid = (low+high)/2;

                if(arr[mid]==tar){
                    return mid;
                }else if(arr[mid]>tar){
                    high = mid-1;
                }else{
                    low = mid+1;
                }


            }
            return -1;
        }
  static   int searchDesc(int arr[],int low,int high ,int tar){
//20, 19, 18, 17, 16, 15, 14, 13, 12, 11
        int left  = low;
        int right  = high;

        while(left<=right){
            int mid  = (left+right)/2;

            if(arr[mid] == tar )return mid;

            else if(arr[mid] < tar ){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;

    }
    public static void main(String[] args) {

      String s = new String("abc");
      StringBuffer sb =new StringBuffer("abc");
        System.out.println(s.equals(sb));

        int arr[] = {1, 2, 3, 4, 5, 10, 9, 8, 7, 6 };
        int B = 5;
        int bitonic = getBitonic(arr,B);
        int search = -1;
        if(bitonic!=-1){
            if(arr[bitonic]==B){
                System.out.println(bitonic);
            };
            if(B>=arr[0] && B<=arr[bitonic-1]){
                search = searchAsc(arr,0,bitonic-1,B);
            }else{
                search = searchDesc(arr,bitonic+1,arr.length-1,B);
            }

        }else{
            search = searchAsc(arr,0,arr.length-1,B);
        }

        System.out.println(search);
    }
}