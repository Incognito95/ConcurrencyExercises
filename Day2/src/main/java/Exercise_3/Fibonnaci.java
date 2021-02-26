package Exercise_3;


class FibonnaciCalculator implements Runnable {
    private int fibonnaciResult;
    private int number;

    public FibonnaciCalculator(int number) {
        this.number = number;
    }

    private int fibonnaciRecursive(int n) {
        if (n < 2) return n;
        return fibonnaciRecursive(n - 1) + fibonnaciRecursive(n - 2);
    }

    @Override
    public void run() {
        fibonnaciResult = fibonnaciRecursive(this.number);
    }

    public int getFibonnaciResult() {
        return fibonnaciResult;
    }

    public static void main(String[] args) {

        FibonnaciCalculator fc1 = new FibonnaciCalculator(46);
        FibonnaciCalculator fc2 = new FibonnaciCalculator(46);
        FibonnaciCalculator fc3 = new FibonnaciCalculator(46);
        Thread t1 = new Thread(fc1);
        Thread t2 = new Thread(fc2);
        Thread t3 = new Thread(fc3);

        long start = System.nanoTime();
        t1.start(); //Runs sequential, NOT in a thread
        System.out.println(fc1.getFibonnaciResult());
        t2.start();
        System.out.println(fc2.getFibonnaciResult());
        t3.start();
        System.out.println(fc3.getFibonnaciResult());
        long end = System.nanoTime();

        System.out.println("Time Spent: " + (end - start) / 1_000_000);
    }
}

/*
Run:
1836311903
1836311903
1836311903
Time Spent: 25523
 */

/*
Start:
0
0
0
Time Spent: 1
 */