package Exercise1;

class Task1 implements Runnable {
    private long sum =0;
    @Override
    public void run() {
        for(int i = 0; i < 1_000_000_000; i++){
            sum += i;
        }
        System.out.println("Sum: " + sum);
    }
}

class Exercise1 {
    public static void main(String[] args) {
        //Task-1 : Should calculate and print the sum of all numbers from 1 to 1 billion (milliard)
        Thread t1 = new Thread(new Task1());
        t1.start();
    }
}
