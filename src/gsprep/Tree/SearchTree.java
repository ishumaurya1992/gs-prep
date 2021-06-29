package gsprep.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchTree {

    static class BST {

        private Node root;



        public BST() {
            this.root = null;
        }

        public void put(int value) {
           root =  addNode(this.root, value);

        }

        Node addNode(Node root,int value){
            if(root==null){
                return new Node(value);

            }

            if(root.val>value){

                root.left =  addNode(root.left , value);
            }else {
                root.right = addNode(root.right , value);
            }

            return root;
        }





        public boolean contains(int value) {

         return findElement(this.root, value);

        }

        boolean findElement(Node root,int value){
            if(root==null)
                return false;
            if(root.val>value){
                return findElement(root.left, value);
            }else if(root.val<value) {
                return findElement(root.right, value);
            }else{
                return true;
            }
        }




        public List<Integer> inOrderTraversal() {

            final ArrayList<Integer> acc = new ArrayList<>();

            inOrderTraversal(root, acc);

            return acc;

        }



        private void inOrderTraversal(Node node, List<Integer> acc) {

            if (node == null) {
                return;
            }

            inOrderTraversal(node.left, acc);
            acc.add(node.val);
            inOrderTraversal(node.right, acc);



        }



        private static class Node {
            Integer val;
            Node left;
            Node right;
            Node(int val){
                this.val = val;
                left = right = null;
            }

        }

    }



    public static void testBST() {

        final BST searchTree = new BST();

        searchTree.put(3);

        searchTree.put(1);

        searchTree.put(2);

        searchTree.put(5);

        assertFalse(searchTree.contains(0));

        assertTrue(searchTree.contains(1));

        assertTrue(searchTree.contains(5));

        assertFalse(searchTree.contains(6));

        assertEquals(Arrays.asList(1, 2, 3, 5), searchTree.inOrderTraversal());

    }



    private static void assertFalse(boolean rez) {

        if (rez) {

            throw new RuntimeException("Test failed");

        } else {

            System.out.println("Test passed");

        }

    }



    private static void assertTrue(boolean rez) {

        if (!rez) {

            throw new RuntimeException("Test failed");

        } else {

            System.out.println("Test passed");

        }

    }



    private static void assertEquals(List<Integer> expected, List<Integer> result) {

        if (!expected.equals(result)) {

            System.out.println(String.format("Test failed \"%s\" not equeals to \"%s\"", expected, result));

        } else {

            System.out.println("Test passed");

        }

    }



    // TODO: write some more tests

    public static void main(String[] args) {

        testBST();

    }

}
