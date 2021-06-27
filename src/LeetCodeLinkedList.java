import java.util.*;

public class LeetCodeLinkedList {

    Node head;
     static class Node{
        int data;
        Node next;

       public  Node(int data){
            this.data = data;
            next=null;
        }
    }

      void push(int data)
       {
            Node node=new Node(data);
            node.next =head;
            head=node;
       }

       Node appendNode(int data,Node head) {



           if (head == null) {
               head=new Node(data);
               return head;
           }
           Node newNode = new Node(data);
           Node last=head;
        //   head = last;
           while(last.next!=null)
           {
               last =last.next;
           }

           newNode.next = null;

           last.next =newNode;

           return head;

       }

     int  detectloop(Node node)
     {
         Node firstPointer = head;
         Node secondPointer =head;

         while(secondPointer!=null&&secondPointer.next!=null)
         {
             firstPointer = firstPointer.next;
             secondPointer = secondPointer.next.next;

         }

         return firstPointer.data;
     }

     private  Node removeDuplicate(Node head)
     {
         Node node =head;
         while(node!=null)
         {
             Node n2=node;


                 while(n2!=null && node.data==n2.data)
                 {
                    n2= n2.next;
                 }
                 node.next = n2;

             node =node.next;
         }

         return head;

         }




     boolean  detectLoopNode(Node node)
     {
         Node firstPointer = head;
         Node secondPointer =head;

         while(secondPointer!=null&&secondPointer.next!=null)
         {
             firstPointer = firstPointer.next;
             secondPointer = secondPointer.next.next;

             if(secondPointer!=null &&firstPointer.data==secondPointer.data)
             {

                 return true;
             }


         }


         return false;
     }


    int arr[]=null;
    List<Integer> list =new ArrayList<>();
     void nextLargest(Node node ,Stack<Integer> st)
     {
         if(node==null){
             return;};

         nextLargest(node.next,st);



         if(!st.empty() && st.peek()>node.data){
             //arr[count--]=st.peek();
            list.add(st.peek());
             System.out.println(node.data+"-->"+st.peek());
             st.add(node.data);

         }
         else
         {
             while (!st.empty() && st.peek()<node.data)
                 st.pop();


             if(st.isEmpty()) {
              list.add(0);
                 System.out.println(node.data+"-->"+0);
                 st.add(node.data);
             }
             else {

                 list.add(st.peek());
                 st.add(node.data);
             }
          //   arr[count--]=0;

         }


     }

    void removeZeroSumSublists(Node head)
    {
        Stack<Integer> st =new Stack<>();
        Node node =head;
        int sum = node.data;
        st.add(node.data);
        node =node.next;
        while(node!=null)
        {
            sum += node.data;
            int conSum = st.peek()+node.data;

            if(sum==0 || conSum==0)
            {
                st.pop();
            }
            else
                st.add(node.data);


            node =node.next;
    }

        for (int i = 0; i <st.size() ; i++) {
            System.out.println(st.get(i));
        }

    }



