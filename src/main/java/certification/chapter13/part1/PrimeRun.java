package certification.chapter13.part1;

public class PrimeRun implements Runnable{

    long minPrime;

    PrimeRun(long minPrime) {
        this.minPrime = minPrime;
    }

    @Override
    public void run() {
        System.out.println("Compute prime by Runnable - " + Thread.currentThread().getName());
    }
}