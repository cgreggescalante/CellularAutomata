package Cells;

import processing.core.PApplet;

public abstract class Cell {
    int size;
    int state;
    int[][] states;
    int x, y;

    public Cell(int size, int x, int y) {
        this.size = size;
        this.x = x;
        this.y = y;
    }

    public abstract Cell evaluate(Cell[][] set);

    public void show(PApplet sketch) {
        sketch.fill(states[state][0], states[state][1], states[state][2]);
        sketch.rect(x, y, size, size);
    }
}
