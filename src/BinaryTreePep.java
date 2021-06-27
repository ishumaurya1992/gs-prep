import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreePep {



    public static void main(String args[]) {


        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};


        Node root = new Node(arr[0], null, null,null);
        Stack<Pair> st = new Stack<>();
        Pair rp = new Pair(root, 1);

        st.add(rp);
        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {

                idx++;

                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null,null);


                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                idx++;

                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null,null);


                    Pair p = new Pair(top.node.right, 1);
                    st.push(p);
                    top.state++;
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                st.pop();

            }

        }

      int []  preorder = {3,9,20,15,7};
        int []inorder = {9,3,15,20,7};
        int startIn = 0;
        int endIn = inorder.length-1;
         //constNode( preorder, inorder, startIn, endIn);
        System.out.println(height(root));
       // connect(root);;

    }

    static int preCount = 0;
   static Node constNode(int preorder[],int inorder[],int startIn,int endIn){
        System.out.println(startIn+"==>"+endIn);
        if(startIn>endIn)return null;


        Node newNode = new Node(preorder[preCount],null,null,null);
        preCount++;

        if(startIn==endIn)return newNode;

        int inIndex = searchIndex(inorder,startIn,endIn,newNode.data);


        newNode.left = constNode( preorder,inorder,startIn,inIndex-1);
        newNode.right = constNode(preorder,inorder, inIndex+1, endIn);



        return newNode;


    }

    static int searchIndex(int []inorder,int start,int end,int val){
         int i;
        for(  i=start;i<=end;i++){
            if(inorder[start]==val){
                // System.out.println(val);
                return i;
            }
        }
        return i;
    }

    static int height(Node node) {


        if (node == null) return -1;

        int hl = height(node.left);
        int hr = height(node.right);

        int h = 1 + Math.max(hl, hr);


        return h;

    }

    static int max(Node node) {

        if (node == null) return Integer.MIN_VALUE;

        int lmax = max(node.left);
        int rmax = max(node.right);


        int max = Math.max(node.data, Math.max(lmax, rmax));

        return max;
    }

    static int size(Node node) {
        int h = 0;
        if (node == null) return 0;
        int lh = size(node.left);
        int rh = size(node.right);


        h = lh + rh + 1;


        return h;
    }

    static void printLevelOrderHelper(Node node, int val) {
        if (node == null || val<0) return;

        if (val == 0) {
            System.out.println(node.data);
        }


            printLevelOrderHelper(node.left, val - 1);
            printLevelOrderHelper(node.right, val - 1);

    }

    static void printLevelOrder(Node node) {
        int h = height(node);

        printLevelOrderHelper(node,2);
       /* for (int i = 1; i <= h; i++) {
                printLevelOrderHelper(node, i);
        }*/
    }

    static void levelOrderZigZag(Node node) {

        Stack<Node> queue = new Stack<>();
        Stack<Node> cq = new Stack<>();
        queue.add(node);
        int level = 1;
        while (queue.size() > 0) {

            node = queue.pop();
            System.out.print(node.data + " ,");

            if (level % 2 != 0) {
                if (node.right != null) {
                    cq.add(node.right);
                }
                if (node.left != null) {
                    cq.add(node.left);
                }

            } else {


                if (node.left != null) {
                    cq.add(node.left);
                }
                if (node.right != null) {
                    cq.add(node.right);
                }
            }

            if (queue.size() == 0) {
                queue = cq;
                cq = new Stack<>();
                System.out.println();
                level++;
            }
        }

    }


    static void printLevelorderTraversal(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        ((ArrayDeque<Node>) queue).push(node);

        while (queue.size() > 0) {
            int count   = queue.size();
            for (int i = 0; i < count; i++) {
                node = queue.remove();
                System.out.print(node.data+" ,");

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);

                }
            }
            System.out.println();

        }


    }

    static ArrayList<Integer> nodetoRootPath(Node node,int key){

        if(node==null)return new ArrayList<>();
        if(node.data==key){
           ArrayList<Integer> ls= new ArrayList<>();
            ls.add(node.data);
            return ls;
        }

        ArrayList<Integer> ls = nodetoRootPath(node.left,key);
        if(ls.size()>0){
            ls.add(node.data);
            return ls;
        }
        ArrayList<Integer> rs = nodetoRootPath(node.right,key);
        if(rs.size()>0){
            rs.add(node.data);
            return rs;
        }

        return new ArrayList<>();
    }

    static boolean find(Node node,int key){

        if(node==null)return false;
        if(node.data==key){
            return true;
        }
        boolean fllag =  find(node.left,key);
        if(fllag){
            System.out.println(node.data);return true;}
       boolean rflag= find(node.right,key);
        if(rflag){System.out.println(node.data);return true;}

        return false;
    }

     static void connect(Node p)
    {
        // initialize queue to hold nodes at same level
        Queue<Node> q = new ArrayDeque<>();

        q.add(p); // adding nodes to tehe queue

        Node temp = null; // initializing prev to null
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node prev = temp;
                temp = q.poll();

                // i > 0 because when i is 0 prev points
                // the last node of previous level,
                // so we skip it
                if (i > 0)
                    prev.next = temp;

                if (temp.left != null)
                    q.add(temp.left);

                if (temp.right != null)
                    q.add(temp.right);
            }

            // pointing last node of the nth level to null
            temp.next = null;
        }
    }

    public static class Node {
        int data;
        Node left;
        Node right;
        Node next;

        Node(int data, Node left, Node right, Node next) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.next = next;
        }

    }




    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

}
