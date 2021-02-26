package Exercise_1;

import org.junit.jupiter.api.Test;


class EvenTest {

    class t1 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                next();
                System.out.println(Thread.currentThread().getName() + " : " + get());
            }
        }
    }

    class t2 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                next();
                System.out.println(Thread.currentThread().getName() + " : " + get());
            }
        }
    }

    @Test
    void main() throws InterruptedException {
        Thread t1 = new Thread();
        t1.start();
        t1.join();

        Thread t2 = new Thread();
        t2.start();
        t2.join();

        System.out.println(t1.getName());
        System.out.println(t2.getName());
    }

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

}