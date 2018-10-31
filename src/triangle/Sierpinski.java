package triangle;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public class Sierpinski {

    private Sierpinski() {}

    private static long triangles = 0;

    public static double height(double length) {
        return length * Math.sqrt(3.0) / 2;
    }

    public static void filledTriangle(double x, double y, double length) {
        double dx = length / 2;
        double dy = height(length);
        double[] a = {x, x + dx, x - dx};
        double[] b = {y, y + dy, y + dy};
        StdDraw.filledPolygon(a, b);
    }

    public static void sierpinski(int n, double x, double y, double length) {
        if (n == 0) {
            return;
        }
        triangles++;
        sierpinski(n - 1, x, y + height(length), length / 2);
        sierpinski(n - 1, x + length / 2, y, length / 2);
        sierpinski(n - 1, x - length / 2, y, length / 2);
        filledTriangle(x, y, length);
    }

    private static void coordinateSystem(double scale, Color color) {
        StdDraw.setScale(0.0, 1.0);
        /* StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(-scale, 0.0, scale, 0.0);
        StdDraw.line(0.0, -scale, 0.0, scale);
        StdDraw.text(-0.05, -0.05, "0"); */
        StdDraw.setPenColor(color);
        double length = 1.0;
        double[] x = {0, length, length / 2};
        double[] y = {0, 0, height(length)};
        StdDraw.polygon(x, y);
    }

    public static void main(String[] args) {
        coordinateSystem(1.0, StdDraw.PRINCETON_ORANGE);
        double x = 0.5, y = 0.0, length = 0.5;
        double[] xp = {x - length / 2, x + length / 2, x};
        double[] yp = {y, y, y + height(length)};
        sierpinski(10, x, y, length);
        System.out.printf("%d\n", triangles);
    }

}
