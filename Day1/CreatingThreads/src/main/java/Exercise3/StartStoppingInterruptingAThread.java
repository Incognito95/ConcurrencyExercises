package Exercise3;

// a
class WorkerCancelable implements Runnable{
    boolean keepRunning = true;
    Thread thread;
    public void run() {
        thread = Thread.currentThread();
        while(keepRunning){
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void cancel() {
        keepRunning = false;
    }
}

public class StartStoppingInterruptingAThread {

    public static void main(String[] args) throws InterruptedException {
        WorkerCancelable worker = new WorkerCancelable();
        Thread t = new Thread(worker);
        t.start();
        System.out.println("DONE");
    }
}


// b / c
class NecessaryChanges implements Runnable {
    boolean keepRunning = true;
    Thread thread;
    public void run() {
        thread = Thread.currentThread();
        while(keepRunning){
            System.out.println("Hello (wait a second)");
            try {
                // d - interrupting a thread
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int counter = 0;
            counter++;
            if (counter == 1) { // amount of "Hello" that needs to be printed
                cancel();
            }
        }
    }
    public void cancel() {
        keepRunning = false;
    }
}

class NecessaryChangesH {

    public static void main(String[] args) throws InterruptedException {
        WorkerCancelable worker = new WorkerCancelable();
        Thread t = new Thread(worker);
        t.start();
        System.out.println("DONE");
    }
}
