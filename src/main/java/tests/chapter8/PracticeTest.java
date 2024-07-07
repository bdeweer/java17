package tests.chapter8;

import com.sun.nio.file.ExtendedWatchEventModifier;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class PracticeTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException{

        //2
        Callable c = new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.print("X");
                return 10;
            }
        };

        var s = Executors.newScheduledThreadPool(1);
        for (int i = 0; i < 10; i++) {
            Future f = s.submit(c);
            f.get();
        }
        s.shutdown();
        System.out.print("Done!");
        System.out.println();

        //32
        var db = Collections.synchronizedList(new ArrayList<>());
        IntStream.range(1,6)
                .parallel()
                .map(i -> {
                    db.add(i);
                    return i;
                }).forEachOrdered(System.out::print);

        System.out.println();
        db.forEach(System.out::print);

        //34
        var original = new ArrayList<Integer>(List.of(1,2,3));

        /*var copy1 = new ArrayList<Integer>(original);
        for(Integer q : copy1)
            copy1.add(1);*/

        var copy2 = new CopyOnWriteArrayList<Integer>(original);
        for(Integer q : copy2)
            copy2.add(2);

        /*var copy3 = new LinkedBlockingQueue<Integer>(original);
        for(Integer q : copy3)
            copy3.offer(2);*/

      //  var copy4 = Collections.synchronizedList(original);
       // for(Integer q : copy4)
       //     copy4.add(4);


        System.out.println("0000");
        var drink = List.of("coke", "soda", "pop");
        System.out.println(drink.parallelStream().parallel().reduce(0, (c1, c2) -> c1 + c2.length(), (s1, s2) -> s1 + s2));

        System.out.println("A");
        System.out.println(drink.stream().reduce(0, (c1, c2) -> c1 + c2.length(), (s1, s2) -> s1 + s2));
        System.out.println("B");
    }

}

//1
class Speaking {
    void talk(){
        try {
            Thread.sleep(10_000);
        }catch(InterruptedException e){
            System.out.println("How rude");
        }
    }

    public static void main(String[] args) {
        var s = new Speaking();
        var t = new Thread(() -> s.talk());
        t.run(); //blocking call, single thread, code is ran with the main Thread
        System.out.println("10 s later, end of run");
        t.interrupt();
        t.interrupt();
        t.interrupt();
    }
}

class Luck {

    private AtomicBoolean coin = new AtomicBoolean(false);
    void flip(){
        coin.getAndSet(!coin.get());
    }

    public static void main(String[] args) throws Exception{
        var luck = new Luck();
        var s = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            s.execute(() -> luck.flip());
        }
        s.shutdown();
        Thread.sleep(5000);
        System.out.println(luck.coin.get());

    }
}

//6
class Dance {
    int count = 0;
    synchronized int step(){
        return count++;
    }

    public static void main(String[] args) throws InterruptedException{
        var waltz = new Dance();
        var dancers = new ArrayList<Thread>();

        for (int i = 0; i < 10; i++) {
            dancers.add(new Thread(() -> waltz.step()));
        }
        for(Thread dancer : dancers){
            dancer.start();
        }
        dancers.forEach(d -> d.interrupt());

        Thread.sleep(5_000);
        System.out.println(waltz.count);
    }
}

//7
class Padlock{
    private Lock lock = new ReentrantLock();
    public void lockUp(){
        if(lock.tryLock()){
            lock.lock();
            System.out.println("Locked");
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception{
        var gate = new Padlock();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> gate.lockUp()).start();
            Thread.sleep(1_000);
        }
    }
}

//14
class CartoonCat {
    private void await(CyclicBarrier cb){
        try {
            cb.await();
        }catch (Exception e){}
    }
    public void march(CyclicBarrier cb){
        //var s = Executors.newSingleThreadExecutor();
        var s = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 12; i++) {
            s.execute(() -> await(cb));
        }
        s.shutdown();
    }

    public static void main(String[] args) {
        new
                CartoonCat()
                .march(
                        new CyclicBarrier(
                                4,
                                () -> System.out.println("Ready")
                        )
                )
        ;
    }
}

