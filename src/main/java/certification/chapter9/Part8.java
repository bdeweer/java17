package certification.chapter9;

import java.util.ArrayDeque;
import java.util.Deque;

public class Part8 {

    public static void main(String[] args) {

        //1Z0-829 OCP Java 17 possible error on Stack example

        //Stack (LIFO)
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(10);
        stack.push(4);
        System.out.println(stack); // [4, 10]
        System.out.println(stack.peek()); //4 - Get the first element
        System.out.println(stack); // [4, 10]
        System.out.println(stack.poll()); //4 : Returning null + removing operations: poll()
        System.out.println(stack); // [10]
        stack.push(20);
        stack.push(40);
        System.out.println(stack); //[40, 20, 10]
        System.out.println(stack.pop()); //10 : Throwing exception + removing operations: pop()  // LIFO
        System.out.println(stack); //[]
        System.out.println(stack.peek()); //null

        //System.out.println(stack.pop()); //NoSuchElementException
    }
}
