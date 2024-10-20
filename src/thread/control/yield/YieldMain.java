package thread.control.yield;

import static thread.util.ThreadUtils.sleep;

public class YieldMain {
    static final int THREAD_COUNT = 1000;
    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }
    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0 ; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
                // 1. empty : sleep(1)` , `yield()` 없이 호출한다. 운영체제의 스레드 스케줄링을 따른다.
                // sleep(1); // 2. sleep : 특정 스레드를 잠시 쉬게 한다.
                Thread.yield(); // 3. yield : `yield()` 를 사용해서 다른 스레드에 실행을 양보한다.
            }
        }
    }
}
