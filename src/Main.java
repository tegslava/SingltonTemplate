import creational.Logger;
import creational.Filter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Random;

/**
 * @author Tegneryadnov_VI
 * @version 21 @ Java Логгер
 */

public class Main {
    private static Logger logger = Logger.getInstance();

    public static void main(String[] args) {
        toLog("Запускаем программу");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> rndList = new ArrayList<>();
        try {
            System.out.println();
            System.out.printf("------------------------------------------------------\n\t\tЛоггер\n"
                    + "------------------------------------------------------\n");

            while (true) {
                if (procInput(scanner, rndList))
                    break;
            }
        } finally {
            scanner.close();
            showFilteredList(rndList);
            System.out.println();
            toLog("Программа завершена.");
        }
    }

    private static void showFilteredList(ArrayList<Integer> rndList) {
    }

    private static boolean procInput(Scanner scanner, ArrayList<Integer> rndList) {
        toLog("Просим пользователя ввести входные данные для фильтрации");
        toLog("Укажите размер списка (N):");
        int elCnt = Integer.parseInt(scanner.nextLine());
        toLog(Integer.toString(elCnt));
        toLog("Укажите верхнюю границу значений элементов в списке (M):");
        int maxValue = Integer.parseInt(scanner.nextLine());
        toLog(Integer.toString(maxValue));
        createRndList(rndList, elCnt, maxValue);
        toLog(String.format("Вот случайный список: %s", rndList));
        toLog("Просим пользователя ввести входные данные для фильтрации");
        toLog("Введите порог для фильтра:");
        int f = Integer.parseInt(scanner.nextLine());
        toLog(String.format("%s", f));
        (new Filter(f)).filterOut(rndList);
        return true;
    }

    private static void createRndList(ArrayList<Integer> rndList, int elCnt, int maxValue) {
        final Random random = new Random();
        for (int i = 0; i < elCnt; i++) {
            rndList.add(random.nextInt(maxValue));
        }
    }

    private static void toLog(String msg) {
        logger.log(msg);
    }
}
