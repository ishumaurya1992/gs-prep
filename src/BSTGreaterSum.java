public class BSTGreaterSum {
    Node node;

    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data = data;
            left=right=null;
        }
    }
    int sum=0;
    int   nodesum(Node node)
    {
        if(node!=null) {
            sum = sum + node.data;
            nodesum(node.left);
            System.out.print(node.data+" ");
            nodesum(node.right);
        }
        return sum;
    }
    void reconstructTogreaterSum(Node node)
    {
        if(node!=null) {


            reconstructTogreaterSum(node.left);
            sum = sum-node.data;
            node.data=sum;
            System.out.print(node.data+" ");
            reconstructTogreaterSum(node.right);
        }

    }


    void recursion(Node node,int sum)
    {
        if(node ==null)return;

        recursion(node.right,sum);
        sum = sum+node.data;
        node.data = sum-node.data;
        recursion(node.left,sum);

    }


    public static void main(String args[])
    {
        BSTGreaterSum bstGreaterSum =new BSTGreaterSum();
        bstGreaterSum.node=new Node(11);
        bstGreaterSum.node.left=new Node(2);
        bstGreaterSum.node.right=new Node(29);
        bstGreaterSum.node.left.left=new Node(1);
        bstGreaterSum.node.left.right=new Node(7);
        bstGreaterSum.node.right.left=new Node(15);
        bstGreaterSum.node.right.right=new Node(40);
        bstGreaterSum.node.right.right.left=new Node(35);
        //System.out.println(bstGreaterSum.nodesum(bstGreaterSum.node));
      //  bstGreaterSum.reconstructTogreaterSum(bstGreaterSum.node);
        bstGreaterSum.recursion(bstGreaterSum.node,0);
    }
}
