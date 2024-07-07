package certification.chapter9;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Part7 {

    public static void main(String[] args) {

        Deque<Integer> deque0 = new ArrayDeque<>();
        Deque<Integer> deque = new LinkedList<>();

        deque.offerFirst(10);
        deque.offerLast(4);
        System.out.println(deque); //[10,4]
        System.out.println(deque.peekFirst()); //10
        System.out.println(deque); //[10,4]
        System.out.println(deque.pollFirst()); //10
        System.out.println(deque); //[4]
        System.out.println(deque.pollLast()); //4
        System.out.println(deque.pollFirst()); //null
        System.out.println(deque.peekFirst()); //null
    }
}
