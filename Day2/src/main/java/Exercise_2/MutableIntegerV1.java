package Uge1.ConcurrencyExercisesDay2.Exercies2;

public class MutableIntegerV1{
    private volatile int i = 0;

    public synchronized void increment() {
        int result = i;
        result++;
        i = result;

     //   i = i+1;
    }
    public int value() {
        return i;
    }
}
