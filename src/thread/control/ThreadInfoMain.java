package thread.control;

import thread.start.HelloRunnable;

import static thread.util.MyLogger.log;

public class ThreadInfoMain {

    public static void main(String[] args) {
        // main Thread
        // threadName은 중복될 수 있지만 ThreadId는 자바가 내부적으로 만들고 절대 중복되지 않는다.
        Thread mainThread = Thread.currentThread();
        log("mainThread = " + mainThread);
        log("mainThread.threadId() = " + mainThread.threadId());
        log("mainThread.getName() = " + mainThread.getName());
        log("mainThread.getPriority() = " + mainThread.getPriority()); // 우선순위 = 1~10 (기본값 5) / 숫자가 높을수록 우선순위가 높은 것을 의미
        log("mainThread.getThreadGroup() = " + mainThread.getThreadGroup());
        log("mainThread.getState() = " + mainThread.getState());

        // my Thread
        Thread myThread = new Thread(new HelloRunnable(), "myThread");
        log("myThread = " + myThread);
        log("myThread.threadId() = " + myThread.threadId());
        log("myThread.getName() = " + myThread.getName());
        log("myThread.getPriority() = " + myThread.getPriority());
        log("myThread.getThreadGroup() = " + myThread.getThreadGroup());
        log("myThread.getState() = " + myThread.getState());
    }
}
