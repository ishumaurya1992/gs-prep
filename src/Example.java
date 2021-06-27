import java.util.Arrays;

public class Example {
    static int  count = 0;


    int search(int in[], int num) {
        int i = 0;
        for (; i < in.length; i++)
            if (in[i] == num)
                break;

        return i;
    }

    static int a = 0;

    public static int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }

        return a;
    }

    private static void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            a++;
            left--;
            right++;
        }
    }

    public void treeConversion(int in[], int pre[], int low, int high) {

        if (high < low) return;

        int pre_value = pre[count++];
        int in_index = search(in, pre_value);


        treeConversion(in, pre, low, in_index - 1);
        treeConversion(in, pre, in_index + 1, high);
        System.out.print(in[in_index]);


    }

    static long merge(long low, long high) {
        if (low == high) {
            return low;
        }
        long mid = (low + high) / 2;
        long a = merge(low, mid);
        long b = merge(mid + 1, high);
        return a * b;

    }

    static int multiply(int x, int res[], int res_size) {
        int carry = 0;


        for (int i = 0; i < res_size; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10;

            carry = prod / 10;
        }


        while (carry != 0) {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }

  static   int mergeSort(int A[],int low ,int high){

        if(low<high) {;

            int mid  = (low+high)/2;

            count+=  mergeSort( A, low , mid);
            count+=  mergeSort( A, mid+1 , high);

            count+=  inversionArray(A,low,high,mid);
        }

        return count;
    }


   static int  inversionArray(int A[],int low,int high,int mid){


        int n1  = mid-low+1;
        int n2  = high-mid;
        int arr1[] = new int [n1];
        int arr2[] = new int [n2];

        for(int i=0;i<n1;i++){
            arr1[i] = A[low+i];
        }

        for(int i=0;i<n2;i++){
            arr2[i] = A[mid+1+i];
        }

        int i=0, j = 0,  k = low,count = 0;

        while(i<n1 && j<n2){

            if(arr1[i]<=arr2[j]){
                A[k++] = arr1[i++];
            }else{
                A[k++] = arr2[j++];
                count+= (mid+1)-(i+low);

            }

        }

        while(i<n1){
            A[k++] = arr1[i++];
        }
        while(j<n2){
            A[k++] = arr2[j++];
        }

        return count;
    }


    public static void main(String args[]) {

       int A[][]={ {7, 10},
        {4, 19},
        {19, 26},
        {14, 16},
        {13, 18},
        {16, 21}};
        int [] start = new int [A.length];
        int [] end = new int [A.length];
        for(int i=0;i<start.length;i++){
            start[i] = A[i][0];

        }
        for(int i=0;i<start.length;i++){
            end[i] = A[i][1];

        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0;
        int j = 0;
        int count = 0;
        int maxMeeting  = 0;
        while(i<start.length && j<end.length){

            if(start[i]<end[j]){
                i++;
                count++;
            }else{
                j++;
                count--;
            }
            maxMeeting  = Math.max(maxMeeting,count);

        }
        System.out.println(maxMeeting);

    }
}


