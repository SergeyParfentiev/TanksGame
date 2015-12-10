package task2;

/**
 * Created by Byblik272 on 19/11/2015.
 */

public class LauncherShapes {
    public static void main(String[] args) {

        Drawable[] shape = new Drawable[4];
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        Square square = new Square();

        shape[0] = circle;
        shape[1] = rectangle;
        shape[2] = triangle;
        shape[3] = square;
        new ShapesTemplate(shape);


    }
}
