package Exercise1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;


public class Task1 {
    public static void main(String args[])  {

        // range of numbers from 0 to 1000
       // for (int i = 0; i < 1000; i++) {
        //    System.out.println(i);
       // }



        // calculate sum of all the numbers
       int num = 1000;
       int sum = 0;
        for (int i = 0; i <= num ; i++) {

            // sum = sum + i - adding 1 on top of sum
            sum += i;
        }

        System.out.println("Sum is: " + sum);

    }
}
