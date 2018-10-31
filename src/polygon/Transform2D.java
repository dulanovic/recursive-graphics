package polygon;

import edu.princeton.cs.algs4.StdDraw;
import java.awt.Color;

public class Transform2D {

    private Transform2D() {}

    public static double[] copy(double[] array) {
        int size = array.length;
        double[] newArray = new double[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public static void scale(double[] x, double[] y, double alpha) {
        for (int i = 0; i < x.length; i++) {
            x[i] *= alpha;
            y[i] *= alpha;
        }
    }

    public static void translate(double[] x, double[] y, double dx, double dy) {
        for (int i = 0; i < x.length; i++) {
            x[i] += dx;
            y[i] += dy;
        }
    }

    public static void rotate(double[] x, double[] y, double theta) {
        theta = Math.toRadians(theta);
        for (int i = 0; i < x.length; i++) {
            double xi = x[i];
            x[i] = x[i] * Math.cos(theta) - y[i] * Math.sin(theta);
            y[i] = y[i] * Math.cos(theta) + xi * Math.sin(theta);
        }
    }

    private static void coordinateSystem(double scale, double radius) {
        StdDraw.setScale(-scale, scale);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(radius);
        StdDraw.line(-scale, 0.0, scale, 0.0);
        StdDraw.line(0.0, -scale, 0.0, scale);
        StdDraw.text(-0.15, 0.15, "0");
        StdDraw.setPenRadius(0.003);
        for (int i = 1; i <= (int) scale; i++) {
            StdDraw.line(-i, -0.075, -i, 0.075);
            StdDraw.line(i, -0.075, i, 0.075);
            StdDraw.line(-0.075, -i, 0.075, -i);
            StdDraw.line(-0.075, i, 0.075, i);
            StdDraw.text(-i + 0.05, -0.25, "-" + i);
            StdDraw.text(i + 0.05, -0.25, "" + i);
            StdDraw.text(-0.25, -i, "-" + i);
            StdDraw.text(-0.25, i, "" + i);
        }
    }

    private static void draw(double[] x, double[] y, Color color) {
        StdDraw.setPenColor(color);
        StdDraw.setPenRadius(0.007);
        StdDraw.polygon(x, y);
    }

    public static void main(String[] args) {
        coordinateSystem(5.0, 0.005);
        double[] x = {0, 1, 1, 0};
        double[] y = {0, 0, 2, 1};
        draw(x, y, StdDraw.RED);
        double theta = -45.0;
        rotate(x, y, theta);
        draw(x, y, StdDraw.BLUE);
    }

}
