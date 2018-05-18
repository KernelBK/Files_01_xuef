package books.concurrency_core.chap2.example14;
/**
 * 2.2.16 ������ĸı�
 * @author moveb
 */
public class Service {
    private String lock = "123";

    public void testMethod() {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " begin " + System.currentTimeMillis());
                lock = "456";
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " end " + System.currentTimeMillis());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