    Node oddEvenLinkedList(Node head)
    {
         if(head==null)return head;
        Node odd = head;
        Node even = head.next;
        Node evenHead= even;

        while(even!=null && even.next!=null)
        {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

            return head;

    }


  Node  partationLinkedList(Node node,int target)
    {
        if (node ==null || node.next==null)return node;

        Node firstPart= new Node(0);
        Node firstHead = firstPart;
        Node secondPart=new Node(0);
        Node sencodHead = secondPart;
        Node curr = node;
        while(curr!=null)
        {
            Node temp = curr.next;
            curr.next = null;
            if(curr.data<target)
            {
                firstPart.next = curr;
                firstPart = firstPart.next;
            }
            else{
                secondPart.next = curr;
                secondPart = secondPart.next;
            }
            curr = temp;
        }
       firstPart.next = sencodHead.next;
        firstHead = firstHead.next;
        return firstHead;
    }


    Node swapAdjacentPair(Node head)
    {
       Node curr = head.next.next;
       Node prev = head;
       head  = head.next;
       head.next = prev;

    while (curr != null && curr.next != null)
    {
        prev.next = curr.next;
        prev = curr;
        Node next = curr.next.next;
        curr.next.next = curr;
        curr = next;
    }

    prev.next = curr;

    return head;
    }

 private  Node onlYDistinctNode(Node head)
     {
         Node dummy=new Node(0);

         Node ptr = dummy;

         Node curr = head;

         Node nextPounter = head.next;



         while(curr!=null)
         {
             nextPounter  = curr.next;
              boolean flag = false;
             while(nextPounter!=null && curr.data==nextPounter.data)
             {
                 nextPounter = nextPounter.next;
                 flag = true;
             }

             if (!flag)
             {
                 ptr.next = curr;
                 curr.next= null;
                  ptr = ptr.next;
             }



             curr = nextPounter;

         }



         return ptr.next;


         }

         Node reverseLinkedList(Node head)
         {
             if(head==null ||head.next==null)return head;

            Node n = reverseLinkedList(head.next);
            head.next.next = head;
            head.next = null;

            return n;
         }

         Node rotate(Node node){
         Node head = node;

             for (int i = 0; i <2 ; i++) {
                 while(node!=null && node.next.next!=null)
         {
            node =node.next;
         }
         Node temp = node.next;
         node.next=null;
         temp.next = head;
         node = temp;
         head =temp;
             }
         return head;
         }

       void foldHelper(Node node)
       {
           if(node==null) return;

           foldHelper(node.next);


           Node temp =left.next;

           left.next = node;

           node.next = temp;

           left = temp;







       }

       Node left;
       private Node fold(Node node){
          left = node;
          foldHelper(node);

          return left;

         }


         Node removeVal(Node node,int k){

           //Node curr = node;
           Node temp = new Node(-1);
           Node  p =temp;

           while(node!=null)
           {
               if(node.data==k)
               {
                   p.next = node;
                   p = p.next;
               }
               head= head.next;
           }
           p.next= null;

           return temp.next;

         }
    int c=0;
    int nextG(Node node)
    {
        Node temp = node;
         c=getCount(temp);


        return 0;
    }

    int currmax= 0;
       int arry[] =new int[c];
  void  getNextG(Node node){
           if(node==null){
               currmax=0;
                arry[c--]= node.data;
           }

             getNextG(node.next);
         if(node.next!=null&&node.data<node.next.data)
         {
             arry[c--]= node.data;
         }


    }

    int getCount(Node node)

    {
        int count = 0;
        while(node!=null){
            count++;
            node= node.next;
        }
        return count;
    }
//mid point
    static Node  getMiddle(Node node){

      if(node ==null )return node;
      Node slow = node;
      Node fast = node;
       while(fast.next!=null && fast.next.next!=null){

           slow = slow.next;
           fast = fast.next.next;

       }


      return slow;
    }


   static    Node mergeSort(Node node){

      if(node==null || node.next==null )return node;


      Node mid  = getMiddle(node);
      Node nextMid  = mid.next;
      mid.next=null;
      Node n1 = mergeSort(node);
      Node n2 = mergeSort(nextMid);
      Node sortedlist = mergeSortList(n1,n2);
      return sortedlist;
    }

   static Node mergeSortList(Node n1,Node n2){

      Node res  =null;
      if(n1==null)return n2;
      if(n2==null)return n1;
      if(n1.data<= n2.data)
      {
          res = n1;
          res.next = mergeSortList(n1.next,n2);
      }else{
          res = n2;
          res.next = mergeSortList(n1,n2.next);
      }


      return res;
    }

    static Node sortTwoList(Node n1,Node n2){

      if(n1==null)return n2;
      if(n2==null)return n1;

      if(n1.data<=n2.data){
          n1.next = sortTwoList(n1.next,n2);
          return n1;
      }
      else{
          n2.next = sortTwoList(n1,n2.next);
          return n2;
      }

    }


    static void testMe(Node head){
            Node pre = null;
            Node curr = head;

            while(curr!=null){
              Node  temp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = temp;
            }
            head = pre;
        System.out.println(head);

    }
       static Node Kreverse(Node head, int k){
           Node prehead = null;
           Node preTail = prehead;
           Node currHead = null;
           Node currTail = currHead;
           int count = 0;
           int size =0;
           Node temp = head;
           while(temp!=null){
               temp = temp.next;
               size++;
           }
           while(head!=null){

               if(count<k && size>=k){
                   Node newNode = new Node(head.data);
                   if(prehead==null){
                       prehead = newNode;
                       preTail = newNode;
                   }else{
                       newNode.next =prehead;
                       prehead = newNode;
                   }
                   count++;
                   size--;
                   head = head.next;
               }else if(size<k){
                   break;
               }else{
                   count =0;
                   if(currHead==null){
                       currHead = prehead;
                       currTail = preTail;
                   }else{
                       currTail.next = prehead;
                       currTail = preTail;
                   }

                   prehead=null;
                   preTail=prehead;
               }

           }
           if(currTail==null){
               currHead = prehead;
           }
           else if(count == k)
               currTail.next = prehead;
           else
               currTail.next=head;
           return currHead;
       }

    public static void main(String[] args) {
        LeetCodeLinkedList ll =new LeetCodeLinkedList();
        LeetCodeLinkedList ll1 =new LeetCodeLinkedList();
        int arr[] ={1,2,3,4,5};
       // int arr2[] = {2,4,7,8,10};
        //int arr[] ={1,2,3,4,5,6};
        Node n=ll.head;
        for (int a:arr) {
           n= ll.appendNode(a,n);
         }
       // Kreverse(n1,3);

        Node  fast = n;
        Node  slow = n;
            int i=0;
            int B =2;
        while(fast!=null && i<B){fast = fast.next;i++;}

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
}}
