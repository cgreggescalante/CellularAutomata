import processing.core.PApplet;

public class Driver extends PApplet {
    Grid grid;

    int scale = 2;

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        frameRate(5);
        grid = new Grid(width / scale, height / scale, scale);
    }

    public void draw() {
        grid.update();
        grid.show(this);
//        noLoop();
    }

    public static void main(String[] args) {
        String[] pArgs = new String[]{"Driver"};

        PApplet.runSketch(pArgs, new Driver());
    }
}