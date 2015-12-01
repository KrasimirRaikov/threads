package synchronizedthreads;

/**
 * Created by clouway on 30.11.15.
 */
public class Counter extends Thread {

    private final Object counter;
    private int limit;

    public Counter(String name, int limit, Object counter) {
        super(name);
        this.limit = limit;
        this.counter = counter;
    }

    @Override
    public void run() {

        synchronized (counter) {

            for (int i = 1; i <= limit; i++) {

                counter.notify();
                System.out.println(getName() + " -" + i);

                try {
                    counter.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}