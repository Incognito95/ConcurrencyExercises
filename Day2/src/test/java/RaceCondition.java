import org.junit.jupiter.api.Test;

public class RaceCondition implements Runnable {
    private int n = 0;

    @Test
    public int next() {
        synchronized (this) {
            n++;
            n++;
            return n;
        }
    }


    public long get() {
        synchronized (this) {
            return this.n;
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            next();
            System.out.println(Thread.currentThread().getName() + "" + get());
        }

        // next();
        System.out.println(Thread.currentThread().getName() + " DONE -->" + get());
    }


}