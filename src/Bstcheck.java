import java.util.Stack;

public class Bstcheck {


    boolean canRepresentBST(int arr[],int n)

    {
        Stack<Integer> stack =new Stack<>();
        int root = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(arr[i]<root)
            {return false;}
            while(!stack.empty() && stack.peek() < arr[i]){
                root = stack.peek();
                stack.pop();
            }
            stack.push(arr[i]);
        }
return true;
    }


    public static void main(String args[]) {
        Bstcheck bst = new Bstcheck();
        int[] pre1 = new int[]{40, 30, 35, 80, 100};
        int n = pre1.length;
        if (bst.canRepresentBST(pre1, n) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        int[] pre2 = new int[]{40, 30, 35, 20, 80, 100};
        int n1 = pre2.length;
        if (bst.canRepresentBST(pre2, n) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}

