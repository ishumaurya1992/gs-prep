// Java implementation of the above approach:

class BinaryNumber
{


    static void printTheArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    // Function to generate all binary strings
    static void generateAllBinaryStrings(int n,
                                         int arr[], int i)
    {
        if (i == n)
        {
            printTheArray(arr, n);
           return ;
        }


        arr[i] = 0;
        generateAllBinaryStrings(n, arr, i + 1);


        arr[i] = 1;
        generateAllBinaryStrings(n, arr, i + 1);
    }

    // Driver Code
    public static void main(String args[])
    {
        int n = 2;

        int[] arr = new int[n];

        //generateAllBinaryStrings(n, arr, 0);


        System.out.println(('9' - '0'));
    }
}

