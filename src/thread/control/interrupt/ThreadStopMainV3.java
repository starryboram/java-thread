package thread.control.interrupt;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

// while문 interrupt 여부 확인 코드 개선
public class ThreadStopMainV3 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(4000);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) { // 인터럽트 상태 확인용, 상태 변경 x
                log("작업 중");
            }
            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());
            try {
                log("자원 정리 시도");
                Thread.sleep(100);
                log("자원 정리 완료");
            } catch (InterruptedException e) {
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted());
            }
            log("자원 종료");
        }
    }
}
