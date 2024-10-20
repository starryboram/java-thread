package thread.volatile1;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class VolatileFlagMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        log("runFlag = " + task.runFlag);
        t.start();

        sleep(1000);
        log("runFlag를 false로 변경 시도");
        task.runFlag = false;

        log("runFlag = " + task.runFlag);
        log("main 종료");
    }


    static class MyTask implements Runnable {
        //boolean runFlag = true; 메모리 가시성 문제가 발생할 수 있다. 성능을 포기하고 정확한 값을 읽기 위해서 volatile 을 사용하자.
        volatile boolean runFlag = true;

        @Override
        public void run() {
            log("task 시작");
            while (runFlag) {
                // runFlag가 false로 변하면 탈출
            }
            log("task 종료");
        }
    }
}

