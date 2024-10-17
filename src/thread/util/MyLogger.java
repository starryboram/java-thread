package thread.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// 추상클래스로 만들어 추가적으로 생성하지 못하게 한다.
public abstract class MyLogger {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
    public static void log(Object obj) { // 유연하게 처리하고자 Object 형식으로 받는다.
        String time = LocalTime.now().format(formatter);
        System.out.printf("%s [%9s] %s\n", time, Thread.currentThread().getName(), obj);
    }

}
