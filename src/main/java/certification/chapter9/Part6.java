package certification.chapter9;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Part6 {

    public static void main(String[] args) {

        Deque<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        Deque<Integer> queue3 = new ArrayDeque<>();

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(4);
        queue.offer(54);
        System.out.println(queue); //[10, 4, 54]
        System.out.println(queue.remove()); //10
        System.out.println(queue); //[4, 54]

        System.out.println(queue.element()); //4
        System.out.println(queue.peek()); //4

        System.out.println(queue); //[4, 54]


        System.out.println(queue.poll()); //4
        System.out.println(queue); //54

        System.out.println(queue.remove()); //54
        System.out.println(queue); //[]

        System.out.println(queue.poll()); //null
        //System.out.println(queue.remove()); //NoSuchElementException
    }
}