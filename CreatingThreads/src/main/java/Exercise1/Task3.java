package Exercise1;

public class Task3 {
    public static void main (String [] args) {

        for (int i = 10; i <= 20; i++) {
            sleep(3000); // Pause (sleep) 3 seconds
            System.out.println(i); // after 3 seconds it prints the numbers more than 10
            sleep(3000); // Pause (sleep) 2 seconds again
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
