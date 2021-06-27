import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class GenericTree {

    private static class Node{
        int data;
        ArrayList<Node> children  = new ArrayList<>();
    }

    private static int height(Node node)
    {
        int h=-1;
        for (Node n:node.children) {
              int ch =height(n);
              h = Math.max(h,ch);
        }
        h+=1;
        return h;
    }

    private static int treeSize(Node node)
    {
        int s=0;
        for (Node n:node.children) {
              int cs =treeSize(n);
              s=s+cs;
        }
        s=s+1;
        return s;
    }

    private static int maxmValue(Node node)
    {
        int max = Integer.MIN_VALUE;

        for(Node n: node.children) {
            int value = maxmValue(n);
            max = Math.max(value,max);
        }

        max = Math.max(node.data,max);
        return max;
    }

   private static void  display(Node node)
   {
       String str = node.data+" ->";
       for (Node child: node.children) {
           str+=child.data+" ,";
           display(child);
       }
       str+=".";
       System.out.println(str);
   }

   private static void levelOrderTraversal(Node node) {
       Queue<Node> st = new ArrayDeque<>();

       st.add(node);
       while (st.size() > 0) {
           node = ((ArrayDeque<Node>) st).removeFirst();

           for (Node n : node.children) {
               ((ArrayDeque<Node>) st).addLast(n);
           }
           System.out.print(node.data + " ");
       }
   }

   private static void traversal(Node node){

       System.out.println("Pre-->" +node.data);
       for(Node n:node.children)
       {
           traversal(n);

       }
        System.out.println("Post-->"+node.data);
    }



   private static int findElemnt(Node node,int value) {
        int i=0;
        if(node.data==value){i=1;return     i;}
       for (Node n : node.children) {
            findElemnt(n, value);
            if (i==1)return i;
           }

    return i;

   }

   private static ArrayList<Integer> getNodeRootpath(Node node,int data)
   {
       if(node.data==data)
       {
           ArrayList<Integer> list =new ArrayList<>();
           list.add(node.data);
           return list;
       }

       for (Node child :node.children) {
           ArrayList<Integer> pct  =getNodeRootpath(child,data);
           if(pct.size()>0)
           {
               pct.add(node.data);
               return pct;
           }
       }

      return new ArrayList<>();
   }



   private static int getLowestCommonAncestor(Node node,int data1,int data2)
   {
       ArrayList<Integer> l1=getNodeRootpath(node,data1);
       ArrayList<Integer> l2=getNodeRootpath(node,data2);

       int i=0,j=0,comm=0;
       for(i=l1.size()-1,j=l2.size()-1;i>0 && j>0 && l1.get(i)==l2.get(j);i--,j--)
       {
         comm++;
       }

       System.out.println((l1.size()-comm+l2.size()-comm)+1);

       return l1.get(i+1);
   }

    public static void main(String args[])
    {
        int arr[]={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1 ,90,-1,-1,40,100,-1,-1,-1};
        Stack<Node> stack =new Stack<>();
        Node root= null;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]==-1)
                stack.pop();
            else {
               Node node = new Node();
               node.data =arr[i];
               if (!stack.isEmpty()) {
                   stack.peek().children.add(node);
               }
               else
                   root = node;

               stack.push(node);

            }
        }
        //levelOrderTraversal(root);
       // findElemnt(root,99);
        traversal(root);
    }
}
