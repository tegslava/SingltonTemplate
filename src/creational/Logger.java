package creational;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Logger {
    protected int num = 1;

    public void log(String msg) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        msg = String.format("%s: %s", LocalDateTime.now().format(formatter), msg);
        System.out.println("[" + num++ + "] " + msg);
    }

    // В этом поле храним ссылку на тот
    // единственный объект этого класса
    // который будем отдавать пользователям
    private static Logger logger = null;

    // Запрещаем пользователям пользоваться
    // конструктором нашего класса
    private Logger() {
    }

    // Пользователи которым нужен объект
    // нашего класса получают всегда один
    // и тот же объект, который мы храним
    // в приватном статичном поле, которое
    // мы заполняем в этом методе если оно
    // до того не было заполнено
    public static Logger getInstance() {
        if (logger == null)
            logger = new Logger();
        return logger;
    }
}
