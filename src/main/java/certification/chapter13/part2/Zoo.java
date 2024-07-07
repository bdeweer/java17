package certification.chapter13.part2;

public class Zoo {

    public static void pause(){
        try {
            Thread.sleep(20_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread finished !");
    }

    public static void main(String[] args) {

        var job = new Thread(() -> pause(), "Zoo thread");
        job.setDaemon(false); //by default user defined thread are not deamon
        job.start();

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main method finished!");
    }
}
