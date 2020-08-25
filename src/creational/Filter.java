package creational;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        logger.log("Запускаем фильтрацию");
        source.forEach(
                (n) -> {
                    if (n >= treshold) {
                        logger.log(String.format("Элемент %d проходит", n));
                        result.add(n);
                    } else {
                        logger.log(String.format("Элемент %d не проходит", n));
                    }
                }
        );
        if (result.isEmpty()) {
            logger.log("Фильтр не прошел ни один элемент");
        } else {
            logger.log(String.format("Фильтр прошел %d элемент из %d", result.size(), source.size()));
        }
        logger.log(String.format("Отфильтрованный список: %s", result));
        return result;
    }
}
