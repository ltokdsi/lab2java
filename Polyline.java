import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polyline {
    private List<Point> points;

    // Конструктор Задачи 4.9 (без параметров)
    public Polyline() {
        this.points = new ArrayList<>();
    }

    // Конструктор Задачи 4.9 (набор Точек)
    public Polyline(Point... pts) {
        this.points = new ArrayList<>(Arrays.asList(pts));
    }

    // Метод Задачи 5.7 (добавление новых точек)
    public void addPoints(Point... pts) {
        this.points.addAll(Arrays.asList(pts));
    }

    // Метод Задачи 5.7 (возвращает общую длину ломаной)
    public double getLength() {
        double length = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            length += Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
        }
        return length;
    }

    // Текстовая форма для Задачи 3.2
    @Override
    public String toString() {
        return "Линия " + points.toString();
    }
}