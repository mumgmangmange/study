package thread.start;

public class DaemonThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main thread start");

        DaemonThread dt = new DaemonThread();
        dt.setDaemon(false); // false 은 사용자 스레드 true 은 데몬 스레드
        dt.start();

        System.out.println(Thread.currentThread().getName() + ": main thread end");
    }

    static class DaemonThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()  + ": run thread1");

            try {
                Thread.sleep(10000); // throws 안됨
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()  + ": run thread2");
        }
    }
}
