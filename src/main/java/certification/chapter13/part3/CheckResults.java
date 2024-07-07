package certification.chapter13.part3;

public class CheckResults {
    private static long counter = 0;
    public static void main(String[] args) {
        final var mainThread = Thread.currentThread();
        new Thread(() -> {
            for (long i = 0; i < 2_000_000_000_0L; i++) {
                counter++;
            }
            mainThread.interrupt();
        }).start();

        while (counter < 2_000_000_000_0L){
            System.out.println("Not reached yet - "+ Thread.currentThread().getState());
            try {
                Thread.sleep(1_000); //TIME_WAITING
            } catch (InterruptedException e) {
                System.out.println("Interrupted !");
            }
        }
        System.out.println("Reached : " + counter);
    }
}