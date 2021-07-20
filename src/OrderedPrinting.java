public class OrderedPrinting {
    int count = 1;

    public void printFirst() {
        synchronized (this) {
            System.out.println("First ");
            count++;
        }
    }

    public void printSecond() throws InterruptedException {
        synchronized (this) {
            while (count != 2) {
                wait();
            }
            count++;
            System.out.println("Second");
            notifyAll();
        }
    }

    public void printThird() throws InterruptedException {
        synchronized (this) {
            while (count != 3) {
                wait();
            }
            count++;
            System.out.println("Third");
            notifyAll();
        }
    }
}
