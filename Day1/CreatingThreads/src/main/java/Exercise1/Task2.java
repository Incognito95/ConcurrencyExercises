package Exercise1;

public class Task2 {
    public static void main (String [] args) {

        for (int i = 0; i < 5; i++) {
            sleep(2000); // Pause (sleep) 2 seconds
            System.out.println(i); // after 2 seconds it prints the numbers 1 - 5
            sleep(2000); // Pause (sleep) 2 seconds again
        }

    }




    public static void sleep (int time) {
        try {
            Thread.sleep(time); // pauses program in milliseconds
        } catch (Exception e) {
            System.out.println("Something went wrong...");
            System.out.println(e);
        }
    }


}