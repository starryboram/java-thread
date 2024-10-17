package thread.start;

public class DaemonThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");
        DaemonThread daemonThread = new DaemonThread();
      //  daemonThread.setDaemon(true); // 기본값이 false다. true 옵션을 부여하면 데몬스레드임을 확인할 수 있다.
         daemonThread.setDaemon(false); // 이 경우에는 바로 종료되지 않고 10초정도 기다렸다가 종료됨을 확인할 수 있다.
        daemonThread.start();

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }

    static class DaemonThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run()");
            try {
                Thread.sleep(10000); // 10초간 실행
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + ": run() end");
        }
    }
}
