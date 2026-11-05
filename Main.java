import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Лабораторная работа 2. Вариант 10");

        while (!exit) {
            System.out.println("\nВыберите задачу:");
            System.out.println("1. Задачи 1.3 и 2.2 (Ввод Имени и создание Человека)");
            System.out.println("2. Задача 2.3 ");
            System.out.println("3. Задачи 3.2, 4.9, 5.7 (Ввод координат Ломаной линии)");
            System.out.println("0. Выход");

            int choice = getValidInt(scanner, "Ваш выбор: ");

            switch (choice) {
                case 1:
                    interactivePerson(scanner);
                    break;
                case 2:
                    interactiveFamily(scanner);
                    break;
                case 3:
                    interactivePolyline(scanner);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Неверный пункт.");
            }
        }
        scanner.close();
    }

    private static void interactivePerson(Scanner scanner) {
        System.out.println("\nВвод данных для Человека");
        String surname = getString(scanner, "Введите фамилию (Enter для пропуска): ");
        String firstName = getString(scanner, "Введите имя (Enter для пропуска): ");
        String patronymic = getString(scanner, "Введите отчество (Enter для пропуска): ");
        int height = getValidInt(scanner, "Введите рост (целое число): ");

        Person p = new Person(new Name(surname, firstName, patronymic), height);
        System.out.println("Результат: " + p.toString());
    }

    //  Метод для Задачи 2.3 
    private static void interactiveFamily(Scanner scanner) {
        System.out.println("\nСоздание Первого человека");
        String s1 = getString(scanner, "Фамилия: ");
        String f1 = getString(scanner, "Имя: ");
        String p1 = getString(scanner, "Отчество: ");
        int h1 = getValidInt(scanner, "Рост: ");
        Person grandFather = new Person(new Name(s1, f1, p1), h1);

        System.out.println("\nСоздание Второго человека");
        String s2 = getString(scanner, "Фамилия (нажми Enter, чтобы унаследовать от деда): ");
        String f2 = getString(scanner, "Имя: ");
        String p2 = getString(scanner, "Отчество (нажми Enter, чтобы сгенерировать от деда): ");
        int h2 = getValidInt(scanner, "Рост: ");
        Person father = new Person(new Name(s2, f2, p2), h2, grandFather);

        System.out.println("\nСоздание Третьего человека");
        String s3 = getString(scanner, "Фамилия (нажми Enter, чтобы унаследовать от отца): ");
        String f3 = getString(scanner, "Имя: ");
        String p3 = getString(scanner, "Отчество (нажми Enter, чтобы сгенерировать от отца): ");
        int h3 = getValidInt(scanner, "Рост: ");
        Person son = new Person(new Name(s3, f3, p3), h3, father);

        System.out.println("\nСозданы:");
        System.out.println("1. " + grandFather.toString());
        System.out.println("2. " + father.toString());
        System.out.println("3. " + son.toString());
    }

    private static void interactivePolyline(Scanner scanner) {
        System.out.println("\n Создание Ломаной ");
        int count = -1;
        while (count < 0) {
            count = getValidInt(scanner, "Сколько точек будет в начальной ломаной? (0 и более): ");
        }

        Polyline poly = new Polyline();

        for (int i = 0; i < count; i++) {
            System.out.println("Ввод координат для Точки " + (i + 1) + ":");
            double x = getValidDouble(scanner, "  Координата X: ");
            double y = getValidDouble(scanner, "  Координата Y: ");
            poly.addPoints(new Point(x, y));
        }

        System.out.println("Сформирована ломаная: " + poly.toString());
        System.out.println("Ее длина: " + String.format("%.2f", poly.getLength()));

        int addCount = -1;
        while (addCount < 0) {
            addCount = getValidInt(scanner, "\nСколько новых точек хотите добавить к ней?: ");
        }

        if (addCount > 0) {
            Point[] newPoints = new Point[addCount];
            for (int i = 0; i < addCount; i++) {
                System.out.println("Ввод координат для новой Точки " + (i + 1) + ":");
                double x = getValidDouble(scanner, "  Координата X: ");
                double y = getValidDouble(scanner, "  Координата Y: ");
                newPoints[i] = new Point(x, y);
            }
            poly.addPoints(newPoints); // Добавляем массив Точек

            System.out.println("Обновленная ломаная: " + poly.toString());
            System.out.println("Новая длина: " + String.format("%.2f", poly.getLength()));
        }
    }

    // Метод для чтения строк
    private static String getString(Scanner sc, String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine().trim();
        return input.isEmpty() ? null : input;
    }

    // Безопасный ввод целых чисел
    private static int getValidInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Нужно ввести целое число.");
            }
        }
    }

    private static double getValidDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Нужно ввести число.");
            }
        }
    }
}