//18
class Race {
    ExecutorService service = Executors.newFixedThreadPool(8);
    public static int sleep(){
        try {
            Thread.sleep(1000);
        }catch(Exception e){}
        return 1;
    }
    public void hare(){
        try {
            Callable<Integer> c = () -> sleep();
            final var r = List.of(c,c,c);
            var results = service.invokeAll(r); //one s to complete
            System.out.println("Hare won the race");
        }catch (Exception e){e.printStackTrace();}
    }

    public void turtoise(){
        try {
            Callable<Integer> c = () -> sleep();
            final var r = List.of(c,c,c);
            Integer results = service.invokeAny(r); //one s to complete
            System.out.println("Turtoise won the race");
        }catch (Exception e){e.printStackTrace();}
    }

    public static void main(String[] args) {
        var race = new Race();
        race.service.execute(() -> race.hare());
        race.service.execute(() -> race.turtoise());
    }
}

//21
class Clock {
    private AtomicLong bigHand = new AtomicLong(0);
    void incrementBy10(){
        bigHand.getAndSet(bigHand.get() + 10);
    }

    public static void main(String[] args) throws Exception{
        var smartWatch = new Clock();
        ExecutorService s = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            s.submit(() -> smartWatch.incrementBy10()).get();
        }
        s.shutdown();
        s.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(smartWatch.bigHand.get());
    }
}


//24
class Athlete {
    int stroke = 0;
    public synchronized void swimming(){
        stroke++;
    }
    private int getStroke(){
        synchronized (this){return stroke;}
    }

    public static void main(String[] args) {
        ExecutorService s = Executors.newFixedThreadPool(10);
        Athlete a = new Athlete();
        for (int i = 0; i <1000 ; i++) {
            s.execute(() -> a.swimming());
        }
        s.shutdown();
        System.out.println(a.getStroke());
    }
}

//26
class ThreadSafeList {
    private List<Integer> data = new ArrayList<>();
    public synchronized void addValue(int value){
        data.add(value);
    }
    public int getValue(int index){
        return data.get(index);
    }
    public int size(){
        synchronized (ThreadSafeList.class){
            return data.size();
        }
    }
}

//28
class Bounce {
    public static void main(String[] args) {
        List.of(1,2,3,4).stream().forEach(System.out::println);
        //List.of(1,2,3,4).parallel().forEach(System.out::println);
        //List.of(1,2,3,4).parallel().forEachOrdered(System.out::println);
    }
}

//30
class Boat {
    private void waitTillFinished(CyclicBarrier c){
        try {
            c.await();
            System.out.print("W");
        }catch(Exception e){

        }
    }

    public void row(ExecutorService s){
        var cb = new CyclicBarrier(5);
        IntStream
                .iterate(1, i->i+1)
                .limit(12)
                .forEach(i -> s.submit(() -> waitTillFinished(cb)));
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newCachedThreadPool();
            new Boat().row(service);
        }finally {
            service.isShutdown();
        }
    }
}

class SearchList<T> {
    private List<T> data;
    private boolean foundMatch = false;
    public SearchList(List<T> list){
        this.data = list;
    }
    public void exists(T v, int start, int end){
        System.out.println("la");
        if(end-start==0){}
        else if(end-start==1){
            System.out.println("ici");
            foundMatch = false || v.equals(data.get(start));
        }
        else {
            final int middle = start + (end-start)/2;
            new Thread(() -> exists(v, start, middle)).run();
            new Thread(() -> exists(v, middle, end)).run();;
        }
    }

    public static void main(String[] args) {
        List<Integer> data = List.of(1,2,3,4,5,6);
        SearchList<Integer> t = new SearchList<>(data);
        System.out.println("avant");
        t.exists(5, 0, data.size());
        System.out.println("apres");
        System.out.println(t.foundMatch);
    }

}