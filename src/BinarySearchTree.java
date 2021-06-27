public class BinarySearchTree {
    Node node;
   BinarySearchTree ()
   {
       node=null;
   }
   static class Node{
       int data;
       Node left,right;
       Node(int data)
       {
        this.data=data;
        left=right=null;
       }
   }
   void insert(int data)
   {
      node = insertRecord(data, node);
   }

  Node insertRecord(int key,Node node)
    {
        if(node==null)
        {
          return new Node(key);
        }
        if(node.data>key)
            node.left = insertRecord(key,node.left);
        else if(node.data<key)
           node.right = insertRecord(key,node.right);

       return node;

    }
    void inorderRec(Node node ,int num)
    {
        if(node!=null)
        {
            if(num==0){System.out.print(node.data);}
            else if(num==1){System.out.print(node.data);}
            inorderRec(node.left,1);

            inorderRec(node.right,2);
        }
    }
    void preorder(Node node)
    {
        if(node!=null)
        {

            System.out.print(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }
    static boolean result=false;
    static boolean searchKey(int searchElement,Node node)
    {

        if(node==null)
            return false;
        if(node.data==searchElement)
                return true;

        if(node.data>searchElement)
            searchKey(searchElement,node.left);

        if(result)return true;

        if(node.data<searchElement)
            searchKey(searchElement,node.right);
        if(result)return true;

        return false;
    }

    int bstHeight(Node node)
    {
        if(node==null)return 0;
        int lheight  = bstHeight(node.left);
        int rheight = bstHeight(node.right);

        if(lheight>rheight)return lheight+1;
        else return rheight+1;

    }

    void forlevelorder(Node node,int level){
        for (int i=1;i<level;i++)
           printlevelOrder(node,i);
    }

    void printlevelOrder(Node node,int level)
    {
        int level3=level;
        if(node==null)return;
        if(level==1)
        {
            System.out.println(node.data+" ");
        }
        else if(level>1) {
            printlevelOrder(node.left, level - 1);
            printlevelOrder(node.right, level - 1);
            //System.out.println(node.left.data+node.right.data);

        }
    }

    int  minvalueOfBst(Node node)
    {
     Node current= node;

       while(current.left!=null)
       {
           current=current.left;

       }
       return current.data;
    }

    static  boolean getIsBst(Node node,int min,int max){

        if (node == null)
            return true;


        if (node.data < min || node.data > max)
            return false;


       boolean l=  getIsBst(node.left, min, node.data-1) ;
       boolean r=  getIsBst(node.right, node.data+1, max);

        return (l && r);


    }

  static int   levelOrderSum(Node node ){
        int sum = 0;
      if(node ==null)return 0;
      int a = levelOrderSum(node.left);
      int b = levelOrderSum(node.right);
      sum = a+b;


      int va= sum+ node.data;;
      System.out.println(va);
      return va;
    }

    static int i=0;
    static int preorder[]  = {8,5,1,7,10,12};
    static Node constructTree(int limit){

        if(i==preorder.length || preorder[i]> limit)return null;

        Node node = new Node(preorder[i++]);

        node.left = constructTree(  node.data);//left lower limit
        node.right = constructTree(  limit);//right upper previous value
        return node;


    }


    public static void main(String args[])
    {

        int value = 0;
        int totalEle = 3*3;
        int matrix[][] = new int[3][3];
        int rowLow = 0;
        int rowHigh = matrix.length-1;
        int colHigh = matrix[0].length-1;
        int collow= 0;
        while(value < totalEle){


            for(int i=collow;i<=colHigh && value < totalEle ;i++){

                matrix[rowLow][i]= ++value;


            }
            rowLow++;

            for(int i=rowLow;i<=rowHigh && value < totalEle;i++){

                matrix[i][colHigh]= ++value;

            }

            colHigh--;


            for(int i=colHigh;i>=collow && value < totalEle;i--){

                matrix[rowHigh][i]= ++value;


            }
            rowHigh--;

            for(int i=rowHigh;i>=rowLow && value < totalEle;i--){

                matrix[i][collow]= ++value;


            }
            collow++;


        }
    }

}
