package Exercise2.volatile_demo;

class MutableIntegerV1{
    private int i = 0;

    public void increment() {
        int result = i;
        result++;
        i = result;
    }
    public int value() {
        return i;
    }
}
