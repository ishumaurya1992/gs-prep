package gsprep.DataStructureImpl;
/*
Problem Statement:

Implement a double-ended queue (abbreviated to deque) that stores strings.
A deque is a data structure that has characteristics of both a queue and a stack.
Elements  can be added or removed from either the front or back.
Signature:
Create Class Deque
*/
public class MyDequeue {


   static class Node{
        int data;
        Node next,prev;

        Node getNode(int data){
            Node newNode  = new Node();
            newNode.data = data;
            next = prev = null;
            return newNode;
        }
    }

     static class Dequeue{
        Node front,rear;
        int size;
        Dequeue(){
        front = rear = null;
        size = 0;
        }
        boolean isEmpty(){return front==null;}
        int size(){return size;}

        void insertFront(int data){
            Node newNode = new Node().getNode(data);

            if(newNode==null) System.out.println("overflow");

            else{
                if(front==null){
                    rear = front = newNode;
                }else{
                    newNode.next = front;
                    front.prev = newNode;
                    front = newNode;
                }
            }

            size++;
        }

        void insertRear(int data){
            Node newNode  = new Node().getNode(data);
            if(newNode==null) System.out.println("overflow");
            else{
                if(rear==null)front = rear = newNode;
                else{
                    newNode.prev = rear;
                    rear.next = newNode;
                    rear = newNode;
                }
            }


            size++;
        }

        void deleteFront(){
            if(front==null){
                return;
            }
            else{
                Node temp = front;
                front = front.next;
                if(front==null){
                    rear = null;
                }else{
                    front.prev = null;
                }
                size--;
            }
        }

        void deleteRear(){
            if(isEmpty()){
                System.out.println("empty");


            }
            else{

                rear = rear.prev;
                if(rear == null)front=null;
                else{
                    rear.next = null;
                }
                size--;

            }
        }

        int getFront(){
            if(isEmpty())return -1;
            else return front.data;
        }
        int getRear(){
            if(isEmpty())return -1;
            else return rear.data;
        }

        void print(){
            while(front!=null){
                System.out.println(front.data);
                front = front.next;
            }
        }


    }


    public static void main(String[] args) {
        Dequeue dq= new Dequeue();
        dq.insertFront(10);
        dq.insertFront(20);
        dq.insertFront(30);
        dq.deleteFront();
        dq.insertRear(40);
        dq.print();

    }


}
