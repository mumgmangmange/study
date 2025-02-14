package thread.start;

public class BadThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " is running. [start]");

        Thread thread = new HelloThread();

        System.out.println(Thread.currentThread().getName() + " is running. [sub-start]");
        thread.run(); // run() 직접 실행 - 순서 보장
        System.out.println(Thread.currentThread().getName() + " is running. [sub-end]");

        System.out.println(Thread.currentThread().getName() + " is running. [end]");
    }
}
