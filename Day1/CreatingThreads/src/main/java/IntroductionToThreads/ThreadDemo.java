package IntroductionToThreads;

class MyRunnable implements Runnable {
    @Override
    public void run() {

        // telling program "I don't have anything to do the next 500 milliseconds,
        // so can you remove me from the CPU, so it can be used for something more sensible and then put me somewhere to sit and wait,
        // then when theirs gone 1/2 second then get me running again.
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello from thread" + Thread.currentThread().getName() + " i = " + 1);
            try {
                // 500 ms = 1/2 seconds
                Thread.sleep(500); // put the thread to sleep in half a second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());

        t1.start(); // start thread 1 - when it gets through the run method then its dead
        t2.start(); // start thread 2 - when it gets through the run method then its dead

        // what the joins do is that they block so we need to wait til the joins are unblocked before it can continue running
        t1.join(); // when the threads are done we go here
        t2.join(); // when the threads are done we go here

        // when the joins are done running it then goes ahead and prints Are we done?
        System.out.println("Are we done?");
    }
}