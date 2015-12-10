package PrimerPolimorfizma;

/**
 * Created by Byblik272 on 20/11/2015.
 */
public class RoundGlyph extends Glyph{
    private int radius = 5;

    public RoundGlyph(int radius) {
        System.out.println("RoundGlyph#constructor");
        draw();
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("RaundGlyph#draw()");
        System.out.println("RoundGliph [radius " + radius + "]");
    }
}
