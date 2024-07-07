package certification.collections;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LinkedListStudy {

    public static void main(String[] args) {

        List<String> namesArrayList = new ArrayList<>();
        namesArrayList.add("John");
        namesArrayList.add("Paul");
        namesArrayList.add("George");
        namesArrayList.add("Ringo");
        System.out.println(namesArrayList);
        namesArrayList.add(1, "Toto"); //Very slow

        LinkedList<String> namesLinkedList = new LinkedList<>(); //implements both List and Deque
        namesLinkedList.add("John");
        namesLinkedList.add("Paul");
        namesLinkedList.add("George");
        namesLinkedList.add("Ringo");
        System.out.println(namesLinkedList);
        namesLinkedList.add(1, "Toto"); //Very fast

        namesLinkedList.addFirst("Kurt"); //method from Deque
        namesLinkedList.addLast("Bryan"); //method from Deque

        System.out.println(namesLinkedList);

    }
}
