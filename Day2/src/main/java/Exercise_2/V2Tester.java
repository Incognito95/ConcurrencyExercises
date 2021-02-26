package Exercise_2;

class SharedDataUpdater implements Runnable{
    private int MAX_count = 10_000;
    private Uge1.ConcurrencyExercisesDay2.Exercies2.MutableIntegerV1 sharedCounter;

    public SharedDataUpdater(Uge1.ConcurrencyExercisesDay2.Exercies2.MutableIntegerV1 sharedCounter){
        this.sharedCounter = sharedCounter;
    }
    @Override
    public void run() {
        for (int i = 1; i <= MAX_count; i++) {
            this.sharedCounter.increment();
        }
    }
}

public class V2Tester {

    public static void main(String[] args) throws InterruptedException {
        Uge1.ConcurrencyExercisesDay2.Exercies2.MutableIntegerV1 sharedCounter = new Uge1.ConcurrencyExercisesDay2.Exercies2.MutableIntegerV1();
        Thread t1 = new Thread(new SharedDataUpdater(sharedCounter));
        Thread t2 = new Thread(new SharedDataUpdater(sharedCounter));
        Thread t3 = new Thread(new SharedDataUpdater(sharedCounter));
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Total fra alle tråde: "+sharedCounter.value());
    }
}
