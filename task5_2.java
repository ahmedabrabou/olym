import java.util.Scanner;

public class task5_2 {
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

        // Ввод координат точки R
        System.out.print("Введите координату x точки R: ");
        double xR = scanner.nextDouble();
        System.out.print("Введите координату y точки R: ");
        double yR = scanner.nextDouble();

        // Проверяем принадлежность точки R многоугольнику
        boolean isInPolygon = isInsidePolygon(vertices, xR, yR);
        if (isInPolygon) {
            System.out.println("Точка R принадлежит многоугольнику.");
        } else {
            System.out.println("Точка R не принадлежит многоугольнику.");
        }

        scanner.close();
    }

    public static boolean isInsidePolygon(double[][] vertices, double x, double y) {
        int n = vertices.length;
        int count = 0;

        // Проходим по всем граням многоугольника
        for (int i = 0; i < n; i++) {
            double[] currentVertex = vertices[i];
            double[] nextVertex = vertices[(i + 1) % n];

            // Проверяем пересечение луча с текущей гранью
            if ((currentVertex[1] <= y && nextVertex[1] > y ||
                    nextVertex[1] <= y && currentVertex[1] > y) &&
                    (x < (nextVertex[0] - currentVertex[0]) * (y - currentVertex[1]) / (nextVertex[1] - currentVertex[1]) + currentVertex[0])) {
                count++;
            }
        }

        // Если количество пересечений нечетное, то точка внутри многоугольника
        return count % 2 != 0;
    }
}
