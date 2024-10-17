package thread.start;

import static thread.util.MyLogger.log;

public class ManyThreadMainV2 {
// 스레드의 실행 순서는 보장되지 않는다는 점을 기억하자. (운영체제 마음대로 실행한다.)
    public static void main(String[] args) {
        log("main() start");
        HelloRunnable runnable = new HelloRunnable();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }

        log("main() end");
    }
}
