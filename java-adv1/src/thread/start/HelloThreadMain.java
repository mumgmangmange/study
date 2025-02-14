package thread.start;

public class HelloThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " is running. [start]");

        Thread thread = new HelloThread();

        System.out.println(Thread.currentThread().getName() + " is running. [sub-start]");
        thread.start(); // run method 실행 하라고 지시함 - 순서보장, 기다리지않음 X (병렬)
        System.out.println(Thread.currentThread().getName() + " is running. [sub-end]");

        System.out.println(Thread.currentThread().getName() + " is running. [end]");
    }
}
