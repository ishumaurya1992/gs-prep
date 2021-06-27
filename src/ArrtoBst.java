

public class ArrtoBst
{
   static Node node;

 class Node{
     int data;
     Node left,right;

     Node (int data){
         this.data = data;
         left=right=null;

     }

 }


 Node  bstrec(int arr[],int start,int end)
 {
     if(start>end)
     {return null;}
     int index  = (start+end)/2;
     Node node =new Node(arr[index]);

     node.left =bstrec(arr,start,index-1);
     node.right  =bstrec(arr,index+1,end);
    return node;
 }
    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void main(String args[])
 {
     ArrtoBst creatarrtobst =new ArrtoBst();
     int []sortearray = {1,2,3,4,5,6,7,8,9};
     node = creatarrtobst.bstrec(sortearray,0,sortearray.length-1);
     creatarrtobst.preOrder(node);
 }

}
