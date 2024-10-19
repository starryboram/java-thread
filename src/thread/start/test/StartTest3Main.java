package thread.start.test;

import static thread.util.MyLogger.log;

public class StartTest3Main {

    public static void main(String[] args) {
        PrintWork pw1 = new PrintWork("A", 1000);
        PrintWork pw2 = new PrintWork("B", 500);

        Thread thread1 = new Thread(pw1, "Thread-A");
        Thread thread2 = new Thread(pw2, "Thread-B");

        thread1.start();
        thread2.start();
    }

    static class PrintWork implements Runnable {

        private String content;
        private int sleepMs;

        public PrintWork(String content, int sleepMs) {
            this.content = content;
            this.sleepMs = sleepMs;
        }
        @Override
        public void run() {
           while(true) {
               log(content);
               try {
                   Thread.sleep(sleepMs);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        }
    }
}
