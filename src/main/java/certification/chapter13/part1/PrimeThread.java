package certification.chapter13.part1;

public class PrimeThread extends Thread{

    long minPrime;
    PrimeThread(long minPrime, String name) {
        setName(name);
        this.minPrime = minPrime;
    }

    public void run(){
        System.out.println("Compute prime by Thread - " + Thread.currentThread().getName());
    }
}