package Exercise_4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
Remember, main runs in its own thread, so we have two threads in this example
 */
public class Producer  {

    static int lastID = 0;
    public static void produce( BlockingQueue<String> queue) throws InterruptedException {
        String itemProduced = "Hello"+ lastID++;
        queue.put(itemProduced);
        System.out.println("Produced: "+ itemProduced+ " -- QueueSize: "+queue.size());
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        Thread t = new Thread(new Consumer(queue));
        t.start();

        produce(queue);
        produce(queue);
        produce(queue);
        produce(queue);
        produce(queue);
        produce(queue);
        produce(queue);
        produce(queue);
//        produce(queue);
//        produce(queue);
//        produce(queue);



        t.join(10000);
        t.interrupt();
        t.join();
        System.out.println("All items Produced and Consumed");

    }

}


// Hvad jeg observerede i koden var anderledes til hvad jeg troede ville være executed i terminalen,
// Jeg troede at den først skulle vente 10 sekunder til den executer også ville den interrupt med beskeden "All items Produced and Consumed" efterfulgt med BlockingQueus,
// men det den gjorde istedet for, printede den det her:
/*
Produced: Hello0 -- QueueSize: 1
Produced: Hello1 -- QueueSize: 2
Produced: Hello2 -- QueueSize: 3
Produced: Hello3 -- QueueSize: 4
Produced: Hello4 -- QueueSize: 5
Consumed: Hello0
Produced: Hello5 -- QueueSize: 5
Consumed: Hello1
Produced: Hello6 -- QueueSize: 5
Consumed: Hello2
Produced: Hello7 -- QueueSize: 5
Consumed: Hello3
Consumed: Hello4
Consumed: Hello5
Consumed: Hello6
Consumed: Hello7
All items Produced and Consumed
*/