import java.util.Scanner;

public class task5_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество вершин многоугольника (не более 10): ");
        int n = scanner.nextInt();

        if (n <= 0 || n > 10) {
            System.out.println("Неправильное количество вершин. Количество вершин должно быть от 1 до 10.");
            return; // Exit the program
        }

        double[][] vertices = new double[n][2];

        // Ввод координат для каждой вершины
        for (int i = 0; i < n; i++) {
            System.out.println("Введите координаты для вершины " + (i + 1) + ":");
            System.out.print("x" + (i + 1) + ": ");
            vertices[i][0] = scanner.nextDouble();
            System.out.print("y" + (i + 1) + ": ");
            vertices[i][1] = scanner.nextDouble();
        }

        // Вычисление площади многоугольника
        double area = calculatePolygonArea(vertices);
        System.out.println("Площадь многоугольника: " + area);

        scanner.close();
    }

    public static double calculatePolygonArea(double[][] vertices) {
        int n = vertices.length;
        double area = 0;

        // Используем формулу Гаусса для вычисления площади
        for (int i = 0; i < n; i++) {
            double[] currentVertex = vertices[i];
            double[] nextVertex = vertices[(i + 1) % n];
            area += (currentVertex[0] + nextVertex[0]) * (nextVertex[1] - currentVertex[1]);
        }

        area = 0.5 * Math.abs(area);
        return area;
    }
}
