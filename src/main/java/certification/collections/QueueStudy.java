package certification.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class QueueStudy {

    public static void main(String[] args) {


        LinkedList<String> linkedList = new LinkedList<>(); //Enjoy both List and Deque interface
        linkedList.addFirst("Java");
        System.out.println(linkedList.indexOf("Java"));

        Deque<String> deque = new LinkedList<>(); //If you don't need List specific methods (get, set, indexOf, ...)
        deque.addFirst("Java");

        Deque<String> deque2 = new ArrayDeque<>();
        deque2.addFirst("Java");

        //Use as a stack (LIFO)
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("A"); //head is pointing to A
        stack.push("B"); //head is pointing to B
        stack.push("C"); //head is pointing to C
        System.out.println(stack);
        System.out.println(stack.pop()); //head is pointing to B and returns the removed element (C)
        System.out.println(stack);

        System.out.println("\n");
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer("A"); //tail is pointing to A
        queue.offer("B"); //tail is pointing to B
        queue.offer("C"); //tail is pointing to C
        System.out.println(queue);
        System.out.println(queue.pop()); //head is pointing to B and returns the removed element (A)
        System.out.println(queue);
    }
}
