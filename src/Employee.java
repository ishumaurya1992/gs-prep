import java.util.ArrayList;
import java.util.Iterator;

class Grandparent {
    public void Print() {
        System.out.println("Grandparent's Print()");
    }
}

class Parent extends Grandparent {
    public void Print() {
        System.out.println("Parent's Print()");
    }
}

public class Employee extends Parent {
    public void Print() {

        System.out.println("Child's Print()");
    }

    public static void main(String[] args) {

        ArrayList<Integer> ls =new ArrayList<>();
        ls.add(5);
        ls.add(2);
        ls.add(1);
        ls.add(4);
        Iterator<Integer> itr = ls.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
            itr.remove();
        }
        ls.forEach(i-> System.out.println(i));
    }



}