package triangle;

import edu.princeton.cs.algs4.StdDraw;

public class Sierpinski {

    private Sierpinski() {}

    public static double height(double length) {
        return length * Math.sqrt(3.0) / 2;
    }

    public static void filledTriangle(double x, double y, double length) {
        //
    }

    public static void sierpinski(int n, double x, double y, double length) {
        //
    }

    public static void main(String[] args) {
        StdDraw.setScale(-5.0, 5.0);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(-5.0, 0.0, 5.0, 0.0);
        StdDraw.line(0.0, -5.0, 0.0, 5.0);
        StdDraw.text(-0.2, -0.2, "0");
        double[] a = {0, 3, 1.5};
        double[] b = {0, 0, 3 * Math.sqrt(3.0) / 2};
        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
        StdDraw.filledPolygon(a, b);
    }

}
