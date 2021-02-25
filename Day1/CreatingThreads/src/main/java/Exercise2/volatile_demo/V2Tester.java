package Exercise2.volatile_demo;

class SharedDataUpdater implements Runnable {
    private int MAX_COUNT = 10_000;
    private MutableIntegerV1 sharedCounter;

    public SharedDataUpdater(MutableIntegerV1 sharedCounter) {
        this.sharedCounter = sharedCounter;
    }

    @Override
    public void run() {
        for(int i = 1; i <= MAX_COUNT ;i++){
            this.sharedCounter.increment();
        }

    }
}

public class V2Tester {

    public static void main(String[] args) throws InterruptedException {
        MutableIntegerV1 sharedCounter = new MutableIntegerV1(); //REMEMBER ONLY ONE
        Thread t1 = new Thread(new SharedDataUpdater(sharedCounter));
        Thread t2 = new Thread(new SharedDataUpdater(sharedCounter));
        Thread t3 = new Thread(new SharedDataUpdater(sharedCounter));
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t2.join();

        System.out.println("Total fra alle tråde: "+sharedCounter.value());
    }
}
