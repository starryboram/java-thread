package thread.control;

import static thread.util.MyLogger.log;

public class ThreadStateMain {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable(), "myThread");
        log("myThread.state1 = " + thread.getState()); // NEW
        log("myThread.start()");
        thread.start();
        Thread.sleep(1000); // 메인이 myThread의 로그를 찍게 한다.
        log("myThread.state3 = " + thread.getState()); // TIMED_WAITING
        Thread.sleep(4000);
        log("myThread.state5 = " + thread.getState()); // TERMINATED(실행하고 종료된 상태)
        log("end");
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                log("start");
                log("myThread.state2 = " + Thread.currentThread().getState()); // RUNNABLE
                log("sleep() start");
                Thread.sleep(3000); // 자는 상태이기 때문에, 상태 확인이 불가능하다
                log("sleep() end");
                log("myThread.state4 = " + Thread.currentThread().getState()); // RUNNABLE(자고 일어난 상태)
                log("end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
